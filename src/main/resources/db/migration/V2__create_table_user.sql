create table tb_user (
    id bigint not null auto_increment,
    email varchar(50) not null,
    name varchar(50) not null,
    primary key (id)
);

insert into tb_user values(1, 'Ana da Silva', 'ana@email.com');