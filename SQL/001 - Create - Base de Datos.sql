-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema task_manager_db
-- -----------------------------------------------------
-- Base de datos para el administrador de tareas
DROP SCHEMA IF EXISTS `task_manager_db` ;

-- -----------------------------------------------------
-- Schema task_manager_db
--
-- Base de datos para el administrador de tareas
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `task_manager_db` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;
USE `task_manager_db` ;

-- -----------------------------------------------------
-- Table `task_manager_db`.`Tarea`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `task_manager_db`.`Tarea` ;

CREATE TABLE IF NOT EXISTS `task_manager_db`.`Tarea` (
  `identificador` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(255) NOT NULL,
  `fechaCreacion` DATETIME NULL DEFAULT now(),
  `vigente` BIT(1) NULL DEFAULT 1,
  PRIMARY KEY (`identificador`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
