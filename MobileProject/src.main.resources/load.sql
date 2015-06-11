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
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(3, 'mila latte parz. scremato', 'frigo', '0.5 litro', 20, 20);
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(4, 'mele golden cassetta', 'frutta e verdura', '1 cassetta', 5, 6);
--5
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(5, 'saponetta bagno', 'igiene', '1', 50, 60);
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(6, 'detergente pavimenti', 'pulizia', '500 ml', 5, 6);
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(7, 'penne sfera nero', 'cancelleria', '50', 1, 3);
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(8, 'sterzing yogurt vasetto 6pack', 'frigo', '6', 20, 15);
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(9, 'heineken birra 33cl 3pack', 'bevande e alcolici', '3', 20, 50);
--10
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(10, 'coca-cola lattina 33cl 6pack', 'bevande e alcolici', '6', 15, 20);
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(11, 'manzo tagliata', 'carne e pesce', '200g', 10, 5);
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(12, 'pollo petto', 'carne e pesce', '300g', 15, 10);
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(13, 'insalata cappuccio cassetta', 'frutta e verdura', '1 cassetta', 10, 25);
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(14, 'kit igene personale', 'igiene', '1', 60, 70);
--15
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(15, 'kit doccia shampoo', 'igiene', '5cl', 50, 45);
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(16, 'detergente vetri', 'pulizia', '50cl', 30, 42);
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(17, 'lavanderia detersivo', 'lavanderia', '5 litri', 10, 11);
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(18, 'lavanderia sapone marsiglia', 'lavanderia', '1 litro', 6, 18);
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(19, 'lavanderia ammorbidente', 'lavanderia', '1 litro', 20, 28);
--20
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(20, 'dentifricio colgate', 'igiene', '100cl', 30, 40);
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(21, 'carta risma 100', 'stampante', '100 fogli', 30, 83);
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(22, 'toner stampante nero', 'stampante', '1 toner', 2, 4);
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(23, 'toner stampante 3color', 'stampante', '1 toner', 2, 4);
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(24, 'penne sfera rosso', 'cancelleria', '50', 1, 2);
--25
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(25, 'evidenziatori 5pack', 'cancelleria', '5', 10, 13);
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(26, 'block quadretti 10pack', 'cancelleria', '10', 10, 11);
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(27, 'carta intestata fatture 1k', 'tipografia', '1k fogli', 5, 5);
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(28, 'blocco note intestato 20', 'tipografia', '20 blocchi', 20, 24);
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(29, 'biglietti da visita 1k', 'tipografia', '1k', 2, 4);
--30
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(30, 'opuscolo info 500', 'tipografia', '500 depliant', 3, 4);
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(31, 'mandarini cestino', 'frutta e verdura', '1 cestino 2Kg', 10, 12);
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(32, 'arance cassetta', 'frutta e verdura', '1 cassetta', 15, 12);
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(33, 'frutta mista stagione cassetta', 'frutta e verdura', '1 cassetta', 20, 30);
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(34, 'verdura mista stagione cassetta', 'frutta e verdura', '1 cassetta', 20, 30);
--35
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(35, 'pomodori cassetta', 'frutta e verdura', '1 cassetta', 12, 12);
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(36, 'cipolle cassetta', 'frutta e verdura', '1 cassetta', 8, 6);
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(37, 'patate sacco', 'frutta e verdura', '1 sacco 5Kg', 10, 15);
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(38, 'fanta lattina 33cl 6pack', 'bevande e alcolici', '6', 15, 20);
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(39, 'lemon soda lattina 33cl 6pack', 'bevande e alcolici', '6', 15, 20);
--40
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(40, 'acqua naturale 500cl 12cassetta', 'bevande e alcolici', '12 bottiglie cassetta', 50, 60);
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(41, 'acqua frizzante 500cl 12cassetta', 'bevande e alcolici', '12 bottiglie cassetta', 40, 45);
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(42, 'forst birra 33cl 3pack', 'bevande e alcolici', '3', 20, 50);
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(43, 'radler 500cl 6pack', 'bevande e alcolici', '6', 20, 30);
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(44, 'sgombro', 'carne e pesce', '300g', 10, 12);
--45
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(45, 'polpo', 'carne e pesce', '1', 10, 15);
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(46, 'gamberi 1Kg', 'carne e pesce', '1 Kg', 5, 2);
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(47, 'salsicce 6', 'carne e pesce', '6', 10, 14);
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(48, 'piselli busta 500', 'freezer', '500', 20, 30);
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(49, 'spinaci busta 500', 'freezer', '500', 20, 30);
--50
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(50, 'fritto misto mare busta 500', 'freezer', '500', 20, 30);
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(51, 'gelato algida cornetto scatola', 'freezer', '10', 20, 30);
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(52, 'gelato algida magnum scatola', 'freezer', '10', 20, 30);
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(53, 'prosciutto 5Kg', 'frigo', '5 Kg', 2, 2);
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(54, 'mila burro 500g', 'frigo', '500g', 20, 30);
--55
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(55, 'mortadella 5Kg', 'frigo', '5 Kg', 2, 1);
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(56, 'formaggio grana 10 Kg', 'frigo', '10 Kg', 2, 2);
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(57, 'mozzarella 500g', 'frigo', '500g', 15, 20);
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(58, 'pane toast 500g', 'pane e pasta', '500g', 10, 20);
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(59, 'barilla spaghetti n5', 'pane e pasta', '500g', 15, 15);
--60
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(60, 'barilla penne 500g', 'pane e pasta', '500g', 15, 12);
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(61, 'scotti riso', 'pane e pasta', '500', 10, 15);
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(62, 'pane integrale 1Kg', 'pane e pasta', '1Kg', 10, 20);
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(63, 'pane rosette 1Kg', 'pane e pasta', '1Kg', 10, 20);
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(64, 'detergente spary acciaio', 'pulizia', '500cl', 5, 6);
--65
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(65, 'detergente spary anticalcare', 'pulizia', '500cl', 5, 7);
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(66, 'detergente legno', 'pulizia', '500cl', 5, 4);
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(67, 'cera d_api', 'pulizia', '500cl', 4, 5);
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(68, 'spugna', 'pulizia', '10', 5, 10);
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(69, 'guanti lattice', 'pulizia', '50', 10, 15);
--70
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(70, 'cotton fiock 100', 'igiene', '100', 20, 30);
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(71, 'pettine usa_e_getta', 'igiene', '50', 2, 3);
insert into products(p_id, p_name, category, batch_amount, minimum, stored) values(72, 'carta igenica 10rotoli', 'igiene', '10', 50, 50);

