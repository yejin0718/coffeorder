SET foreign_key_checks = 0;
drop table menu;
drop table users;
drop table orders;
SET foreign_key_checks = 1;

CREATE TABLE users
(   users_id int NOT NULL AUTO_INCREMENT,
    email varchar(20) NOT NULL,
    password varchar(50) NOT NULL,
    point bigint NOT NULL,
    PRIMARY KEY (users_id)                  );

CREATE TABLE menu
(   menu_id int NOT NULL AUTO_INCREMENT,
    name varchar(20) NOT NULL,
    price bigint NOT NULL,
    PRIMARY KEY (menu_id)                  );

CREATE TABLE orders
(   orders_id int NOT NULL AUTO_INCREMENT,
    users_id int NOT NULL,
    menu_id int NOT NULL,
    PRIMARY KEY (orders_id)                  );

insert into menu (name, price) value ('아메리카노', 1500);
insert into menu (name, price) value ('라떼', 2500);
insert into menu (name, price) value ('딸기쉐이크', 7000);
