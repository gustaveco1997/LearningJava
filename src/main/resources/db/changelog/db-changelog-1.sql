-- liquibase formatted sql



-- changeset gustavo-reis:1.0 dbms:mysql
create table company
(
id bigint auto_increment,
name varchar(100) not null,
document varchar(13) not null,
salary decimal (10,2) null,
vacancies integer null,
site varchar(255) not null,
address_id bigint(255),

primary key (id)
);

-- changeset gustavo-reis:1.1 dbms:mysql

create table user
(
id bigint auto_increment,
name varchar(255) not null,
document varchar(14) not null,
age integer null,
login varchar(255) not null,
password varchar(255) not null,
company_id bigint(255),
salary decimal(19,2) null,
address_id bigint(255),
primary key(id)
);

-- changeset gustavo-reis:1.2 dbms:mysql

create table address
(
id bigint auto_increment,
zip_code varchar(9) not null,
street varchar(255) not null,
number integer null,
district varchar(255) not null,
city varchar(255) not null,
country varchar(255) not null,

primary key(id)
);

ALTER TABLE company
ADD INDEX fk_company_address_idx (address_id ASC);
;
ALTER TABLE company
ADD CONSTRAINT fk_company_address
  FOREIGN KEY (address_id)
  REFERENCES address (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

  ALTER TABLE user
  ADD INDEX fk_user_company_idx (company_id ASC);
  ;
  ALTER TABLE user
  ADD CONSTRAINT fk_user_company
    FOREIGN KEY (company_id)
    REFERENCES company (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;


    ALTER TABLE user
    ADD INDEX fk_user_address_idx (address_id ASC);
    ;
    ALTER TABLE user
    ADD CONSTRAINT fk_user_address
      FOREIGN KEY (address_id)
      REFERENCES address (id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;


