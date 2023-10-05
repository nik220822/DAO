create table CUSTOMERS (
id int primary key auto_increment,
name varchar(100),
surname varchar(100),
age int,
phone_number varchar(100)
);

create table ORDERS (
id integer primary key auto_increment,
dt date,
customer_id integer,
product_name varchar(100),
amount integer,
foreign key (customer_id) references CUSTOMERS(id)
);

