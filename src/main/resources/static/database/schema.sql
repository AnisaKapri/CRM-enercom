-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `enercom` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `enercom` ;

-- -----------------------------------------------------
-- Table `enercom`.`clients`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enercom`.`clients` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `country` VARCHAR(45) NULL DEFAULT NULL,
  `company` VARCHAR(45) NOT NULL,
  `contact` VARCHAR(45) NULL DEFAULT NULL,
  `operator` VARCHAR(45) NULL DEFAULT NULL,
  `technology_deployed` VARCHAR(45) NULL DEFAULT NULL,
  `customer_ofpct` VARCHAR(45) NULL DEFAULT NULL,
  `role` VARCHAR(255) NULL DEFAULT NULL,
  `contacted_by` VARCHAR(255) NULL DEFAULT NULL,
  `phone_number` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `notes` VARCHAR(500) NULL DEFAULT NULL,
  `created` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 28
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `enercom`.`companies`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enercom`.`companies` (
  `id` BIGINT NOT NULL,
  `full_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `enercom`.`contact_persons`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enercom`.`contact_persons` (
  `id` BIGINT NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `phone_number` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `enercom`.`contacted_by`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enercom`.`contacted_by` (
  `id` BIGINT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `enercom`.`countries`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enercom`.`countries` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 60
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `enercom`.`network_operators`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enercom`.`network_operators` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `country_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_country_id`
    FOREIGN KEY (`country_id`)
    REFERENCES `enercom`.`countries` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 231
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE INDEX `fk_country_id_idx` ON `enercom`.`network_operators` (`country_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `enercom`.`operators`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enercom`.`operators` (
  `id` BIGINT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `enercom`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enercom`.`orders` (
  `id` BIGINT NOT NULL,
  `date` DATETIME NOT NULL,
  `status` BIGINT NOT NULL,
  `customer_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE INDEX `clients_id_idx` ON `enercom`.`orders` (`id` ASC, `date` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `enercom`.`products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enercom`.`products` (
  `id` BIGINT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `company` VARCHAR(45) NULL DEFAULT NULL,
  `description` VARCHAR(200) NULL DEFAULT NULL,
  `quantity_on_stock` INT NULL DEFAULT NULL,
  `quantity_on_production` INT NULL DEFAULT NULL,
  `status` SMALLINT NULL DEFAULT NULL,
  `client_id` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKkwx81wbxsqxdf2ehgxwire7hx`
    FOREIGN KEY (`client_id`)
    REFERENCES `enercom`.`clients` (`id`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE INDEX `FKkwx81wbxsqxdf2ehgxwire7hx` ON `enercom`.`products` (`client_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `enercom`.`order_product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enercom`.`order_product` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `order_id` BIGINT NOT NULL,
  `product_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_order_id`
    FOREIGN KEY (`order_id`)
    REFERENCES `enercom`.`orders` (`id`),
  CONSTRAINT `fk_product_id`
    FOREIGN KEY (`product_id`)
    REFERENCES `enercom`.`products` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE INDEX `fk_order_id` ON `enercom`.`order_product` (`order_id` ASC) VISIBLE;

CREATE INDEX `fk_product_id` ON `enercom`.`order_product` (`product_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `enercom`.`reports`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enercom`.`reports` (
  `id` BIGINT NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `file_name` VARCHAR(45) NOT NULL,
  `created` DATETIME NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `enercom`.`sales_quantity`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enercom`.`sales_quantity` (
  `id` BIGINT NOT NULL,
  `number_of_sales` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `enercom`.`sold_products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enercom`.`sold_products` (
  `id` BIGINT NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `enercom`.`technologies_deployed`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enercom`.`technologies_deployed` (
  `id` BIGINT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `years` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `enercom`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enercom`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(45) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE UNIQUE INDEX `email_UNIQUE` ON `enercom`.`users` (`email` ASC) VISIBLE;