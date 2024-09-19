create table persons (
id  serial primary key,
name varchar (255),
surname varchar (255),
age smallint,
phone_number varchar (255),
city_of_living varchar (255));

insert into persons (age, city_of_living, name, phone_number, surname )
VALUES (22, 'Moscow', 'Dmitry', '89998112233', 'Pirumov'),
       (23, 'Moscow', 'Dmitry', '89998887766', 'ivanov'),
       (44, 'Tver', 'Maxim', '89998881122', 'Petrov'),
       (23, 'Grozniy', 'Vahtang', '86667776661', 'Kikabidze');
