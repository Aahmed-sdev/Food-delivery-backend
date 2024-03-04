# Briskit Food Delivery backend 
##### Entity Relationship Diagram 

![ErDiagram](https://github.com/Aahmed-sdev/Food-delivery-backend/assets/155801161/bc7c295f-34fb-49a2-bcf0-44d0669a333b)

##### Start local dev server
1. Change [application.properties](src/main/resources/application.properties) to configure MySQL
``` server.port=8080
spring.datasource.url=jdbc:mysql://localhost:3306/BRISKIT_DELIVERY_DB
spring.datasource.username=root
spring.datasource.password=password
```
2. Run this script to make entry in ROLE table of DB.
```
------------------------ INSERT ROLES IN DB -------------------------
-- Inserting ADMIN role
INSERT INTO ROLE (CODE, DESCRIPTION, DELTED)
SELECT 'ADMIN', 'System overseer with comprehensive access for configuration and user management.', 'N'
WHERE NOT EXISTS (SELECT 1 FROM ROLE WHERE CODE = 'ADMIN');

-- Inserting CUSTOMER role
INSERT INTO ROLE (CODE, DESCRIPTION, DELTED)
SELECT 'CUSTOMER', 'End-user role focused on seamless order placement and tracking.', 'N'
WHERE NOT EXISTS (SELECT 1 FROM ROLE WHERE CODE = 'CUSTOMER');

-- Inserting DELIVERY_PERSON role
INSERT INTO ROLE (CODE, DESCRIPTION, DELTED)
SELECT 'DELIVERY_PERSON', 'Responsible for timely and accurate delivery of orders from restaurants to customers.', 'N'
WHERE NOT EXISTS (SELECT 1 FROM ROLE WHERE CODE = 'DELIVERY_PERSON');

-- Inserting RESTAURANT role
INSERT INTO ROLE (CODE, DESCRIPTION, DELTED)
SELECT 'RESTAURANT', 'Manages menus, item availability, and order processing for effective representation and timely fulfillment.', 'N'
WHERE NOT EXISTS (SELECT 1 FROM ROLE WHERE CODE = 'RESTAURANT');
```
3. Start the spring boot server . API lists are accessible this [http://localhost:8080/swagger-ui/index.htm page](http://localhost:8080/swagger-ui/index.html) after server start.