-- SUPPLIERS --
--1
insert into suppliers(s_id, address, company, email, representative, telephone) values(1, 'Via dei Buoi, 12, Merano', 'Despar', 'casinilorenzo91@gmail.com', 'Kurt', '0471.145.862');
insert into suppliers(s_id, address, company, email, representative, telephone) values(2, 'Via Molise, 1, Foggia', 'Poli', 'lorenzocasini@yahoo.it', 'Mr. Poli', '0471.725.563');
insert into suppliers(s_id, address, company, email, representative, telephone) values(3, 'Piazza la Bomba, 9, Scampia', 'Clean Company', 'imsunibz@gmail.com', 'Commander Shepard', '0471.254.934');
insert into suppliers(s_id, address, company, email, representative, telephone) values(4, 'Via Renon, 2, Sotto Monte', 'Athesia', 'ibershimiaristea@yahoo.com', '', '0471.383.888');
--5
insert into suppliers(s_id, address, company, email, representative, telephone) values(5, 'Via Macello, 42, Bolzano', 'Macelleria-Metzgerei', 'ibershimiaristea17@gmail.com', 'The Butcher', '0471.166.166');
insert into suppliers(s_id, address, company, email, representative, telephone) values(6, 'Via Linda, 31, Bolzano', 'Acqua e Sapone', 'casinilorenzo91@gmail.com', 'Willie Wonka', '0471.582.995');
insert into suppliers(s_id, address, company, email, representative, telephone) values(7, 'Via Palo, 40, Bolzano', 'Metro', 'lorenzocasini@yahoo.it', 'Ruggero Gorogorth', '0471.942.378');
insert into suppliers(s_id, address, company, email, representative, telephone) values(8, 'Meranstrasse, 12, Brixen', 'Biokistl', 'imsunibz@gmail.com', 'Van Persie', '0471.788.783');
insert into suppliers(s_id, address, company, email, representative, telephone) values(9, 'Via Verona, 12, Bolzano', 'Typo', 'ibershimiaristea@yahoo.com', 'Tobias', '0471.433.878');


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
insert into sells (price, p_id, s_id) values(4.67, 31, 1);
insert into sells (price, p_id, s_id) values(12.34, 32, 1);
insert into sells (price, p_id, s_id) values(10.12, 34, 1);
insert into sells (price, p_id, s_id) values(8.36, 35, 1);
insert into sells (price, p_id, s_id) values(5.36, 36, 1);
insert into sells (price, p_id, s_id) values(2.45, 39, 1);
insert into sells (price, p_id, s_id) values(0.45, 40, 1);
insert into sells (price, p_id, s_id) values(0.65, 41, 1);
insert into sells (price, p_id, s_id) values(2.99, 42, 1);
insert into sells (price, p_id, s_id) values(2.42, 43, 1);
insert into sells (price, p_id, s_id) values(4.00, 45, 1);
insert into sells (price, p_id, s_id) values(10.52, 47, 1);
insert into sells (price, p_id, s_id) values(5.32, 48, 1);
insert into sells (price, p_id, s_id) values(4.54, 49, 1);
insert into sells (price, p_id, s_id) values(7.21, 52, 1);
insert into sells (price, p_id, s_id) values(0.90, 54, 1);
insert into sells (price, p_id, s_id) values(2.34, 57, 1);
insert into sells (price, p_id, s_id) values(1.30, 59, 1);
insert into sells (price, p_id, s_id) values(1.17, 61, 1);
insert into sells (price, p_id, s_id) values(2.14, 62, 1);
insert into sells (price, p_id, s_id) values(1.88, 63, 1);

