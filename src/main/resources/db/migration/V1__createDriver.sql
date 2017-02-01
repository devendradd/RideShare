CREATE TABLE `drivers` (
  `id`          int(11)               NOT NULL AUTO_INCREMENT,
  `version`     int(11)               NOT NULL DEFAULT '0',
  `name`        varchar(255)          NOT NULL,
  `age`         int(11)               NOT NULL,
  `gender`      enum('MALE','FEMALE') NOT NULL,
  `tickets`     int(11)               DEFAULT '0',
  `created`     timestamp             NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modified`    timestamp             NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;