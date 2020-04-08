create table tm_user
(
	id integer
		constraint tm_user_pk
			primary key autoincrement,
	username varchar(50) not null,
	password varchar(50) not null,
	email varchar(50),
	phone varchar(20),
	role_id integer,
	create_time datetime,
	update_time datetime,
	token varchar (40)
);
