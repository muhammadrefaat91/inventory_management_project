-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema inventory_management_system
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema inventory_management_system
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `inventory_management_system` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `inventory_management_system` ;

-- -----------------------------------------------------
-- Table `inventory_management_system`.`customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `inventory_management_system`.`customer` ;

CREATE TABLE IF NOT EXISTS `inventory_management_system`.`customer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(50) NULL,
  `last_name` VARCHAR(50) NULL,
  `address` VARCHAR(100) NULL,
  `mobile` VARCHAR(45) NULL,
  `allowed_amount` INT NULL,
  `max_number` INT NULL,
  `status` TINYINT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `inventory_management_system`.`department`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `inventory_management_system`.`department` ;

CREATE TABLE IF NOT EXISTS `inventory_management_system`.`department` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `inventory_management_system`.`employee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `inventory_management_system`.`employee` ;

CREATE TABLE IF NOT EXISTS `inventory_management_system`.`employee` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `date_of_birth` DATETIME NOT NULL,
  `user_name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `gender` TINYINT NOT NULL,
  `mobile` VARCHAR(45) NOT NULL,
  `department_id1` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_employee_department_idx` (`department_id1` ASC),
  UNIQUE INDEX `user_name_UNIQUE` (`user_name` ASC),
  CONSTRAINT `fk_employee_department`
    FOREIGN KEY (`department_id1`)
    REFERENCES `inventory_management_system`.`department` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `inventory_management_system`.`company`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `inventory_management_system`.`company` ;

CREATE TABLE IF NOT EXISTS `inventory_management_system`.`company` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `address` VARCHAR(50) NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  `phone_number` VARCHAR(50) NOT NULL,
  `fax_number` VARCHAR(50) NOT NULL,
  `registration_number` VARCHAR(50) NOT NULL,
  `logo` MEDIUMBLOB NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `inventory_management_system`.`vendor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `inventory_management_system`.`vendor` ;

CREATE TABLE IF NOT EXISTS `inventory_management_system`.`vendor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `address` VARCHAR(100) NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  `country` VARCHAR(45) NOT NULL,
  `logo` MEDIUMBLOB NOT NULL,
  `mobile` VARCHAR(45) NOT NULL,
  `notes` VARCHAR(100) NOT NULL,
  `status` TINYINT NOT NULL,
  `company_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_vendor_company1_idx` (`company_id` ASC),
  UNIQUE INDEX `company_id_UNIQUE` (`company_id` ASC),
  CONSTRAINT `fk_vendor_company1`
    FOREIGN KEY (`company_id`)
    REFERENCES `inventory_management_system`.`company` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `inventory_management_system`.`product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `inventory_management_system`.`product` ;

CREATE TABLE IF NOT EXISTS `inventory_management_system`.`product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `quantity` DOUBLE NOT NULL,
  `bar_code` VARCHAR(100) NOT NULL,
  `min_qunatity` INT NOT NULL,
  `max_quantity` INT NOT NULL,
  `cost_price` DOUBLE NOT NULL,
  `sale_price` DOUBLE NOT NULL,
  `location` VARCHAR(100) NOT NULL,
  `vendor_id` INT NULL,
  `image` MEDIUMBLOB NOT NULL,
  `status` TINYINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_product_vendor1_idx` (`vendor_id` ASC),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC),
  CONSTRAINT `fk_product_vendor1`
    FOREIGN KEY (`vendor_id`)
    REFERENCES `inventory_management_system`.`vendor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
