create table tb_user (
    id bigint generated by default as identity,
    email varchar(255),
    name varchar(255),
    primary key (id)
);

insert into tb_user values(1,'email@email.com','email');