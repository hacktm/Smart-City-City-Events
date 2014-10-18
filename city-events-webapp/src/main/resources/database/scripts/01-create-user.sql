-- 1 - create user
CREATE USER cityevents_admin WITH PASSWORD 'c1tY3vEnT5';

ALTER ROLE cityevents_admin inherit; --user will automatically have all of the privileges of the roles they belong to