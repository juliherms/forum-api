create table tb_course(
                      id bigint not null auto_increment,
                      name varchar(50) not null,
                      category varchar(50) not null,
                      primary key(id)
);

insert into tb_course values(1, 'Kotlin', 'Programacao');
insert into tb_course values(2, 'HTML', 'Front-end');