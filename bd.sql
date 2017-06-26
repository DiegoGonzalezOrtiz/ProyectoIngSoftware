CREATE DATABASE mydb;
USE mydb;

-- Tabla ROL

-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `mydb`.`ROL` (

`id_rol` INT UNSIGNED NOT NULL AUTO_INCREMENT,

`nombre` VARCHAR(30) NOT NULL,

`descripcion` VARCHAR(100) NULL,

PRIMARY KEY (`id_rol`))

ENGINE = InnoDB;

-- -----------------------------------------------------

-- Tabla USUARIO

-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `mydb`.`USUARIO` (

`id_usuario` INT UNSIGNED NOT NULL AUTO_INCREMENT,

`id_rol` INT UNSIGNED NOT NULL,

`nombre` VARCHAR(30) NOT NULL,

`app` VARCHAR(30) NULL,

`apm` VARCHAR(30) NULL,

`run` VARCHAR(45) NOT NULL,

`pass` VARCHAR(45) NOT NULL,

PRIMARY KEY (`id_usuario`),

CONSTRAINT `fk_USUARIO_ROL1`

FOREIGN KEY (`id_rol`)

REFERENCES `mydb`.`ROL` (`id_rol`)

ON DELETE NO ACTION

ON UPDATE NO ACTION)

ENGINE = InnoDB;

CREATE INDEX `fk_USUARIO_ROL1_idx` ON `mydb`.`USUARIO` (`id_rol` ASC);

-- -----------------------------------------------------

-- Tabla CATEGORIA

-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `mydb`.`CATEGORIA` (

`id_categoria` INT UNSIGNED NOT NULL AUTO_INCREMENT,

`descripcion` VARCHAR(45) NOT NULL,

PRIMARY KEY (`id_categoria`))

ENGINE = InnoDB;

-- -----------------------------------------------------

-- Tabla PRODUCTO

-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `mydb`.`PRODUCTO` (

`id_producto` INT NOT NULL AUTO_INCREMENT,

`id_categoria` INT UNSIGNED NOT NULL,

`nombre` VARCHAR(30) NOT NULL,

`stock` INT NOT NULL,

PRIMARY KEY (`id_producto`),

CONSTRAINT `fk_PRODUCTO_CATEGORIA1`

FOREIGN KEY (`id_categoria`)

REFERENCES `mydb`.`CATEGORIA` (`id_categoria`)

ON DELETE NO ACTION

ON UPDATE NO ACTION)

ENGINE = InnoDB;

CREATE INDEX `fk_PRODUCTO_CATEGORIA1_idx` ON `mydb`.`PRODUCTO` (`id_categoria`

ASC);

-- -----------------------------------------------------

-- Tabla SOLICITUD

-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `mydb`.`SOLICITUD` (

`id_usuario` INT UNSIGNED NOT NULL,

`PRODUCTO_id_producto` INT NOT NULL,

`cantidad` INT NOT NULL,

`fecha_entrega` DATE NULL,

`fecha_solicitud` DATE NOT NULL,

`estado` VARCHAR(20) NOT NULL,

PRIMARY KEY (`id_usuario`, `PRODUCTO_id_producto`),

CONSTRAINT `fk_SOLICITUD_USUARIO1`

FOREIGN KEY (`id_usuario`)

REFERENCES `mydb`.`USUARIO` (`id_usuario`)

ON DELETE NO ACTION

ON UPDATE NO ACTION,

CONSTRAINT `fk_SOLICITUD_PRODUCTO1`

FOREIGN KEY (`PRODUCTO_id_producto`)

REFERENCES `mydb`.`PRODUCTO` (`id_producto`)

ON DELETE NO ACTION

ON UPDATE NO ACTION)

ENGINE = InnoDB;

CREATE INDEX `fk_SOLICITUD_PRODUCTO1_idx` ON `mydb`.`SOLICITUD`

(`PRODUCTO_id_producto` ASC);


-- -----------------------------------------------------

-- Tabla MOTIVO_BAJA

-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `mydb`.`MOTIVO_BAJA` (

`id_motivo_baja` INT NOT NULL AUTO_INCREMENT,

`id_producto` INT NOT NULL,

`descripcion` VARCHAR(300) NOT NULL,

`cantidad` INT NOT NULL,

PRIMARY KEY (`id_motivo_baja`),

CONSTRAINT `fk_MOTIVO_BAJA_PRODUCTO1`

FOREIGN KEY (`id_producto`)

REFERENCES `mydb`.`PRODUCTO` (`id_producto`)

ON DELETE NO ACTION

ON UPDATE NO ACTION)

ENGINE = InnoDB;

CREATE INDEX `fk_MOTIVO_BAJA_PRODUCTO1_idx` ON `mydb`.`MOTIVO_BAJA`

(`id_producto` ASC);

USE `mydb` ;