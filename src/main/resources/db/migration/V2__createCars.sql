CREATE TABLE `cars` (
  `id`                INT                   NOT NULL AUTO_INCREMENT,
  `Version`           INT                   NOT NULL DEFAULT 0,
  `make`              VARCHAR(255)          NOT NULL,
  `model`             VARCHAR(45)           NOT NULL,
  `year`              INT                   NOT NULL,
  `type`              ENUM('BASIC', 'LUX')  NOT NULL,
  `created`           TIMESTAMP             NOT NULL DEFAULT NOW(),
  `modified`          TIMESTAMP             NOT NULL DEFAULT NOW(),
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC));