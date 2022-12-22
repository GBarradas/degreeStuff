/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `user_name` varchar(30) NOT NULL,
  `user_role` varchar(15) NOT NULL,
  FOREIGN KEY (`user_name`) REFERENCES `user` (`user_name`)
);

/*Data for the table `user_role` */

insert  into `user_role`(`user_name`,`user_role`) values ('admin','ROLE_ADMIN');