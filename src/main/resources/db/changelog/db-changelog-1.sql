-- liquibase formatted sql




-- changeset gustavo:1.0 dbms:mysql

CREATE TABLE `user_company`.`company` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL,
  `document` VARCHAR(17) NULL,
  `site` VARCHAR(255) NULL,
  `vacancies` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

-- changeset gustavo:1.1 dbms:mysql

create table user
(
	id bigint auto_increment,
	name varchar(100) not null,
	document varchar(13) not null,
	salary decimal(10,2) null,
	age integer null,
	login varchar (100) not null,
	password varchar (255) not null,
	company_id bigint not null,
		primary key (id),

);

-- changeset gustavo:1.2 dbms:mysql
alter table company drop column salary;
alter table company drop column age;



