DROP TABLE IF EXISTS books;
CREATE TABLE books(id serial PRIMARY KEY, author VARCHAR(255), title VARCHAR(255), available integer);