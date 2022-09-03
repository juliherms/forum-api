 create table tb_topic (
    id bigint not null auto_increment,
    created_date datetime not null,
    message varchar(300) not null,
    status varchar(20) not null,
    title varchar(50) not null,
    author_id bigint not null,
    course_id bigint not null,
    primary key (id),
    foreign key(course_id) references tb_course(id),
    foreign key(author_id) references tb_user(id)
 );
