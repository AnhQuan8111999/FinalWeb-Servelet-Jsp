

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `price` varchar(45) DEFAULT NULL,
  `image` varchar(450) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_product_idx` (`category_id`),
  CONSTRAINT `fk_product` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) 
) AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `image` varchar(450) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `login_counter` int(11) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `Bill`;
CREATE TABLE `Bill` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `buyer_id` int(11) DEFAULT NULL,
  `buy_date` DATE DEFAULT NULL,
  `price_total` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_bill_user_idx` (`buyer_id`),
  CONSTRAINT `fk_bill_user` FOREIGN KEY (`buyer_id`) REFERENCES `user` (`id`) 
) AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `bill_product`;
CREATE TABLE `bill_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `unit_price` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `bill_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_bill_pro_1_idx` (`bill_id`),
  KEY `fk_bill_pro_2_idx` (`product_id`),
  CONSTRAINT `fk_bill_pro_1` FOREIGN KEY (`bill_id`) REFERENCES `Bill` (`id`) ,
  CONSTRAINT `fk_bill_pro_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) 
) AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;