-- 2 - Poli
insert into sells (price, p_id, s_id) values(0.88, 1, 2);
insert into sells (price, p_id, s_id) values(3.65, 2, 2);
insert into sells (price, p_id, s_id) values(0.61, 3, 2);
insert into sells (price, p_id, s_id) values(0.49, 7, 2);
insert into sells (price, p_id, s_id) values(2.45, 9, 2);
insert into sells (price, p_id, s_id) values(0.99, 12, 2);
insert into sells (price, p_id, s_id) values(0.89, 24, 2);
insert into sells (price, p_id, s_id) values(3.87, 31, 2);
insert into sells (price, p_id, s_id) values(10.94, 32, 2);
insert into sells (price, p_id, s_id) values(7.86, 35, 2);
insert into sells (price, p_id, s_id) values(1.45, 39, 2);
insert into sells (price, p_id, s_id) values(1.02, 40, 2);
insert into sells (price, p_id, s_id) values(2.89, 42, 2);
insert into sells (price, p_id, s_id) values(2.42, 43, 2);
insert into sells (price, p_id, s_id) values(11.52, 47, 2);
insert into sells (price, p_id, s_id) values(6.32, 48, 2);
insert into sells (price, p_id, s_id) values(3.02, 49, 2);
insert into sells (price, p_id, s_id) values(0.99, 54, 2);
insert into sells (price, p_id, s_id) values(1.10, 61, 2);
insert into sells (price, p_id, s_id) values(4.02, 62, 2);
insert into sells (price, p_id, s_id) values(1.00, 63, 2);

