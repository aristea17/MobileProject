-- DEPARTMENT --
--1
insert into department (d_id, d_name) values(1, 'administration');

insert into department (d_id, d_name) values(2, 'kitchen');

insert into department (d_id, d_name) values(3, 'clean');


-- USERS --

insert into users (u_id, department_d_id, psw, username) values(1, 1, '21232f297a57a5a743894a0e4a801fc3', 'administration');

insert into users (u_id, department_d_id, psw, username) values(2, 2, '09228dac155633b13780552bc01dc2e0', 'kitchen');

insert into users (u_id, department_d_id, psw, username) values(3, 3, '123402c04dcfb6625f688f771a5fc05d', 'clean');


-- PRODUCTS --
--1
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(1, 'mila latte fresco', 'frigo', '1 litro', 30, 30);

insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(2, 'mila yogurt vasetto 6pack', 'frigo', '6', 20, 20);

insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(3, 'mila latte parz. scremo', 'frigo', '0.5 litro', 20, 20);

insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(4, 'mele golden cassetta', 'frutta e verdura', 'cassetta', 5, 6);
--5
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(5, 'saponetta bagno', 'igiene', '1', 50, 60);

insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(6, 'detergente pavimenti', 'pulizia', '500 ml', 5, 6);

insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(7, 'penne sfera', 'cartoleria', '50', 1, 3);

insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(8, 'sterzing yogurt vasetto 6pack', 'frigo', '6', 20, 15);

insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(9, 'heineken birra 33cl 3pack', 'bevande e alcolici', '3', 20, 50);
--10
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(10, 'coca-cola lattina 33cl 6pack', 'bevande e alcolici', '6', 15, 20);

insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(11, 'manzo tagliata', 'carne e pesce', '200g', 10, 5);

insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(12, 'pollo petto', 'carne e pesce', '300g', 15, 10);

insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(13, 'insalata cappuccio cassetta', 'frutta e verdura', 'cassetta', 10, 25);

insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(14, 'kit igene personale', 'igiene', '1', 60, 70);
--15
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(15, 'kit doccia shampoo', 'igiene', '5cl', 50, 45);

insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(16, 'detergente vetri', 'pulizia', '50cl', 30, 42);

insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(17, 'lavanderia detersivo', 'lavanderia', '5 litri', 10, 11);

insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(18, 'lavanderia sapone marsiglia', 'lavanderia', '1 litro', 6, 18);

insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(19, 'lavanderia ammorbidente', 'lavanderia', '1 litro', 20, 28);
--20
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(20, 'dentifricio', 'igiene', '100cl', 30, 40);
--
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(21, 'carta risma 100', 'cartoleria', '100 fogli', 30, 83);

insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(22, 'toner stampante nero', 'stampante', '1 toner', 2, 4);

insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(23, 'toner stampante 3color', 'stampante', '1 toner', 2, 4);



-- SUPPLIERS --
--1
insert into suppliers(s_id, address, company, email, representative, telephone) values(1, '', 'Despar', 'casinilorenzo91@gmail.com', 'Kurt', '');

insert into suppliers(s_id, address, company, email, representative, telephone) values(2, '', 'Poli', 'lorenzocasini@yahoo.it', 'Mr. Poli', '');

insert into suppliers(s_id, address, company, email, representative, telephone) values(3, '', 'Carrefour', 'imsunibz@gmail.com', 'Commander Shepard', '');

insert into suppliers(s_id, address, company, email, representative, telephone) values(4, '', 'Athesia', 'ibershimiaristea@yahoo.com', '', '');
--5
insert into suppliers(s_id, address, company, email, representative, telephone) values(5, 'Via Macello, 42, Bolzano', 'Macelleria/Metzgerei', 'ibershimiaristea17@gmail.com', 'The Butcher', '0471.166.166');

insert into suppliers(s_id, address, company, email, representative, telephone) values(6, '', 'Acqua e Sapone', 'Lorenzo.Casini@studinf.unibz.it', '', '');


-- SELLS -- RELATION -- 
-- Per Supplier
-- 1 - Despar
insert into sells (price, p_id, s_id) values(1.00, 1, 1);

insert into sells (price, p_id, s_id) values(4.99, 2, 1);

insert into sells (price, p_id, s_id) values(0.68, 3, 1);

insert into sells (price, p_id, s_id) values(10.00, 4, 1);

insert into sells (price, p_id, s_id) values(0.89, 5, 1);

insert into sells (price, p_id, s_id) values(5.00, 6, 1);

