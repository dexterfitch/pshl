DROP DATABASE IF EXISTS pshltest;
CREATE DATABASE pshltest;

USE pshltest;

CREATE TABLE products (
	id INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(300) NOT NULL,
	category VARCHAR(20) NOT NULL,
	price DECIMAL(5,2) NOT NULL,
	link VARCHAR(500),
	image LONGTEXT,
	tried BOOLEAN,
	rating INT,
	review TEXT
);

delimiter //
CREATE PROCEDURE set_known_good_state()
BEGIN

    DELETE FROM products;
    ALTER TABLE products AUTO_INCREMENT = 1;
	
	INSERT INTO products
		(id, `name`, category, price, link, image, tried, rating, review)
	VALUES
		(
			1, 
			'Kate Aurora Autumn Harvest Pumpkin Spice Lattes Ultra Soft & Plush Oversized Accent Throw Blanket', 
			'Miscellany', 
			23.99, 
			'https://www.target.com/p/kate-aurora-autumn-harvest-pumpkin-spice-lattes-ultra-soft-plush-oversized-accent-throw-blanket/-/A-83937392', 
			'image', 
			0, 
			0, 
			''
		),
		(
			2, 
			'Hudson Baby Infant Girl Cotton Long-Sleeve Bodysuits, Pumpkin Spice Date', 
			'Clothing', 
			17.99, 
			'https://www.target.com/p/hudson-baby-infant-girl-cotton-long-sleeve-bodysuits-pumpkin-spice-date/-/A-83937084', 
			'image', 
			0, 
			0, 
			''
		),
		(
			3, 
			'Deny Designs Caroline Okun Pumpkin Spice Duvet Cover Set', 
			'Miscellany', 
			159.20, 
			'https://www.target.com/p/deny-designs-caroline-okun-pumpkin-spice-duvet-cover-set/-/A-77676611', 
			'image', 
			0, 
			0, 
			''
		),
		(
			4, 
			'Pillsbury Moist Supreme Perfectly Pumpkin Premium Cake Mix, 15.25oz', 
			'Sweet', 
			1.69, 
			'https://www.target.com/p/pillsbury-moist-supreme-perfectly-pumpkin-premium-cake-mix-15-25oz/-/A-14709668', 
			'image', 
			1, 
			4, 
			'The cake was delicious and definitely recommend. However, it reminded me more of a spice cake rather than a pumpkin spice.'
		),
		(
			5, 
			'Holiday Ornament 4.0" Pumpkin Spice Latte Fresh - Tree Ornaments', 
			'Miscellany', 
			33.99, 
			'https://www.target.com/p/holiday-ornament-4-0-pumpkin-spice-latte-fresh-tree-ornaments/-/A-81632976', 
			'image',
			0, 
			0, 
			''
		);
    
END //

delimiter ;