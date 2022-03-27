create table if not exists goods
(
    id               serial primary key,
    price            integer,
    producer_country varchar(255),
    title            varchar(255)
);