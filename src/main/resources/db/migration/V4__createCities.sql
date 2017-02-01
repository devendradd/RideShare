CREATE TABLE `cities` (
  `id`          int(11)               NOT NULL AUTO_INCREMENT,
  `version`     int(11)               NOT NULL DEFAULT '0',
  `name`        varchar(255)          NOT NULL,
  `state`       VARCHAR(255)          NOT NULL,
  `day_rate`    DECIMAL(45)           NOT NULL,
  `night_rate`  DECIMAL(45)           NOT NULL,
  `created`     timestamp             NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modified`    timestamp             NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;