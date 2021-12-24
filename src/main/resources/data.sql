DROP TABLE shop.goods;

CREATE TABLE shop.goods
(
    id               int not null auto_increment,
    title            varchar(255),
    price            int,
    producer_country varchar(50),
    primary key (id)
);

INSERT INTO shop.goods (title, price, producer_country)
VALUES ('Oculus Quest 2', 299, 'USA'),
       ('Sony PlayStation 5', 1500, 'USA'),
       ('Xbox', 2000, 'USA');