-- 3 - Clean Company
insert into sells (price, p_id, s_id) values(0.85, 5, 3);
insert into sells (price, p_id, s_id) values(2.00, 6, 3);
insert into sells (price, p_id, s_id) values(1.50, 16, 3);
insert into sells (price, p_id, s_id) values(6.89, 17, 3);
insert into sells (price, p_id, s_id) values(4.32, 18, 3);
insert into sells (price, p_id, s_id) values(5.23, 19, 3);
insert into sells (price, p_id, s_id) values(0.85, 20, 3);
insert into sells (price, p_id, s_id) values(2.89, 64, 3);
insert into sells (price, p_id, s_id) values(1.56, 65, 3);
insert into sells (price, p_id, s_id) values(4.00, 66, 3);
insert into sells (price, p_id, s_id) values(4.25, 67, 3);

-- 4 - Athesia
insert into sells (price, p_id, s_id) values(2.50, 7, 4);
insert into sells (price, p_id, s_id) values(4.00, 21, 4);
insert into sells (price, p_id, s_id) values(15.00, 22, 4);
insert into sells (price, p_id, s_id) values(20.00, 23, 4);
insert into sells (price, p_id, s_id) values(2.50, 24, 4);
insert into sells (price, p_id, s_id) values(5.00, 25, 4);
insert into sells (price, p_id, s_id) values(4.00, 26, 4);

-- 5 - Macelleria/Metzgerei
insert into sells (price, p_id, s_id) values(3.65, 11, 5);
insert into sells (price, p_id, s_id) values(1.86, 12, 5);
insert into sells (price, p_id, s_id) values(3.89, 47, 5);
insert into sells (price, p_id, s_id) values(30.00, 53, 5);
insert into sells (price, p_id, s_id) values(24.06, 55, 5);

-- 6 - Acqua e Sapone
insert into sells (price, p_id, s_id) values(0.98, 5, 6);
insert into sells (price, p_id, s_id) values(2.88, 14, 6);
insert into sells (price, p_id, s_id) values(2.56, 15, 6);
insert into sells (price, p_id, s_id) values(1.15, 20, 6);
insert into sells (price, p_id, s_id) values(1.10, 70, 6);
insert into sells (price, p_id, s_id) values(2.54, 71, 6);
insert into sells (price, p_id, s_id) values(3.99, 72, 6);

