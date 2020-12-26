package com.nsa.group6;

import com.structurizr.Workspace;
import com.structurizr.analysis.ComponentFinder;
import com.structurizr.analysis.ReferencedTypesSupportingTypesStrategy;
import com.structurizr.analysis.SourceCodeComponentFinderStrategy;
import com.structurizr.analysis.SpringComponentFinderStrategy;
import com.structurizr.api.StructurizrClient;
import com.structurizr.model.*;
import com.structurizr.view.*;
import org.junit.jupiter.api.Test;

import java.io.File;



public class GenerateModel {

    private final static int WORKSPACE_ID = 61718;
    private final static String API_KEY = "c08811ce-85f4-4a58-b470-6f622cc77d82";
    private final static String API_SECRET = "7c28f89a-81e9-4bbe-98f2-d344b2e9adbe";

    public static void main(String[] args) {
        GenerateModel structurizr = new GenerateModel();
        try {
            structurizr.generateModel();
        } catch (Exception e) {

        }
    }


    @Test
    public void generateModel() throws Exception {


        Workspace workspace = new Workspace("Reflection Toolkit", "Spring Boot Project For Our Reflection Toolkit");
        Model model = workspace.getModel();

        // create the basic model (the stuff we can't get from the code)
        // we have a system and we have (one) user.  There could be many more users/roles.
        SoftwareSystem reflectionMaker = model.addSoftwareSystem("Reflection Maker", "Reflection making made simple.");
        Person user = model.addPerson("User", "  A person who wishes to reflect on activities");
        SoftwareSystem reflectionClient = model.addSoftwareSystem("External System", "An external client that requires a source of reflections.");

        //set a relationship between the user(s) and the system.
        user.uses(reflectionMaker, "Uses");
        reflectionClient.uses(reflectionMaker, "Uses");

        //create a SystemContext view for the system
        ViewSet viewSet = workspace.getViews();
        SystemContextView contextView = viewSet.createSystemContextView(reflectionMaker, "context", "The System Context diagram for the Reflection system.");
        contextView.addAllSoftwareSystems();
        contextView.addAllPeople();

        reflectionMaker.addTags("Reflection Maker");

        Styles styles = viewSet.getConfiguration().getStyles();
        styles.addElementStyle("Reflection Maker").background("#6CB33E").color("#ffffff");
        styles.addElementStyle(Tags.PERSON).background("#519823").color("#ffffff").shape(Shape.Person);


        // Now move down a layer to the container view.

        Container webApplication = reflectionMaker.addContainer(
                "Spring Boot Application", "The web application", "Embedded web container.  Tomcat 9.0");
        Container relationalDatabase = reflectionMaker.addContainer(
                "Relational Database", "Stores information regarding users, reflections and reflection data.", "Maria DB");
        user.uses(webApplication, "Uses", "HTML/HTTP");
        reflectionClient.uses(webApplication, "Uses", "JSON/HTTP");
        webApplication.uses(relationalDatabase, "Reads from and writes to", "JPA, port 3306");

        ContainerView containerView = viewSet.createContainerView(reflectionMaker, "containers", "The Containers diagram for the Reflections System.");
        containerView.addAllPeople();
        containerView.addAllSoftwareSystems();
        containerView.addAllContainers();

        styles.addElementStyle(Tags.CONTAINER).background("#91D366").color("#ffffff");
        styles.addElementStyle("Database").shape(Shape.Cylinder);

        String path = System.getProperty("user.dir");

        System.out.println("Working Directory = " + path);


        File sourceRoot = new File(path);

        // and now automatically find all Spring @Controller, @RestController, @Component, @Service and @Repository components
        ComponentFinder componentFinder = new ComponentFinder(
                webApplication,
                "com.nsa.group6",
                new SpringComponentFinderStrategy(
                        new ReferencedTypesSupportingTypesStrategy()
                ),
                new SourceCodeComponentFinderStrategy(new File(sourceRoot, "/src/main/java/"), 150)

        );

        componentFinder.findComponents();
        System.out.println("working here");

        // connect the customer to all of the Spring MVC controllers
        webApplication.getComponents().stream()
                .filter(c -> c.getTechnology().equals(SpringComponentFinderStrategy.SPRING_MVC_CONTROLLER))
                .forEach(c -> user.uses(c, "Uses", "HTTP"));

        // connect the external service to all of the Spring Rest controllers
        webApplication.getComponents().stream()
                .filter(c -> c.getTechnology().equals(SpringComponentFinderStrategy.SPRING_REST_CONTROLLER))
                .forEach(c -> reflectionClient.uses(c, "Uses", "HTTP"));

        // connect all of the repository components to the relational database
        webApplication.getComponents().stream()
                .filter(c -> c.getTechnology().equals(SpringComponentFinderStrategy.SPRING_REPOSITORY))
                .forEach(c -> c.uses(relationalDatabase, "Reads from and writes to", "JPA"));

        //Let's see what is being scanned


        for (Component c : webApplication.getComponents()) {
            System.out.println(c.getCanonicalName() + " : " + c.getTechnology());
        }

        Component reflectionTemplate = webApplication.addComponent("ReflectionList", "Template to show Reflections", "Thymeleaf");
        reflectionTemplate.addTags("Thymeleaf");

        Component formController = webApplication.getComponentOfType("com.nsa.group6.web.FormController.");
        formController.uses(reflectionTemplate, "as view", "Spring MVC");

        Component adminController = webApplication.getComponentOfType("com.nsa.group6.web.AdminController");
        adminController.uses(reflectionTemplate, "as view", "Spring MVC");

        ComponentView componentView = viewSet.createComponentView(webApplication, "components", "The Components diagram for the Reflection Toolkit web application.");
        componentView.addAllComponents();
        componentView.addAllPeople();
        componentView.add(reflectionClient);
        componentView.add(relationalDatabase);
        componentView.enableAutomaticLayout();

        webApplication.getComponents().stream().filter(c -> c.getTechnology().equals(SpringComponentFinderStrategy.SPRING_MVC_CONTROLLER)).forEach(c -> c.addTags("Spring MVC Controller"));
        webApplication.getComponents().stream().filter(c -> c.getTechnology().equals(SpringComponentFinderStrategy.SPRING_REST_CONTROLLER)).forEach(c -> c.addTags("Spring REST Controller"));

        webApplication.getComponents().stream().filter(c -> c.getTechnology().equals(SpringComponentFinderStrategy.SPRING_SERVICE)).forEach(c -> c.addTags("Spring Service"));
        webApplication.getComponents().stream().filter(c -> c.getTechnology().equals(SpringComponentFinderStrategy.SPRING_REPOSITORY)).forEach(c -> c.addTags("Spring Repository"));
        relationalDatabase.addTags("Database");


        styles.addElementStyle("Spring REST Controller").background("#D4FFC6").color("#000000");

        styles.addElementStyle("Spring MVC Controller").background("#D4F3C0").color("#000000");
        styles.addElementStyle("Spring Service").background("#6CB33E").color("#000000");
        styles.addElementStyle("Spring Repository").background("#95D46C").color("#000000");

        styles.addElementStyle("Thymeleaf").background("#eeeeee").color("#000077").shape(Shape.RoundedBox);


        StructurizrClient structurizrClient = new StructurizrClient(API_KEY, API_SECRET);
        //structurizrClient.mergeWorkspace(41640, workspace);
        structurizrClient.putWorkspace(WORKSPACE_ID, workspace);
    }


}


