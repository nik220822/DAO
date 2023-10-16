create table ORDERS (
id integer primary key auto_increment,
dt date,
customer_id integer,
product_name varchar(100),
amount integer,
foreign key (customer_id) references CUSTOMERS(id)
);