
CREATE TABLE IF NOT EXISTS products (
    id bigserial,
    title VARCHAR(255),
    cost INTEGER NOT NULL,
    CONSTRAINT pk_products PRIMARY KEY (id)
);
INSERT INTO products (title, cost) VALUES ('Apple', 10);
INSERT INTO products (title, cost) VALUES ('Lemon', 30);
INSERT INTO products (title, cost) VALUES ('Orange', 17);
INSERT INTO products (title, cost) VALUES ('Garnet', 35);
INSERT INTO products (title, cost) VALUES ('Pear', 15);