insert into sells (price, p_id, s_id) values(4.80, 8, 1);

insert into sells (price, p_id, s_id) values(3.69, 9, 1);

insert into sells (price, p_id, s_id) values(3.81, 10, 1);

insert into sells (price, p_id, s_id) values(1.96, 12, 1);

insert into sells (price, p_id, s_id) values(6.00, 13, 1);

insert into sells (price, p_id, s_id) values(12.36, 19, 1);

insert into sells (price, p_id, s_id) values(1.30, 20, 1);
-- 2 - Poli
insert into sells (price, p_id, s_id) values(0.88, 1, 2);

insert into sells (price, p_id, s_id) values(3.65, 2, 2);

insert into sells (price, p_id, s_id) values(0.61, 3, 2);

insert into sells (price, p_id, s_id) values(0.49, 7, 2);

insert into sells (price, p_id, s_id) values(2.45, 9, 2);

insert into sells (price, p_id, s_id) values(0.99, 12, 2);

insert into sells (price, p_id, s_id) values(1.12, 16, 2);
-- 3 - Carrefour
insert into sells (price, p_id, s_id) values(0.85, 5, 3);

insert into sells (price, p_id, s_id) values(2.00, 6, 3);

insert into sells (price, p_id, s_id) values(1.50, 16, 3);

insert into sells (price, p_id, s_id) values(6.89, 17, 3);

insert into sells (price, p_id, s_id) values(4.32, 18, 3);

insert into sells (price, p_id, s_id) values(5.23, 19, 3);

insert into sells (price, p_id, s_id) values(0.85, 20, 3);
-- 4 - Athesia
insert into sells (price, p_id, s_id) values(2.50, 7, 4);

insert into sells (price, p_id, s_id) values(4.00, 21, 4);

insert into sells (price, p_id, s_id) values(15.00, 22, 4);

insert into sells (price, p_id, s_id) values(20.00, 23, 4);
-- 5 - Macelleria/Metzgerei
insert into sells (price, p_id, s_id) values(3.65, 11, 5);

insert into sells (price, p_id, s_id) values(1.86, 12, 5);
-- 6 - Acqua & Sapone
insert into sells (price, p_id, s_id) values(0.98, 5, 6);

insert into sells (price, p_id, s_id) values(2.88, 14, 6);

insert into sells (price, p_id, s_id) values(2.56, 15, 6);

insert into sells (price, p_id, s_id) values(1.15, 20, 6);


-- NEEDS -- RELATION --
-- Per Department
-- 1 - Administration
insert into needs (d_id, p_id) values(1, 7);

insert into needs (d_id, p_id) values(1, 21);

insert into needs (d_id, p_id) values(1, 22);

insert into needs (d_id, p_id) values(1, 23);
-- 2 - -Kitchen
insert into needs (d_id, p_id) values(2, 1);

insert into needs (d_id, p_id) values(2, 2);

insert into needs (d_id, p_id) values(2, 3);

insert into needs (d_id, p_id) values(2, 7);

insert into needs (d_id, p_id) values(2, 4);

insert into needs (d_id, p_id) values(2, 8);

insert into needs (d_id, p_id) values(2, 9);

insert into needs (d_id, p_id) values(2, 10);

insert into needs (d_id, p_id) values(2, 11);

insert into needs (d_id, p_id) values(2, 12);

insert into needs (d_id, p_id) values(2, 13);


-- 3 - Clean
insert into needs (d_id, p_id) values(3, 5);

insert into needs (d_id, p_id) values(3, 6);

insert into needs (d_id, p_id) values(3, 7);

insert into needs (d_id, p_id) values(3, 14);

insert into needs (d_id, p_id) values(3, 15);

insert into needs (d_id, p_id) values(3, 16);

insert into needs (d_id, p_id) values(3, 17);

insert into needs (d_id, p_id) values(3, 18);

insert into needs (d_id, p_id) values(3, 19);

insert into needs (d_id, p_id) values(3, 20);


-- DEPTSUP -- RELATION --
insert into deptsup (d_id, s_id) values (1, 4);

insert into deptsup (d_id, s_id) values (1, 2);

insert into deptsup (d_id, s_id) values (2, 1);

insert into deptsup (d_id, s_id) values (2, 2);

insert into deptsup (d_id, s_id) values (2, 4);

insert into deptsup (d_id, s_id) values (2, 5);

insert into deptsup (d_id, s_id) values (3, 3);

insert into deptsup (d_id, s_id) values (3, 4);

insert into deptsup (d_id, s_id) values (3, 6);