-- 7 - Metro
insert into sells (price, p_id, s_id) values(0.89, 1, 7);
insert into sells (price, p_id, s_id) values(4.99, 2, 7);
insert into sells (price, p_id, s_id) values(0.60, 3, 7);
insert into sells (price, p_id, s_id) values(9.40, 4, 7);
insert into sells (price, p_id, s_id) values(0.80, 5, 7);
insert into sells (price, p_id, s_id) values(4.20, 6, 7);
insert into sells (price, p_id, s_id) values(0.60, 7, 7);
insert into sells (price, p_id, s_id) values(4.87, 8, 7);
insert into sells (price, p_id, s_id) values(3.29, 9, 7);
insert into sells (price, p_id, s_id) values(3.99, 10, 7);
insert into sells (price, p_id, s_id) values(3.89, 11, 7);
insert into sells (price, p_id, s_id) values(1.50, 12, 7);
insert into sells (price, p_id, s_id) values(6.12, 13, 7);
insert into sells (price, p_id, s_id) values(2.65, 14, 7);
insert into sells (price, p_id, s_id) values(2.30, 15, 7);
insert into sells (price, p_id, s_id) values(1.25, 16, 7);
insert into sells (price, p_id, s_id) values(6.89, 17, 7);
insert into sells (price, p_id, s_id) values(4.39, 18, 7);
insert into sells (price, p_id, s_id) values(11.89, 19, 7);
insert into sells (price, p_id, s_id) values(1.54, 20, 7);
insert into sells (price, p_id, s_id) values(3.89, 21, 7);
insert into sells (price, p_id, s_id) values(14.89, 22, 7);
insert into sells (price, p_id, s_id) values(18.89, 23, 7);
insert into sells (price, p_id, s_id) values(1.00, 24, 7);
insert into sells (price, p_id, s_id) values(4.54, 25, 7);
insert into sells (price, p_id, s_id) values(4.00, 26, 7);
insert into sells (price, p_id, s_id) values(4.57, 31, 7);
insert into sells (price, p_id, s_id) values(10.56, 32, 7);
insert into sells (price, p_id, s_id) values(8.60, 33, 7);
insert into sells (price, p_id, s_id) values(9.40, 34, 7);
insert into sells (price, p_id, s_id) values(7.80, 35, 7);
insert into sells (price, p_id, s_id) values(4.20, 36, 7);
insert into sells (price, p_id, s_id) values(12.60, 37, 7);
insert into sells (price, p_id, s_id) values(2.87, 38, 7);
insert into sells (price, p_id, s_id) values(2.29, 39, 7);
insert into sells (price, p_id, s_id) values(0.49, 40, 7);
insert into sells (price, p_id, s_id) values(0.59, 41, 7);
insert into sells (price, p_id, s_id) values(2.99, 42, 7);
insert into sells (price, p_id, s_id) values(2.60, 43, 7);
insert into sells (price, p_id, s_id) values(2.40, 44, 7);
insert into sells (price, p_id, s_id) values(3.80, 45, 7);
insert into sells (price, p_id, s_id) values(10.20, 46, 7);
insert into sells (price, p_id, s_id) values(9.60, 47, 7);
insert into sells (price, p_id, s_id) values(4.87, 48, 7);
insert into sells (price, p_id, s_id) values(4.29, 49, 7);
insert into sells (price, p_id, s_id) values(2.99, 50, 7);
insert into sells (price, p_id, s_id) values(6.89, 51, 7);
insert into sells (price, p_id, s_id) values(6.99, 52, 7);
insert into sells (price, p_id, s_id) values(28.60, 53, 7);
insert into sells (price, p_id, s_id) values(0.80, 54, 7);
insert into sells (price, p_id, s_id) values(21.80, 55, 7);
insert into sells (price, p_id, s_id) values(50.60, 56, 7);
insert into sells (price, p_id, s_id) values(2.20, 57, 7);
insert into sells (price, p_id, s_id) values(2.87, 58, 7);
insert into sells (price, p_id, s_id) values(1.29, 59, 7);
insert into sells (price, p_id, s_id) values(1.49, 60, 7);
insert into sells (price, p_id, s_id) values(1.12, 61, 7);
insert into sells (price, p_id, s_id) values(1.99, 62, 7);
insert into sells (price, p_id, s_id) values(1.60, 63, 7);
insert into sells (price, p_id, s_id) values(3.40, 64, 7);
insert into sells (price, p_id, s_id) values(3.20, 65, 7);
insert into sells (price, p_id, s_id) values(4.20, 66, 7);
insert into sells (price, p_id, s_id) values(5.60, 67, 7);
insert into sells (price, p_id, s_id) values(3.87, 68, 7);
insert into sells (price, p_id, s_id) values(2.29, 69, 7);
insert into sells (price, p_id, s_id) values(1.09, 70, 7);
insert into sells (price, p_id, s_id) values(2.49, 71, 7);
insert into sells (price, p_id, s_id) values(4.12, 72, 7);

-- 8 - Biokistl
insert into sells (price, p_id, s_id) values(9.80, 4, 8);
insert into sells (price, p_id, s_id) values(9.75, 13, 8);
insert into sells (price, p_id, s_id) values(5.65, 31, 8);
insert into sells (price, p_id, s_id) values(10.14, 32, 8);
insert into sells (price, p_id, s_id) values(9.36, 33, 8);
insert into sells (price, p_id, s_id) values(9.70, 34, 8);
insert into sells (price, p_id, s_id) values(8.00, 35, 8);
insert into sells (price, p_id, s_id) values(4.86, 36, 8);
insert into sells (price, p_id, s_id) values(11.87, 37, 8);

-- 9 - Typo
insert into sells (price, p_id, s_id) values(110.87, 27, 9);
insert into sells (price, p_id, s_id) values(30.00, 28, 9);
insert into sells (price, p_id, s_id) values(54.77, 29, 9);
insert into sells (price, p_id, s_id) values(50.21, 30, 9);

