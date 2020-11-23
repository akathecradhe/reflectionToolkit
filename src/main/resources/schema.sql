SET MODE MySQL;
SET IGNORECASE=TRUE;
-- DROP SCHEMA IF EXISTS `LoggingSystemDB` ;
-- CREATE SCHEMA `LoggingSystemDB`;
-- USE LoggingSystemDB ;
-- DROP TABLE IF EXISTS event;
-- Let's create a new table now

SET MODE MySQL;
SET IGNORECASE=TRUE;
--Data for all the tags

-- Let's create a new table now
CREATE TABLE IF NOT EXISTS `event` (
   `eventId` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `eventName` VARCHAR(45) NOT NULL,
  `eventDate` DATE NOT NULL
  )
ENGINE = InnoDB;

-- REFLECTION TABLE

CREATE TABLE IF NOT EXISTS `role` (
  `roleId` int UNIQUE NOT NULL PRIMARY KEY ,
  `name` VARCHAR(45) NOT NULL
  )
ENGINE = InnoDB;

-- USER TABLE

CREATE TABLE IF NOT EXISTS `user` (
  `username` VARCHAR(45) UNIQUE NOT NULL PRIMARY KEY ,
  `name` VARCHAR(45) NOT NULL,
  `accountCreated` DATE NOT NULL
  )
ENGINE = InnoDB;

-- REFLECTION TABLE

CREATE TABLE IF NOT EXISTS `reflection` (
  `reflectionId` Int UNIQUE NOT NULL PRIMARY KEY ,
  `box1` VARCHAR(45) NOT NULL,
  `box2` VARCHAR(45) NOT NULL,
  `box3` VARCHAR(45) NOT NULL,
  `box4` VARCHAR(45) NOT NULL,
  `box5` VARCHAR(45) NOT NULL,
  `box6` VARCHAR(45) NOT NULL,
  `learningPoint1` VARCHAR(200) NOT NULL,
  `learningPoint2` VARCHAR(200) NOT NULL,
  `learningPoint3` VARCHAR(200) NOT NULL
  )
ENGINE = InnoDB;

-- Tag TABLE

CREATE TABLE IF NOT EXISTS `tags` (
  `tagId` VARCHAR(45) UNIQUE NOT NULL PRIMARY KEY ,
  `category` VARCHAR(45) NOT NULL,
  `tagename` VARCHAR(45) NOT NULL
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
  `formId` VARCHAR(45)  NOT NULL ,
  `eventId` VARCHAR(45) NOT NULL,
  `shortDescription` VARCHAR(200)  NOT NULL ,
  `roleId` VARCHAR(45) NOT NULL,
  `reflectionId` VARCHAR(45) NOT NULL
  )
ENGINE = InnoDB;


ALTER TABLE `form`
ADD FOREIGN KEY  (`eventId`) REFERENCES event(`eventId`);

ALTER TABLE `form`
ADD FOREIGN KEY  (`roleId`) REFERENCES roleId(`roleId`);

ALTER TABLE `form`
ADD FOREIGN KEY  (`reflectionId`) REFERENCES reflection(`reflectionId`);

ALTER TABLE `Tagform`
ADD FOREIGN KEY  (`formId`) REFERENCES form(`formId`);

ALTER TABLE `Tagform`
ADD FOREIGN KEY  (`tagId`) REFERENCES form(`tagId`);

