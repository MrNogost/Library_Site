CREATE TABLE IF NOT EXISTS inventory (
    name VARCHAR(255),
    author VARCHAR(255),
    isbn INT PRIMARY KEY,
    qty INT
);