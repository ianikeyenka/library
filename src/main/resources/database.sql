DROP
DATABASE IF EXISTS library;

CREATE
DATABASE library;
USE
library;

CREATE TABLE books
(
    id     int NOT NULL AUTO_INCREMENT,
    title  varchar(60),
    author varchar(30),
    PRIMARY KEY (id)
);

CREATE TABLE users
(
    id           int NOT NULL AUTO_INCREMENT,
    name         varchar(15),
    surname      varchar(30),
    phone_number varchar(16),
    PRIMARY KEY (id)
);

CREATE TABLE borrow_history
(
    id       int NOT NULL AUTO_INCREMENT,
    user_id  int,
    book_id  int,
    returned BOOLEAN,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (book_id) REFERENCES books (id)
);

INSERT INTO books (id, title, author)
VALUES (1, 'Big Little Lies', 'Liana Moriarty');

INSERT INTO books (id, title, author)
VALUES (2, 'The Lord of the Rings', 'J. R. R. Tolkien');

INSERT INTO books (id, title, author)
VALUES (3, 'Woman in Black', 'Susan Hill');

INSERT INTO users (id, name, surname, phone_number)
VALUES (1, 'Hope', 'Waters', '+375-44-704-3562');

INSERT INTO users (id, name, surname, phone_number)
VALUES (2, 'Eric', 'Murphy', '+375-29-800-3535');

INSERT INTO users (id, name, surname, phone_number)
VALUES (3, 'Micah', ' James', '+375-25-135-924');

INSERT INTO borrow_history (id, user_id, book_id, returned)
VALUES (1, 1, 1, false);

INSERT INTO borrow_history (id, user_id, book_id, returned)
VALUES (2, 2, 1, true);

INSERT INTO borrow_history (id, user_id, book_id, returned)
VALUES (3, 2, 3, false);