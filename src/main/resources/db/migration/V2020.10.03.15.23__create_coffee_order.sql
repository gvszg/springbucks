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