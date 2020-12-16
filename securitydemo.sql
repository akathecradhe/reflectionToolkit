-- The checks work now - but if more dummy data is added - this may cause the ID's to change.

USE mysql;
-- Run data.sql first


-- Notice how administrator has database privileges but has certain grants across loggingsystemdb tables.
SELECT * FROM user;
SHOW GRANTS FOR 'administrator'@'localhost';

USE LoggingSystemDB;
-- Switch to administrator now and test some of these statements and our privilege
SELECT * FROM tagform;
INSERT INTO Tags (Category, tag_name)
VALUES ('Thought Cloud','Security Demo Test');
SELECT * FROM Tags WHERE tag_name = 'Security Demo Test';

-- Prove that we don't have any other privileges
INSERT INTO Role (name)
VALUES ('Test Demo');

-- Testing Our Procedures - Deleting the previous tags we added
-- The 1st method deletes through root which is bad practise.
CALL delete_thought_cloud_bad_practise(47);
SELECT * FROM Tags WHERE tag_name = 'Security Demo Test';



-- It is now gone

INSERT INTO Tags (Category, tag_name)
VALUES ('Thought Cloud','Security Demo Test');
SELECT * FROM Tags WHERE tag_name = 'Security Demo Test';
CALL delete_thought_cloud(48);
SELECT * FROM Tags WHERE tag_name = 'Security Demo Test';

-- Testing the delete form reference function
SELECT * FROM form;
SELECT * FROM reflection;
SELECT * FROM tagform;
CALL delete_activity(1);
SELECT * FROM form;
SELECT * FROM reflection;
SELECT * FROM tagform;

-- Showing why the previous function is bad practise
REVOKE DELETE ON LoggingSystemDB.Tags FROM 'administrator'@'localhost';
FLUSH privileges;
INSERT INTO Tags (Category, tag_name)
VALUES ('Thought Cloud','Security Demo Test');
CALL delete_thought_cloud_bad_practise(49); -- This works on administrator

INSERT INTO Tags (Category, tag_name)
VALUES ('Thought Cloud','Security Demo Test');
CALL delete_thought_cloud(50); -- This doesnt

GRANT DELETE ON LoggingSystemDB.Tags TO 'administrator'@'localhost';
FLUSH privileges;



