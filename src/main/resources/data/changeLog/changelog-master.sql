CREATE TABLE languages (id integer generated always as identity primary key, flag text, code VARCHAR(50),
name VARCHAR(250), description text, created_by integer, updated_by integer,
created_at DATE,updated_at DATE, deleted_at DATE);