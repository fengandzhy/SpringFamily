CREATE TABLE IF NOT EXISTS user(
id bigint(20) NOT NULL AUTO_INCREMENT,
username varchar(255) DEFAULT NULL,
password varchar(255) DEFAULT NULL,
PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS customer(
id bigint(20) NOT NULL AUTO_INCREMENT,
customer_name varchar(255) DEFAULT NULL,
balance double(8,4) DEFAULT NULL,
PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
--insert into customer (customer_name,balance) values ('a',5.23)



CREATE TABLE IF NOT EXISTS clothes(
id bigint(20) NOT NULL AUTO_INCREMENT,
price double(8,4) DEFAULT NULL,
category varchar(255) DEFAULT NULL,
inventory int(8) DEFAULT NULL,
PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;