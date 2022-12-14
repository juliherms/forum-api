create table tb_user_role (
  id bigint not null auto_increment,
  user_id bigint not null,
  role_id bigint not null,
  primary key (id),
  foreign key(user_id) references tb_user(id),
  foreign key(role_id) references tb_role(id)
);
