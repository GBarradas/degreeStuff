DROP TABLE IF EXISTS my_user_role;
DROP TABLE IF EXISTS my_user;


CREATE TABLE my_user (
  user_name varchar(30) NOT NULL,
  user_pass varchar(255) NOT NULL,
  enable smallint NOT NULL DEFAULT 1,
  PRIMARY KEY (user_name)
);

insert  into my_user (user_name,user_pass,enable) values ('admin','$2a$10$dl8TemMlPH7Z/mpBurCX8O4lu0FoWbXnhsHTYXVsmgXyzagn..8rK',1);
-- user2 / teste123
insert  into my_user (user_name,user_pass,enable) values ('user2','$2a$10$bKWhb9hIUD3xxxtzfhvodugWIK3Gbw4vRySYOnBqy2O4gtqZ78jUK',1);


CREATE TABLE my_user_role (
  user_name varchar(30) NOT NULL,
  user_role varchar(15) NOT NULL,
  FOREIGN KEY (user_name) REFERENCES my_user (user_name)
);

insert  into my_user_role (user_name,user_role) values ('admin','ROLE_ADMIN');
insert  into my_user_role (user_name,user_role) values ('user2','ROLE_2');