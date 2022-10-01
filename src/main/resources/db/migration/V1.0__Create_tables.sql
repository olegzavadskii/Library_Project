create table if not exists users
(
    id       integer generated by default as identity,
    login    varchar(255)
        constraint unique_login unique,
    password varchar(255),
    role     varchar(255),
    created  date,
    updated  date,
    primary key (id)
);

create table if not exists books
(
    id      integer generated by default as identity,
    author  varchar(255),
    name    varchar(255),
    count   integer not null,
    created date,
    updated date,
    primary key (id)
);

create table if not exists users_books
(
    id      integer generated by default as identity,
    user_id integer not null,
    book_id integer not null,
    constraint fk_user_id foreign key (user_id) references users (id),
    constraint fk_book_id foreign key (book_id) references books (id),
    primary key (id)
);