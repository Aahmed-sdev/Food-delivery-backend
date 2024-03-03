-------- This script will run every server startup ------------------


------------------------ INSERT ROLE IN DB -------------------------
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
