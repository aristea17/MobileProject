-- DEPARTMENT --
--1
insert into department (d_id, d_name) values(1, 'administrator');

insert into department (d_id, d_name) values(2, 'kitchen');

insert into department (d_id, d_name) values(3, 'clean');


-- USERS --

insert into users (u_id, department_d_id, psw, username) values(1, 1, '21232f297a57a5a743894a0e4a801fc3', 'admin');

insert into users (u_id, department_d_id, psw, username) values(2, 2, '09228dac155633b13780552bc01dc2e0', 'kitchen');

insert into users (u_id, department_d_id, psw, username) values(3, 3, '123402c04dcfb6625f688f771a5fc05d', 'clean');
