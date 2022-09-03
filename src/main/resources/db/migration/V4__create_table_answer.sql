create table tb_answer (
    id bigint not null auto_increment,
    created_date datetime not null,
    message varchar(300) not null,
    resolved int not null,
    author_id bigint not null,
    topic_id bigint not null,
    primary key (id),
    foreign key (topic_id) references tb_topic(id),
    foreign key (author_id) references tb_user(id)
);