CREATE DATABASE IF NOT EXISTS `spring-simple-reg-process`;
USE `spring-simple-reg-process`;

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
                         `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
                         `first_name` varchar(100) NOT NULL,
                         `last_name` varchar(100) NOT NULL,
                         `email` varchar(255) NOT NULL UNIQUE,
                         `password` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

LOCK TABLES `users` WRITE;

INSERT IGNORE INTO `users` VALUES (1,'Иванов','Иван', 'admin@admin.com', 'admin');

UNLOCK TABLES;
