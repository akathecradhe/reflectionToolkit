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


-- ALTER USER 'administrator'@'localhost' PASSWORD EXPIRE INTERVAL 15 DAY;


FLUSH PRIVILEGES;

SELECT * FROM user;



DROP SCHEMA IF EXISTS `loggingsystemdb` ;
CREATE SCHEMA `loggingsystemdb`;
USE loggingsystemdb ;
DROP TABLE IF EXISTS Event;
-- Let's create a new table now
-- Data for all the tags

-- Let's create a new table now
CREATE TABLE IF NOT EXISTS `event` (
   `eventId` int UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `Name` VARCHAR(45) NOT NULL
  )
ENGINE = InnoDB;

-- REFLECTION TABLE

CREATE TABLE IF NOT EXISTS `role` (
  `roleId` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL
  )
ENGINE = InnoDB;

-- USER TABLE

CREATE TABLE IF NOT EXISTS `user` (
  `username` VARCHAR(45) NOT NULL PRIMARY KEY,
  `name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(150) NOT NULL,
  `roles` VARCHAR(45) NOT NULL,
  `account_created` DATE NOT NULL
  )
ENGINE = InnoDB;

-- REFLECTION TABLE

CREATE TABLE IF NOT EXISTS `reflection` (
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
CREATE TABLE IF NOT EXISTS `action_points` (
  `actionID` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `learning_point` VARCHAR(140),
  `checked` VARCHAR(1) NOT NULL
  )
ENGINE = InnoDB;

-- Tag TABLE

CREATE TABLE IF NOT EXISTS `tags` (
  `tagId` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `category` VARCHAR(45) NOT NULL,
  `tag_name` VARCHAR(200) NOT NULL,
  `shortened_tag` VARCHAR(5),
  `description` VARCHAR(1500)

  )
ENGINE = InnoDB;

-- Tag form table

CREATE TABLE IF NOT EXISTS `tagform` (
  `tagId` int  NOT NULL ,
  `formId` int NOT NULL
  )
ENGINE = InnoDB;

-- form-table
CREATE TABLE IF NOT EXISTS `form` (
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


ALTER TABLE `form`
ADD FOREIGN KEY  (`eventId`) REFERENCES event(`eventId`);

ALTER TABLE `form`
ADD FOREIGN KEY  (`username`) REFERENCES user(`username`);

ALTER TABLE `form`
ADD FOREIGN KEY  (`roleId`) REFERENCES role(`roleId`);

ALTER TABLE `form`
ADD FOREIGN KEY  (`reflectionId`) REFERENCES reflection(`reflectionId`);

ALTER TABLE `tagform`
ADD FOREIGN KEY  (`formId`) REFERENCES form(`formId`);

ALTER TABLE `tagform`
ADD FOREIGN KEY  (`tagId`) REFERENCES tags(`tagId`);

USE mysql;

GRANT SELECT ON loggingsystemdb.user to 'administrator'@'localhost';
GRANT SELECT ON loggingsystemdb.role to 'administrator'@'localhost';
GRANT SELECT ON loggingsystemdb.event to 'administrator'@'localhost';
GRANT SELECT,INSERT,DELETE, UPDATE ON loggingsystemdb.tagform to 'administrator'@'localhost';
GRANT SELECT,INSERT,UPDATE,DELETE ON loggingsystemdb.reflection to 'administrator'@'localhost';
GRANT SELECT,INSERT,UPDATE,DELETE ON loggingsystemdb.action_points to 'administrator'@'localhost';
GRANT SELECT,INSERT,UPDATE,DELETE ON loggingsystemdb.form to 'administrator'@'localhost';
GRANT SELECT, INSERT, DELETE, UPDATE ON loggingsystemdb.tags to 'administrator'@'localhost';


DELIMITER //

USE loggingsystemdb //

CREATE DEFINER = `root`@`localhost`
PROCEDURE  delete_thought_cloud_bad_practise(IN id int)
BEGIN
  IF ((SELECT category FROM tags WHERE tagid = id) = "Thought Cloud") THEN
    DELETE FROM loggingsystemdb.tags WHERE tagId = id;
  END IF;
END//

CREATE DEFINER = `root`@`localhost`
PROCEDURE  delete_thought_cloud(IN id int)
SQL SECURITY INVOKER
BEGIN
  IF ((SELECT category FROM tags WHERE tagid = id) = "Thought Cloud") THEN
    DELETE FROM loggingsystemdb.tags WHERE tagId = id;
  END IF;

END//
DELIMITER ;
GRANT EXECUTE ON PROCEDURE loggingsystemdb.delete_thought_cloud_bad_practise TO 'administrator'@'localhost';


CREATE TRIGGER delete_associated_tags
BEFORE DELETE
ON tags FOR EACH ROW
DELETE FROM tagform WHERE tagId = old.tagId;


DELIMITER //

CREATE DEFINER = `root`@`localhost`
PROCEDURE  delete_activity(IN id int)
SQL SECURITY INVOKER
BEGIN
DELETE FROM loggingsystemdb.tagform WHERE formId = id;
  DELETE FROM loggingsystemdb.form WHERE formId = id;
  SET @list = (SELECT reflectionId FROM loggingsystemdb.form WHERE formId = id);
  DELETE FROM loggingsystemdb.reflection WHERE (reflectionId = @list);
END//

DELIMITER ;
GRANT EXECUTE ON PROCEDURE loggingsystemdb.delete_activity TO 'administrator'@'localhost';
FLUSH PRIVILEGES;
USE loggingsystemdb;




