create table tb_course (
    id bigint generated by default as identity,
    category varchar(255),
    name varchar(255),
    primary key (id)
 );

 insert into tb_course values(1,'Kotlin','Programacao');