-- NEEDS -- RELATION --
-- Per Department
-- 1 - Administration
insert into needs (d_id, p_id) values(1, 7);
insert into needs (d_id, p_id) values(1, 21);
insert into needs (d_id, p_id) values(1, 22);
insert into needs (d_id, p_id) values(1, 23);
insert into needs (d_id, p_id) values(1, 23);
insert into needs (d_id, p_id) values(1, 24);
insert into needs (d_id, p_id) values(1, 25);
insert into needs (d_id, p_id) values(1, 26);
insert into needs (d_id, p_id) values(1, 27);
insert into needs (d_id, p_id) values(1, 28);
insert into needs (d_id, p_id) values(1, 29);
insert into needs (d_id, p_id) values(1, 30);

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
insert into needs (d_id, p_id) values(2, 24);
insert into needs (d_id, p_id) values(2, 26);
insert into needs (d_id, p_id) values(2, 31);
insert into needs (d_id, p_id) values(2, 32);
insert into needs (d_id, p_id) values(2, 33);
insert into needs (d_id, p_id) values(2, 34);
insert into needs (d_id, p_id) values(2, 35);
insert into needs (d_id, p_id) values(2, 36);
insert into needs (d_id, p_id) values(2, 37);
insert into needs (d_id, p_id) values(2, 38);
insert into needs (d_id, p_id) values(2, 39);
insert into needs (d_id, p_id) values(2, 40);
insert into needs (d_id, p_id) values(2, 41);
insert into needs (d_id, p_id) values(2, 42);
insert into needs (d_id, p_id) values(2, 43);
insert into needs (d_id, p_id) values(2, 44);
insert into needs (d_id, p_id) values(2, 45);
insert into needs (d_id, p_id) values(2, 46);
insert into needs (d_id, p_id) values(2, 47);
insert into needs (d_id, p_id) values(2, 48);
insert into needs (d_id, p_id) values(2, 49);
insert into needs (d_id, p_id) values(2, 50);
insert into needs (d_id, p_id) values(2, 51);
insert into needs (d_id, p_id) values(2, 52);
insert into needs (d_id, p_id) values(2, 53);
insert into needs (d_id, p_id) values(2, 54);
insert into needs (d_id, p_id) values(2, 55);
insert into needs (d_id, p_id) values(2, 56);
insert into needs (d_id, p_id) values(2, 57);
insert into needs (d_id, p_id) values(2, 58);
insert into needs (d_id, p_id) values(2, 59);
insert into needs (d_id, p_id) values(2, 60);
insert into needs (d_id, p_id) values(2, 61);
insert into needs (d_id, p_id) values(2, 62);
insert into needs (d_id, p_id) values(2, 63);

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
insert into needs (d_id, p_id) values(3, 24);
insert into needs (d_id, p_id) values(3, 26);
insert into needs (d_id, p_id) values(3, 64);
insert into needs (d_id, p_id) values(3, 65);
insert into needs (d_id, p_id) values(3, 66);
insert into needs (d_id, p_id) values(3, 67);
insert into needs (d_id, p_id) values(3, 68);
insert into needs (d_id, p_id) values(3, 69);
insert into needs (d_id, p_id) values(3, 70);
insert into needs (d_id, p_id) values(3, 71);
insert into needs (d_id, p_id) values(3, 72);


-- DEPTSUP -- RELATION --
-- 1 Administration --
insert into deptsup (d_id, s_id) values (1, 2);
insert into deptsup (d_id, s_id) values (1, 4);
insert into deptsup (d_id, s_id) values (1, 7);
insert into deptsup (d_id, s_id) values (1, 9);
-- 2 Kitchen --
insert into deptsup (d_id, s_id) values (2, 1);
insert into deptsup (d_id, s_id) values (2, 2);
insert into deptsup (d_id, s_id) values (2, 4);
insert into deptsup (d_id, s_id) values (2, 5);
insert into deptsup (d_id, s_id) values (2, 7);
insert into deptsup (d_id, s_id) values (2, 8);
-- 3 Clean --
insert into deptsup (d_id, s_id) values (3, 3);
insert into deptsup (d_id, s_id) values (3, 4);
insert into deptsup (d_id, s_id) values (3, 6);
insert into deptsup (d_id, s_id) values (3, 7);




