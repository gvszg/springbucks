drop table if exists t_coffee;
drop table if exists t_order;
drop table if exists t_order_coffee;

create table if not exists t_coffee (
    id bigint not null auto_increment,
    create_time datetime,
    update_time datetime,
    name varchar(255),
    price bigint,
    primary key (id)
);

create table if not exists t_order (
    id bigint not null auto_increment,
    create_time datetime,
    update_time datetime,
    customer varchar(255),
    state integer not null,
    primary key (id)
);

create table if not exists t_order_coffee (
    coffee_order_id bigint not null,
    items_id bigint not null
);