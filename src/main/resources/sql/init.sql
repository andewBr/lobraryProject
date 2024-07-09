create table genres (
    id serial primary key ,
    name varchar(128)
);

create table author (
                        id serial primary key ,
                        first_name 		varchar(128),
                        last_name 		varchar(128),
                        birth_date 		varchar(128)
);

create table Book (
	id 			serial primary key,
	title 		varchar(128),
	genres_id int REFERENCES genres(id),
	author_id int REFERENCES author(id)
);

create table library (
	id serial primary key,
	loan_date 		DATE not null,  -- дата выдачи.
	return_date 	DATE,            -- дата возврата
    book_id INT REFERENCES book(id)
);

-- drop table author cascade ;
-- drop table author cascade ;
-- drop table Book cascade;
-- drop table library cascade;
