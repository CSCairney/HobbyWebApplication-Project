DROP TABLE IF EXISTS `anime`;

CREATE TABLE `anime` (
	`id` BIGINT AUTO_INCREMENT,
	`english_title` VARCHAR(255) UNIQUE NOT NULL,
	`japanese_title` VARCHAR(255) UNIQUE NOT NULL,
	`seasons` INT NOT NULL,
	`episodes` INT NOT NULL,
	`rating` INT NOT NULL,
	`complete` BOOLEAN NOT NULL,
	PRIMARY KEY(`id`)

);