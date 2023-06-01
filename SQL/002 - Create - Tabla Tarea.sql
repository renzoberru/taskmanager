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