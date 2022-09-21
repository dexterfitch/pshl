DROP DATABASE IF EXISTS pshlprod;
CREATE DATABASE pshlprod;

USE pshlprod;

CREATE TABLE products (
	id INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(300) NOT NULL,
	category VARCHAR(25) NOT NULL,
	price FLOAT(2) NOT NULL, -- Consider using the decimal data here https://dev.mysql.com/doc/refman/8.0/en/fixed-point-types.html
	link VARCHAR(500),
	image VARCHAR(500),
	tried BOOLEAN,
	rating INT,
	review TEXT
);