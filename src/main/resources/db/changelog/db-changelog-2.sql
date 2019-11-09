-- liquibase formatted sql
-- changeset gustavo-reis:1.0 dbms:mysql
INSERT INTO address (zip_code, street, number, district, city, country) VALUES ('34001316', 'Rua jose', '28', '--', '--', '--');
-- changeset gustavo-reis:77.0 dbms:mysql

INSERT INTO company (name, document, vacancies, site) VALUES ('Empresa 1', '123456789', '1', 'www.empresa2.com.br');
-- changeset gustavo-reis:2.0 dbms:mysql
INSERT INTO company (name, document, vacancies, site) VALUES ('Empresa 2', '12345678', '4', 'www.empresa2.com.br');
-- changeset gustavo-reis:3.0 dbms:mysql
INSERT INTO company (name, document, vacancies, site) VALUES ('Empresa 3', '1234567', '1', 'www.empresa3.com.br');
-- changeset gustavo-reis:4.0 dbms:mysql
INSERT INTO company (name, document, vacancies, site) VALUES ('Empresa 4', '123456', '5', 'www.empresa4.com.br');
-- changeset gustavo-reis:5.0 dbms:mysql
INSERT INTO company (name, document, vacancies, site) VALUES ('Empresa 5', '12345', '10', 'www.empresa5.com.br');
-- changeset gustavo-reis:6.0 dbms:mysql
INSERT INTO company (name, document, vacancies, site) VALUES ('Empresa 2', '12345678', '4', 'www.empresa2.com.br');
-- changeset gustavo-reis:7.0 dbms:mysql
INSERT INTO company (name, document, vacancies, site) VALUES ('Empresa 3', '1234567', '1', 'www.empresa3.com.br');
-- changeset gustavo-reis:8.0 dbms:mysql
INSERT INTO company (name, document, vacancies, site) VALUES ('Empresa 4', '123456', '5', 'www.empresa4.com.br');
-- changeset gustavo-reis:9.0 dbms:mysql
INSERT INTO company (name, document, vacancies, site) VALUES ('Empresa 5', '12345', '10', 'www.empresa5.com.br');

-- changeset gustavo-reis:10.0 dbms:mysql
INSERT INTO user (name, document, age, login, password, company_id, salary ) VALUES ('Usuario 1', '1', 20, 'user1', 'user1', '1', '2000');
-- changeset gustavo-reis:11.0 dbms:mysql
INSERT INTO user (name, document, age, login, password, company_id, salary ) VALUES ('Usuario 2', '2', 20, 'user2', 'user2', '2', '2430');
-- changeset gustavo-reis:12.0 dbms:mysql
INSERT INTO user (name, document, age, login, password, company_id, salary ) VALUES ('Usuario 3', '3', 20, 'user3', 'user3', '5', '5000');
-- changeset gustavo-reis:13.0 dbms:mysql
INSERT INTO user (name, document, age, login, password, company_id, salary) VALUES  ('Usuario 4', '4', 20, 'user4', 'user4', '4', '4030');
-- changeset gustavo-reis:14.0 dbms:mysql
INSERT INTO user (name, document, age, login, password, company_id, salary ) VALUES ('Usuario 5', '5', 20, 'user5', 'user5', '5', '5340');
-- changeset gustavo-reis:15.0 dbms:mysql
INSERT INTO user (name, document, age, login, password, company_id, salary ) VALUES ('Usuario 6', '6', 20, 'user6', 'user6', '5', '6030');
-- changeset gustavo-reis:16.0 dbms:mysql
INSERT INTO user (name, document, age, login, password, company_id, salary ) VALUES ('Usuario 7', '7', 20, 'user7', 'user7', '2', '1570');
-- changeset gustavo-reis:17.0 dbms:mysql
INSERT INTO user (name, document, age, login, password, company_id, salary ) VALUES ('Usuario 8', '8', 20, 'user8', 'user8', '3', '5630');
-- changeset gustavo-reis:18.0 dbms:mysql
INSERT INTO user (name, document, age, login, password, company_id, salary ) VALUES ('Usuario 9', '9', 20, 'user9', 'user9', '5', '4543');
-- changeset gustavo-reis:19.0 dbms:mysql
INSERT INTO user (name, document, age, login, password, company_id, salary ) VALUES ('Usuario 10', '10', 20, 'user10', 'user10', '2', '6216');
-- changeset gustavo-reis:20.0 dbms:mysql
INSERT INTO user (name, document, age, login, password, company_id, salary ) VALUES ('Usuario 11', '11', 20, 'user11', 'user11', '5', '4805');
-- changeset gustavo-reis:21.0 dbms:mysql
INSERT INTO user (name, document, age, login, password, company_id, salary ) VALUES ('Usuario 12', '12', 20, 'user12', 'user12', '5', '7582');
-- changeset gustavo-reis:22.0 dbms:mysql
INSERT INTO user (name, document, age, login, password, company_id, salary ) VALUES ('Usuario 13', '13', 20, 'user13', 'user13', '2', '5820');
-- changeset gustavo-reis:23.0 dbms:mysql
INSERT INTO user (name, document, age, login, password, company_id, salary ) VALUES ('Usuario 14', '14', 20, 'user14', 'user14', '5', '2850');


