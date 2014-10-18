BEGIN TRANSACTION;

-- 1 - account types
INSERT INTO main.AccountType (id, type) VALUES (1, 'user');
INSERT INTO main.AccountType (id, type) VALUES (2, 'institution');
INSERT INTO main.AccountType (id, type) VALUES (3, 'club');
INSERT INTO main.AccountType (id, type) VALUES (4, 'admin');

-- 2 - event types
INSERT INTO main.EventType (id, type) VALUES (1, 'music');
INSERT INTO main.EventType (id, type) VALUES (2, 'standup');
INSERT INTO main.EventType (id, type) VALUES (3, 'opera');
INSERT INTO main.EventType (id, type) VALUES (4, 'theater');

-- 3 - account privileges
INSERT INTO main.AccountPrivilege (id, authority) values (1, 'ROLE_USER');
INSERT INTO main.AccountPrivilege (id, authority) values (2, 'ROLE_INSTITUTION');
INSERT INTO main.AccountPrivilege (id, authority) values (3, 'ROLE_ADMIN');

COMMIT;
