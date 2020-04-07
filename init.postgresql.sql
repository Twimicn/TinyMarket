create table "tm_user"
(
	id serial
		constraint tm_user_pk
			primary key,
	username varchar(50) not null,
	password varchar(50) not null,
	email varchar(50),
	phone varchar(20),
	role_id int,
	create_time timestamp,
	update_time timestamp
);