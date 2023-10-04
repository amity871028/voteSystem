CREATE DATABASE vote_system;
USE vote_system;
CREATE TABLE item (
	id int,
	name varchar(255),
    primary key (id)
);
CREATE TABLE record (
	voter varchar(255),
	itemId int,
    primary key (voter, itemId),
    FOREIGN KEY (itemId) REFERENCES item(id)
);
