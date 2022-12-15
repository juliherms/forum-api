create table tb_role (
    id bigint not null auto_increment,
    name varchar(50) NOT NULL,
    primary key (id)
);

UPDATE tb_user SET password = '$2a$12$8x.RMDZxKFtSqTJX5aoaOuxQYHwAMfhCdo6xVJzVb/tuCca8ukBnO' WHERE id = 1;
insert into tb_role(id,name) values (1,'READ_WRITE');
