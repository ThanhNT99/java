-- MySQL Script generated by MySQL Workbench
-- Mon May 18 19:38:35 2020
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema car_booking_system
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema car_booking_system
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `car_booking_system` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `car_booking_system` ;

-- -----------------------------------------------------
-- Table `car_booking_system`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `car_booking_system`.`customer` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` TEXT NOT NULL,
  `email` TEXT NOT NULL,
  `phone_no` VARCHAR(11) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `car_booking_system`.`driver`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `car_booking_system`.`driver` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` TEXT NOT NULL,
  `phone_no` VARCHAR(11) NOT NULL,
  `address` TEXT NOT NULL,
  `rate` DOUBLE UNSIGNED NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `car_booking_system`.`booking`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `car_booking_system`.`booking` (
  `booking_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `pickup_city` TEXT NOT NULL,
  `pickup_location` TEXT NOT NULL,
  `drop_location` TEXT NOT NULL,
  `customer_id` INT(10) UNSIGNED NOT NULL,
  `driver_id` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`booking_id`),
  INDEX `booking_customer_FK_idx` (`customer_id` ASC) VISIBLE,
  INDEX `booking_driver_FK_idx` (`driver_id` ASC) VISIBLE,
  CONSTRAINT `booking_customer_FK`
    FOREIGN KEY (`customer_id`)
    REFERENCES `car_booking_system`.`customer` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `booking_driver_FK`
    FOREIGN KEY (`driver_id`)
    REFERENCES `car_booking_system`.`driver` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `car_booking_system`.`car`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `car_booking_system`.`car` (
  `registration_no` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `make` TEXT NOT NULL,
  `model` TEXT NOT NULL,
  `occupancy` INT(10) UNSIGNED NOT NULL,
  `driver_id` INT(10) UNSIGNED NULL DEFAULT NULL,
  PRIMARY KEY (`registration_no`),
  UNIQUE INDEX `registration_no_UNIQUE` (`registration_no` ASC) VISIBLE,
  INDEX `id_idx` (`driver_id` ASC) VISIBLE,
  CONSTRAINT `car_driver_FK`
    FOREIGN KEY (`driver_id`)
    REFERENCES `car_booking_system`.`driver` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;