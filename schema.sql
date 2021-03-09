USE mysql;
DROP USER IF EXISTS 'administrator'@'localhost';



SELECT * FROM user;

-- Check the current user

SELECT user();

-- Create an administrator user who can connect from localhost ONLY
CREATE USER 'administrator'@'localhost' IDENTIFIED BY 'apassword';

SHOW GRANTS FOR 'administrator'@'localhost';
SHOW GRANTS FOR 'administrator'@'localhost';



FLUSH PRIVILEGES;


ALTER USER 'administrator'@'localhost' PASSWORD EXPIRE INTERVAL 15 DAY;


FLUSH PRIVILEGES;

SELECT * FROM user;



DROP SCHEMA IF EXISTS `LoggingSystemDB` ;
CREATE SCHEMA `LoggingSystemDB`;
USE LoggingSystemDB ;
DROP TABLE IF EXISTS Event;
-- Let's create a new table now
-- Data for all the tags

-- Let's create a new table now
CREATE TABLE IF NOT EXISTS `Event` (
   `eventId` int UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `Name` VARCHAR(45) NOT NULL
  )
ENGINE = InnoDB;

-- REFLECTION TABLE

CREATE TABLE IF NOT EXISTS `Role` (
  `roleId` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL
  )
ENGINE = InnoDB;

-- USER TABLE

CREATE TABLE IF NOT EXISTS `User` (
  `username` VARCHAR(45) NOT NULL PRIMARY KEY,
  `name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(150) NOT NULL,
  `roles` VARCHAR(45) NOT NULL,
  `account_created` DATE NOT NULL
  )
ENGINE = InnoDB;

-- REFLECTION TABLE

CREATE TABLE IF NOT EXISTS `Reflection` (
  `reflectionId` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  -- CHANGE THESE BACK TO 100 CHARACTERS AFTER DEMO
  `box1` VARCHAR(100) NOT NULL,
  `box2` VARCHAR(100) NOT NULL,
  `box3` VARCHAR(100) NOT NULL,
  `box4` VARCHAR(100) NOT NULL,
  `box5` VARCHAR(100) NOT NULL,
  `box6` VARCHAR(100) NOT NULL,
  `learning_point1` VARCHAR(140) NOT NULL,
  `learning_point2` VARCHAR(140),
  `learning_point3` VARCHAR(140)
  )
ENGINE = InnoDB;

-- Action Points TABLE
CREATE TABLE IF NOT EXISTS `Action_points` (
  `actionID` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `learning_point` VARCHAR(140),
  `checked` VARCHAR(1) NOT NULL
  )
ENGINE = InnoDB;

-- Tag TABLE

CREATE TABLE IF NOT EXISTS `Tags` (
  `tagId` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `category` VARCHAR(45) NOT NULL,
  `tag_name` VARCHAR(200) NOT NULL,
  `shortened_tag` VARCHAR(5),
  `description` VARCHAR(1500)

  )
ENGINE = InnoDB;

-- Tag form table

CREATE TABLE IF NOT EXISTS `Tagform` (
  `tagId` int  NOT NULL ,
  `formId` int NOT NULL
  )
ENGINE = InnoDB;

-- form-table
CREATE TABLE IF NOT EXISTS `Form` (
  `formId` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `eventId` int UNSIGNED NOT NULL,
  `short_description` VARCHAR(200)  NOT NULL ,
  `roleId` int NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `reflectionId` int,
  `last_edited` TIMESTAMP NOT NULL,
  `activity_date` DATE NOT NULL
  )
ENGINE = InnoDB;


ALTER TABLE `Form`
ADD FOREIGN KEY  (`eventId`) REFERENCES Event(`eventId`);

ALTER TABLE `Form`
ADD FOREIGN KEY  (`username`) REFERENCES User(`username`);

ALTER TABLE `Form`
ADD FOREIGN KEY  (`roleId`) REFERENCES Role(`roleId`);

ALTER TABLE `Form`
ADD FOREIGN KEY  (`reflectionId`) REFERENCES Reflection(`reflectionId`);

ALTER TABLE `Tagform`
ADD FOREIGN KEY  (`formId`) REFERENCES Form(`formId`);

ALTER TABLE `Tagform`
ADD FOREIGN KEY  (`tagId`) REFERENCES Tags(`tagId`);

USE mysql;

GRANT SELECT ON LoggingSystemDB.User to 'administrator'@'localhost';
GRANT SELECT ON LoggingSystemDB.Role to 'administrator'@'localhost';
GRANT SELECT ON LoggingSystemDB.Event to 'administrator'@'localhost';
GRANT SELECT,INSERT,DELETE, UPDATE ON LoggingSystemDB.Tagform to 'administrator'@'localhost';
GRANT SELECT,INSERT,UPDATE,DELETE ON LoggingSystemDB.Reflection to 'administrator'@'localhost';
GRANT SELECT,INSERT,UPDATE,DELETE ON LoggingSystemDB.Action_points to 'administrator'@'localhost';
GRANT SELECT,INSERT,UPDATE,DELETE ON LoggingSystemDB.Form to 'administrator'@'localhost';
GRANT SELECT, INSERT, DELETE, UPDATE ON LoggingSystemDB.Tags to 'administrator'@'localhost';


DELIMITER //

USE LoggingSystemDB //

CREATE DEFINER = `root`@`localhost`
PROCEDURE  delete_thought_cloud_bad_practise(IN id int)
BEGIN
  IF ((SELECT category FROM Tags WHERE tagid = id) = "Thought Cloud") THEN
    DELETE FROM LoggingSystemDB.Tags WHERE tagId = id;
  END IF;
END//

CREATE DEFINER = `root`@`localhost`
PROCEDURE  delete_thought_cloud(IN id int)
SQL SECURITY INVOKER
BEGIN
  IF ((SELECT category FROM Tags WHERE tagid = id) = "Thought Cloud") THEN
    DELETE FROM LoggingSystemDB.Tags WHERE tagId = id;
  END IF;

END//
DELIMITER ;
GRANT EXECUTE ON PROCEDURE LoggingSystemDB.delete_thought_cloud_bad_practise TO 'administrator'@'localhost';


CREATE TRIGGER delete_associated_tags
BEFORE DELETE
ON Tags FOR EACH ROW
DELETE FROM Tagform WHERE tagId = old.tagId;


DELIMITER //

CREATE DEFINER = `root`@`localhost`
PROCEDURE  delete_activity(IN id int)
SQL SECURITY INVOKER
BEGIN
DELETE FROM LoggingSystemDB.Tagform WHERE formId = id;
  DELETE FROM LoggingSystemDB.Form WHERE formId = id;
  SET @list = (SELECT reflectionId FROM LoggingSystemDB.Form WHERE formId = id);
  DELETE FROM LoggingSystemDB.Reflection WHERE (reflectionId = @list);
END//

DELIMITER ;
GRANT EXECUTE ON PROCEDURE LoggingSystemDB.delete_activity TO 'administrator'@'localhost';
FLUSH PRIVILEGES;
USE LoggingSystemDB;




