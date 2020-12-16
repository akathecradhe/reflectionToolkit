$(document).ready(function() {
    function menuSelect(element) {
        document.getElementById('reflection').style.display = 'none';
        document.getElementById('learningpoints').style.display = 'none';
        document.getElementById(element).style.display = 'block';
        document.documentElement.scrollTop = 0;
    }

    $('form#form').submit(function() {
        $(window).unbind('beforeunload');
    });

    $(window).bind('beforeunload', function(){
        return 'Leaving will erase your current progress, are you sure you want to leave?';
    });

    function uncheck(checkbox1, checkbox2, checkbox3, checkbox4, checkbox5, checkbox6) {
        let checkBox = document.getElementById("None");
        if (checkBox.checked == true) ;
        {
            document.getElementById(checkbox1).checked = false;
            document.getElementById(checkbox2).checked = false;
            document.getElementById(checkbox3).checked = false;
            document.getElementById(checkbox4).checked = false;
            document.getElementById(checkbox5).checked = false;
            document.getElementById(checkbox6).checked = false;
        }
    }

    function uncheckNone() {
        document.getElementById('None').checked = false;
    }

    $(function () {
        $('[data-toggle="tooltip"]').tooltip()
    })

    $('.navbar-collapse a').click(function () {
        $(".navbar-collapse").collapse('hide');
    });

    document.getElementById("reflectionTitle").onclick = function () {
        menuSelect('reflection')
    };
    document.getElementById("actionTitle").onclick = function () {
        menuSelect('learningpoints')
    };
    document.getElementById("submitTitle").onclick = function () {
        document.getElementById('submitBtn').click()
    };
    document.getElementById("nextBtn").onclick = function () {
        document.getElementById('reflection').style.display = 'none';
        document.getElementById('learningpoints').style.display = 'block';
        document.documentElement.scrollTop = 0;
    };

    document.getElementById("actionBack").onclick = function () {
        document.getElementById('learningpoints').style.display = 'none';
        document.getElementById('reflection').style.display = 'block';
        document.documentElement.scrollTop = 0
    };

    var box1 = document.getElementById("box1");
    var box2 = document.getElementById("box2");
    var box3 = document.getElementById("box3");
    var box4 = document.getElementById("box4");
    var box5 = document.getElementById("box5");
    var box6 = document.getElementById("box6");
    var lp1 = document.getElementById("learningPoint1");
    document.getElementById("form").onsubmit = function(){return validate()};

    function validate() {
        if (box1.value == "" || box2.value == "" ||box3.value == "" ||box4.value == "" ||box5.value == "" ||box6.value == ""){
            alert("Missing Reflection");
            return false;
        } else if (lp1.value=="") {
            alert("Fill in at least 1 action point");
            return false;
        } else{
            return confirm("Submit form?")

    }};





});