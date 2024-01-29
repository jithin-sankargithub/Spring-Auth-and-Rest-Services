CREATE TABLE IF NOT EXISTS `person` (
  `person_id` int AUTO_INCREMENT  PRIMARY KEY,
  `name` varchar(100) NOT NULL,
  `password` varchar(200) NOT NULL,
  `email` varchar(100) NOT NULL,
  `role_id` int NOT NULL
);

CREATE TABLE IF NOT EXISTS `roles` (
  `role_id` int AUTO_INCREMENT  PRIMARY KEY,
  `role_name` varchar(100) NOT NULL
);
