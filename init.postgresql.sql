create table "tm_user"
(
    id          serial
        constraint tm_user_pk
            primary key,
    username    varchar(50) not null,
    password    varchar(50) not null,
    email       varchar(50),
    phone       varchar(20),
    role_id     int,
    create_time timestamp,
    update_time timestamp,
    token       varchar(40),
    expire      timestamp
);
create table tm_cart
(
    id          serial
        constraint tm_cart_pk
            primary key,
    user_id     integer not null,
    product_id  integer default null,
    quantity    integer default 0,
    checked     integer default 0,
    create_time timestamp,
    update_time timestamp,
    expire      timestamp
);
create table tm_category
(
    id          serial
        constraint tm_category_pk
            primary key,
    parent_id   integer default 0,
    name        varchar(50) not null,
    status      integer default 1,
    sort_order  integer default 0,
    create_time timestamp,
    update_time timestamp
);
create table tm_order
(
    id           serial
        constraint tm_order_pk
            primary key,
    order_no     varchar(40),
    user_id      integer default 0,
    shipping_id  integer,
    payment      real,
    payment_type integer,
    postage      real,
    status       integer,
    payment_time timestamp,
    send_time    timestamp,
    end_time     timestamp,
    close_time   timestamp,
    create_time  timestamp,
    update_time  timestamp
);
create table tm_order_item
(
    id                 serial
        constraint tm_order_item_pk
            primary key,
    user_id            integer default 0,
    order_no           varchar(40),
    product_id         integer,
    product_name       text,
    product_image      text,
    current_unit_price real,
    quantity           integer,
    total_price        real,
    create_time        timestamp,
    update_time        timestamp
);
create table tm_pay_info
(
    id              serial
        constraint tm_pay_info_pk
            primary key,
    user_id         integer default 0,
    order_no        varchar(40),
    pay_platform    integer,
    platform_number text,
    platform_status text,
    create_time     timestamp,
    update_time     timestamp
);
create table tm_product
(
    id          serial
        constraint tm_product_pk
            primary key,
    category_id integer default 0,
    name        text,
    subtitle    text,
    main_image  text,
    sub_images  text,
    detail      text,
    price       real,
    stock       integer,
    status      integer,
    create_time timestamp,
    update_time timestamp
);
create table tm_shipping
(
    id                serial
        constraint tm_shipping_pk
            primary key,
    user_id           integer default 0,
    receiver_name     text,
    receiver_phone    text,
    receiver_mobile   text,
    receiver_province text,
    receiver_city     text,
    receiver_district text,
    receiver_address  text,
    receiver_zip      text,
    create_time       timestamp,
    update_time       timestamp
);