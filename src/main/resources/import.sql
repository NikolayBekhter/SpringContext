
CREATE TABLE IF NOT EXISTS products (id bigserial, title VARCHAR(255), cost INTEGER NOT NULL, CONSTRAINT pk_products PRIMARY KEY (id));
INSERT INTO products (title, cost) VALUES ('Apple', 10), ('Lemon', 30), ('Orange', 17), ('Garnet', 35), ('Pear', 15);

CREATE TABLE IF NOT EXISTS consumers (id bigserial, name VARCHAR(255), CONSTRAINT pk_consumers PRIMARY KEY (id));
INSERT INTO consumers (name) VALUES ('Ivan'), ('Leonid'), ('Danil'), ('Alex'), ('Pavel');

