create table discount_card
(
    id             integer not null
        primary key,
    discount_count integer not null,
    name           varchar(255)

);

alter table discount_card
    owner to postgres;

INSERT into discount_card(id, discount_count, name)
VALUES (1, 10, 'silver'),
       (2, 20, 'gold'),
       (3, 30, 'platinum');

create table product
(
    id      integer          not null
        primary key,
    name    varchar(255),
    on_sale boolean          not null,
    price   double precision not null
);

alter table product
    owner to postgres;

INSERT into product(id, name, on_sale, price)
VALUES (1, 'chicken', true, 10),
       (2, 'meat', true, 15),
       (3, 'salmon', false, 20),
       (4, 'avocado', false, 7),
       (5, 'rice', true, 6),
       (6, 'cheese', false, 4);