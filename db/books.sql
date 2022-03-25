create table books
(
    id   int auto_increment
        primary key,
    name varchar(255) null,
    constraint books_id_uindex
        unique (id)
);

