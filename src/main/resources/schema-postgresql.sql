DROP TABLE IF EXISTS distillery;

create table distillery (
    id integer PRIMARY KEY NOT NULL,
    name varchar(100) NOT NULL,
    city varchar(100) NOT NULL
);

DROP TABLE IF EXISTS product;

create table product (
    id integer PRIMARY KEY NOT NULL,
    distilleryId integer REFERENCES distillery(id)
    name varchar(100) NOT NULL,
    city varchar(100) NOT NULL
);