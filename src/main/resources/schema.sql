SET MODE MySQL;
SET IGNORECASE=TRUE;
-- DROP SCHEMA IF EXISTS `LoggingSystemDB` ;
-- CREATE SCHEMA `LoggingSystemDB`;
-- USE LoggingSystemDB ;
-- DROP TABLE IF EXISTS event;
-- Let's create a new table now

CREATE TABLE IF NOT EXISTS `event` (
  `eventId` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `event` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  `tag` VARCHAR(45) NOT NULL,
  `username` CHAR(45) NOT NULL ,
  `dimensionID` int UNIQUE ,
  `lastupdated` TIMESTAMP NOT NULL
  )
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `users` (
  `username` CHAR(45) UNIQUE NOT NULL PRIMARY KEY ,
  `firstName` VARCHAR(45) NOT NULL,
  `dateJoined` DATE  NOT NULL,
  `password` VARCHAR(45) NOT NULL
  )
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `uKPSFdimensions` (
  `dimensionID` int UNIQUE NOT NULL PRIMARY KEY auto_increment,
  `dimensionType` VARCHAR(45) NOT NULL,
  `dimensionKey` VARCHAR(45)  NOT NULL,
  `dimensionName` VARCHAR(1000) NOT NULL,
  `dimensionDescription` VARCHAR(3000) NOT NULL
  )
ENGINE = InnoDB;

ALTER TABLE `event`
ADD FOREIGN KEY  (`dimensionID`) REFERENCES uKPSFdimensions(`dimensionID`);

ALTER TABLE `event`
ADD FOREIGN KEY  (`username`) REFERENCES users(`username`);
