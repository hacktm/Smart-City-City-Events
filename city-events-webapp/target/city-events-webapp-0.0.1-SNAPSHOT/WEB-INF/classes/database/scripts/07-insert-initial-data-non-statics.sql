BEGIN TRANSACTION;

-------------------------------------------------- Initial accounts ----------------------------------------------------

INSERT INTO main.Account (id, type, privilegeId, userName, email, country, language, parentId, firstName, lastName, status, registrationDate, password)
  VALUES (99999, 1, 1, 'bogdan.solga', 'bogdan.solga@gmail.com', 'ro', 'ro', null, 'Bogdan', 'Solga', 'active', 'now()', 'c1ty3vent5');

COMMIT;