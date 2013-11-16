drop table messages if exists;
 
CREATE TABLE messages
(
	id int auto_increment,
	title varchar(255),
	body varchar(255),
	timestamp long,
	PRIMARY KEY (id)
);
