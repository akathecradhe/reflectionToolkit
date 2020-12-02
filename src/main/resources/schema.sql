SET MODE MySQL;
SET IGNORECASE=TRUE;
-- DROP SCHEMA IF EXISTS `LoggingSystemDB` ;
-- CREATE SCHEMA `LoggingSystemDB`;
-- USE LoggingSystemDB ;
-- DROP TABLE IF EXISTS event;
-- Let's create a new table now
--Data for all the tags

-- Let's create a new table now
CREATE TABLE IF NOT EXISTS `event` (
   `eventId` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `Name` VARCHAR(45) NOT NULL,
  `event_date` DATE NOT NULL
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
  `reflectionId` Int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `box1` VARCHAR(100) NOT NULL,
  `box2` VARCHAR(100) NOT NULL,
  `box3` VARCHAR(100) NOT NULL,
  `box4` VARCHAR(100) NOT NULL,
  `box5` VARCHAR(100) NOT NULL,
  `box6` VARCHAR(100) NOT NULL,
  `learning_point1` VARCHAR(140) NOT NULL,
  `learning_point2` VARCHAR(140) NOT NULL,
  `learning_point3` VARCHAR(140) NOT NULL
  )
ENGINE = InnoDB;

-- Tag TABLE

CREATE TABLE IF NOT EXISTS `tags` (
  `tagId` VARCHAR(45) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `category` VARCHAR(45) NOT NULL,
  `tag_name` VARCHAR(45) NOT NULL
  )
ENGINE = InnoDB;

-- Tag form table

CREATE TABLE IF NOT EXISTS `tagForm` (
  `tagId` VARCHAR(45)  NOT NULL ,
  `formId` VARCHAR(45) NOT NULL
  )
ENGINE = InnoDB;

-- form-table
CREATE TABLE IF NOT EXISTS `form` (
  `formId` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `eventId` VARCHAR(45) NOT NULL,
  `short_description` VARCHAR(200)  NOT NULL ,
  `roleId` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `reflectionId` VARCHAR(45) NOT NULL,
  `last_edited` TIMESTAMP NOT NULL
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

ALTER TABLE `Tagform`
ADD FOREIGN KEY  (`formId`) REFERENCES form(`formId`);

ALTER TABLE `Tagform`
ADD FOREIGN KEY  (`tagId`) REFERENCES tags(`tagId`);

