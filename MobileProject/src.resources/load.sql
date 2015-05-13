-- DEPARTMENT --
--1
insert into department (d_id, d_name) values(1, 'administrator');

insert into department (d_id, d_name) values(2, 'kitchen');

insert into department (d_id, d_name) values(3, 'clean');


-- USERS --

insert into users (u_id, department_d_id, psw, username) values(1, 1, '21232f297a57a5a743894a0e4a801fc3', 'administrator');

insert into users (u_id, department_d_id, psw, username) values(2, 2, '09228dac155633b13780552bc01dc2e0', 'kitchen');

insert into users (u_id, department_d_id, psw, username) values(3, 3, '123402c04dcfb6625f688f771a5fc05d', 'clean');


-- PRODUCTS --
--1
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(1, 'latte mila', 'frigo', '1 litro', 30, 30);

insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(2, 'yogurt mila', 'frigo', '1', 20, 20);

insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(3, 'latte vipiteno', 'frigo', '1', 20, 20);

insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(4, 'mele marlene', 'frutta e verdura', '10 Kg', 2, 4);
--5
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(5, 'sapone', 'pulizia e igene', '1', 30, 50);

insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(6, 'vetril', 'pulizia e igene', '500 ml', 5, 6);

insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(7, 'penne sfera', 'cartoleria', '50', 1, 3);


-- SUPPLIERS --
--1
insert into suppliers(s_id, address, company, email, representative, telephone) values(1, '', 'Despar', 'peppa@pig.com', 'Peppa Pig', '');

insert into suppliers(s_id, address, company, email, representative, telephone) values(2, '', 'Poli', 'goku@tory.com', 'Goku', '');

insert into suppliers(s_id, address, company, email, representative, telephone) values(3, '', 'Carrefour', 'shepard@bioware.com', 'Commander Shepard', '');

insert into suppliers(s_id, address, company, email, representative, telephone) values(4, '', 'Athesia', 'pens@production.com', '', '');


-- SELLS -- RELATION -- 

insert into sells (price, p_id, s_id) values(1.00, 1, 1);

insert into sells (price, p_id, s_id) values(0.45, 2, 1);

insert into sells (price, p_id, s_id) values( 0.49, 3, 1);

insert into sells (price, p_id, s_id) values(30.00, 4, 1);

insert into sells (price, p_id, s_id) values(0.88, 1, 2);

insert into sells (price, p_id, s_id) values(0.40, 2, 2);

insert into sells (price, p_id, s_id) values(0.61, 3, 2);

insert into sells (price, p_id, s_id) values(0.85, 5, 3);

insert into sells (price, p_id, s_id) values(2.00, 6, 3);

insert into sells (price, p_id, s_id) values(2.50, 7, 4);


-- NEEDS -- RELATION --

insert into needs (d_id, p_id) values(2, 1);

insert into needs (d_id, p_id) values(2, 2);

insert into needs (d_id, p_id) values(2, 3);

insert into needs (d_id, p_id) values(2, 4);

insert into needs (d_id, p_id) values(2, 7);

insert into needs (d_id, p_id) values(3, 5);

insert into needs (d_id, p_id) values(3, 6);

insert into needs (d_id, p_id) values(3, 7);

-- DEPTSUP -- RELATION --
insert into deptsup (d_id, s_id) values (1, 4);

insert into deptsup (d_id, s_id) values (2, 1);

insert into deptsup (d_id, s_id) values (2, 2);

insert into deptsup (d_id, s_id) values (2, 4);

insert into deptsup (d_id, s_id) values (3, 3);

insert into deptsup (d_id, s_id) values (3, 4);