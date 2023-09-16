insert into NickDB.CUSTOMERS (name, surname, age, phone_number)
values
('Иван', 'Кащеев', 25, 73337896641),
('Роберт', 'Венградов', 29, 73337896656),
('Alexey', 'Иванов', 21, 73337896651),
('alexey', 'Петров', 26, 73337896657);

insert NickDB.ORDERS(dt, customer_id, product_name, amount)
values
(20230901, 1, 'product1', 10),
(20230903, 1, 'product2', 11),
(20230903, 3, 'product3', 13),
(20230904, 2, 'product2', 16),
(20230907, 4, 'product4', 18),
(20230907, 4, 'product5', 10),
(20230911, 3, 'product3', 15);