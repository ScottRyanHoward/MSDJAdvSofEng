#Create and use the database
DROP SCHEMA IF EXISTS pos_system;
CREATE SCHEMA pos_system;
USE pos_system;

#Create tables
DROP TABLE IF EXISTS Employee;
CREATE TABLE Employee (employee_id VARCHAR(30),
					   first_name VARCHAR(30),
					   last_name VARCHAR(30),
                       address VARCHAR(30),
                       ssn INTEGER(9),
                       account_password VARCHAR(30),
                       wage FLOAT(10),
                       hours FLOAT(10),
                       PRIMARY KEY (employee_id));

DROP TABLE IF EXISTS Product;
CREATE TABLE Product (product_id VARCHAR(30),
					  product_name VARCHAR(30),
					  description VARCHAR(200),
                      category ENUM('short-sleeve', 'long-sleeve', 'beanie', 'hat', 'crew-neck', 'hoodie'),
                      price FLOAT(10),
                      quantity INTEGER(30),
                      PRIMARY KEY (product_id));
                      
DROP TABLE IF EXISTS `Transaction`;
CREATE TABLE `Transaction` (transaction_id VARCHAR(30),
					  transaction_date DATE,
                      total FLOAT(10),
                      payment FLOAT(10),
                      PRIMARY KEY (transaction_id));
                      
DROP TABLE IF EXISTS Purchased_In;
CREATE TABLE Purchased_In (transaction_id VARCHAR(30),
					  product_id VARCHAR(30),
                      amount_purchased INTEGER(10),
                      PRIMARY KEY (transaction_id, product_id),
                      FOREIGN KEY (product_id) REFERENCES Product(product_id) ON DELETE CASCADE,
                      FOREIGN KEY (transaction_id) REFERENCES `Transaction`(transaction_id) ON DELETE CASCADE);


#Insert test data
INSERT INTO Employee VALUES ('1A', 'Bob', 'Herman', '234 Street', 123456789, 'password', 15.50, 40);
INSERT INTO Employee VALUES ('1B', 'Rob', 'Herman', '234 Street', 123456789, 'iiJFlnesLKJ', 20.50, 40);
INSERT INTO Employee VALUES ('1C', 'Bill', 'Herman', '234 Street', 123456789, 'XFHEKJ', 5.50, 40);
INSERT INTO Employee VALUES ('2A', 'Jim', 'Herman', '234 Street', 123456789, 'paFDlkjsd', 10.90, 40);
INSERT INTO Employee VALUES ('3A', 'Jill', 'Herman', '234 Street', 123456789, 'Fjslnelk', 17.00, 40);

INSERT INTO Product VALUES ('1X', 'White t-shirt', 'Just a plain white T', 'short-sleeve', 15.50, 20);
INSERT INTO Product VALUES ('1Y', 'Graphic t-shirt', 'Sweet graphics on some shirts', 'short-sleeve', 20.50, 5);
INSERT INTO Product VALUES ('1Z', 'Zip-up hoodie', 'Hoodie that zips up', 'hoodie', 5.50, 10);
INSERT INTO Product VALUES ('2Z', 'Pull-over hoodie', 'Hoodie, no zipper', 'hoodie', 10.90, 0);
INSERT INTO Product VALUES ('3Z', 'Warm hat', 'A nice winter hat', 'beanie', 17.00, 40);

INSERT INTO `Transaction` VALUES ('1373747', '2017-04-03', 125.50, 130.00);

INSERT INTO Purchased_In VALUES ('1373747', '1X', 2);
INSERT INTO Purchased_In VALUES ('1373747', '1Z', 1);

#View all test data
SELECT * FROM Employee;
SELECT * FROM Product;
SELECT * FROM `Transaction`;
SELECT * FROM Purchased_In;
