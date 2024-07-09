INSERT INTO genres (name)
VALUES ('Fiction'),
       ('Non-Fiction'),
       ('Science Fiction'),
       ('Fantasy'),
       ('Mystery'),
       ('Biography');

-- Вставка данных в таблицу author
INSERT INTO author (first_name, last_name, birth_date)
VALUES ('Isaac', 'Asimov', '1920-01-02'),
       ('J.K.', 'Rowling', '1965-07-31'),
       ('George', 'Orwell', '1903-06-25'),
       ('Agatha', 'Christie', '1890-09-15');

-- 	genres_id int REFERENCES genres(id),
-- 	author_id int REFERENCES author(id)

-- Вставка данных в таблицу Book
INSERT INTO Book (title, genres_id, author_id)
VALUES ('Foundation', 3, 1),
       ('Harry Potter and the Philosophers Stone', 4, 2),
       ('1984', 1, 3),
       ('Murder on the Orient Express', 5, 4);

-- Вставка данных в таблицу library
INSERT INTO library (loan_date, return_date, book_id)
VALUES ('2024-01-01', '2024-01-15', 1),
       ('2024-02-01', '2024-02-14', 2),
       ('2024-03-01', NULL, 3),
       ('2024-04-01', '2024-04-15', 4);

