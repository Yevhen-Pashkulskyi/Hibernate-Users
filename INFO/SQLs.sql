CREATE DATABASE demo_db;

CREATE TABLE IF NOT EXISTS users
( id INTEGER NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(128) NOT NULL,
    email VARCHAR(128) NOT NULL,
    PRIMARY KEY (id)
 );

INSERT INTO Contact (firstName, email) VALUES (:firstName, :email)

FROM Contact

UPDATE Contact SET phone = :phone WHERE id = :id

DELETE FROM Contact WHERE id = :id