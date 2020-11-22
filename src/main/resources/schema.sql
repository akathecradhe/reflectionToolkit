DROP SCHEMA IF EXISTS `LoggingSystemDB` ;
CREATE SCHEMA `LoggingSystemDB`;
USE LoggingSystemDB ;
DROP TABLE IF EXISTS event;
-- Let's create a new table now

CREATE TABLE IF NOT EXISTS `event` (
  `eventId` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `event` VARCHAR(45) NOT NULL,
  `description` VARCHAR(10) NOT NULL,
  `role` VARCHAR(100) NOT NULL,

  `lastupdated` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;
