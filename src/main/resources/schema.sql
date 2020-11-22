SET MODE MySQL;
SET IGNORECASE=TRUE;
-- DROP SCHEMA IF EXISTS `LoggingSystemDB` ;
-- CREATE SCHEMA `LoggingSystemDB`;
-- USE LoggingSystemDB ;
-- DROP TABLE IF EXISTS event;
-- Let's create a new table now

CREATE TABLE IF NOT EXISTS `event` (
  `eventId` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `event` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  `tag` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,

  `lastupdated` TIMESTAMP NOT NULL,
  PRIMARY KEY (`eventId`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `user` (

  `username` varchar(45) UNSIGNED NOT NULL ,
  `name` VARCHAR(45) NOT NULL,
  `dateJoined` DATE  NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`username`),
  FOREIGN KEY (username) REFERENCES event(username))
ENGINE = InnoDB;
