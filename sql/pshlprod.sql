DROP DATABASE IF EXISTS pshlprod;
CREATE DATABASE pshlprod;

USE pshlprod;

CREATE TABLE products (
	id INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(300) NOT NULL,
	category VARCHAR(25) NOT NULL,
	price FLOAT(2) NOT NULL,
	link VARCHAR(500),
	image VARCHAR(500),
	tried BOOLEAN,
	rating INT,
	review TEXT
);