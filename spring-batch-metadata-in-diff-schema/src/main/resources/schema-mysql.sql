create table Customer (
       id bigint not null auto_increment,
        birthdate datetime,
        firstName varchar(255),
        lastName varchar(255),
        primary key (id)
    ) engine=InnoDB;