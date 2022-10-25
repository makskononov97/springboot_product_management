CREATE DATABASE  ProductManagement;
USE ProductManagement;



CREATE TABLE ProductManagement.products (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(25),
  text varchar(60),
  price decimal(5,2),
  PRIMARY KEY (id)
);


