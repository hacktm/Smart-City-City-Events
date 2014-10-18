BEGIN TRANSACTION;

----------------------------------------------- Static tables ----------------------------------------------------------

----------------------------------------------- 01. AccountType --------------------------------------------------------
CREATE TABLE main.AccountType
(
  id                      SMALLINT NOT NULL,
  type                    VARCHAR(15) NOT NULL UNIQUE,

  PRIMARY KEY (id)
);

COMMENT ON TABLE main.AccountType IS 'Account types - user, institution, club, admin etc';

GRANT ALL ON main.AccountType TO cityevents_admin;

----------------------------------------------- 02. AccountPrivilege ---------------------------------------------------
CREATE TABLE main.AccountPrivilege
(
  id                      SMALLINT NOT NULL,
  authority               VARCHAR(20) NOT NULL UNIQUE,

  PRIMARY KEY (id)
);

COMMENT ON TABLE main.AccountPrivilege IS 'Account privileges - ROLE_USER, ROLE_INSTITUTION, ROLE_ADMIN';

GRANT ALL ON main.AccountPrivilege TO cityevents_admin;

----------------------------------------------- 03. EventType ----------------------------------------------------------
CREATE TABLE main.EventType
(
  id                      SMALLINT NOT NULL,
  type                    VARCHAR(15) NOT NULL UNIQUE,

  PRIMARY KEY (id)
);

COMMENT ON TABLE main.EventType IS 'Event types - music, theater, opera etc';

GRANT ALL ON main.EventType TO cityevents_admin;

----------------------------------------------- Non-static tables ------------------------------------------------------

----------------------------------------------- 04. Account ------------------------------------------------------------
CREATE TABLE main.Account
(
  id                      INTEGER NOT NULL,
  type                    SMALLINT NOT NULL CHECK (type > 0),
  name                    VARCHAR(50) UNIQUE,
  username                VARCHAR(100) NOT NULL UNIQUE,
  password                VARCHAR(200) NOT NULL, -- only for the institutions, bars and clubs
  email                   VARCHAR(100) NOT NULL UNIQUE,
  firstName               VARCHAR(100),  -- null for the institutions, bars and clubs
  lastName                VARCHAR(100),  -- null for the institutions, bars and clubs
  phoneNumber             VARCHAR(20) UNIQUE,
  failedLoginAttempts     SMALLINT DEFAULT 0,
  companyName             VARCHAR(100) UNIQUE,
  registrationDate        TIMESTAMP NOT NULL,
  parentId                INTEGER DEFAULT NULL,
  status                  VARCHAR(50) NOT NULL DEFAULT 'active',
  privilegeId             SMALLINT NOT NULL,
  country                 VARCHAR(2) DEFAULT NULL,
  county                  VARCHAR(2) DEFAULT NULL,
  language                VARCHAR(2) DEFAULT NULL,

  PRIMARY KEY (id),
  FOREIGN KEY (type) REFERENCES main.AccountType(id),
  FOREIGN KEY (parentId) REFERENCES main.Account(id),
  FOREIGN KEY (privilegeId) REFERENCES main.AccountPrivilege(id)
);

GRANT ALL ON main.Account TO cityevents_admin;

COMMENT ON TABLE main.Account IS 'The CityEvents accounts';

CREATE SEQUENCE main.Account_ID_sequence START 1 INCREMENT BY 1;

GRANT ALL ON main.Account TO cityevents_admin;
GRANT ALL ON main.Account_ID_sequence TO cityevents_admin;

----------------------------------------------- 05. Event --------------------------------------------------------------
CREATE TABLE main.Event
(
  id                      SMALLINT NOT NULL,
  eventTypeId             SMALLINT NOT NULL,
  name                    VARCHAR(50) NOT NULL,
  description             VARCHAR(300) NOT NULL,

  PRIMARY KEY (id),
  FOREIGN KEY (eventTypeId) REFERENCES main.EventType(id)
);

GRANT ALL ON main.Event TO cityevents_admin;

CREATE SEQUENCE main.Event_ID_sequence START 1 INCREMENT BY 1;

GRANT ALL ON main.Event TO cityevents_admin;
GRANT ALL ON main.Event_ID_sequence TO cityevents_admin;

COMMIT;