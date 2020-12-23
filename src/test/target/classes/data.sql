DROP TABLE IF EXISTS orders;

CREATE TABLE orders (
  id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  orderId VARCHAR(250) NOT NULL,
  totalAmount VARCHAR(250) NOT NULL,
  orderStatus VARCHAR(250) NOT NULL
  );
 INSERT INTO  orders (id, orderId, totalAmount, orderStatus ) VALUES (101,'order1',5000,'shipped');
INSERT INTO  orders (id, orderId, totalAmount, orderStatus) VALUES (102,'order2',4000,'delivered');
INSERT INTO  orders (id, orderId, totalAmount, orderStatus) VALUES (103,'order3',800,'shipped');

 
