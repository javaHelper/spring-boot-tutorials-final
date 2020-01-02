create table employees (
       id bigint not null auto_increment,
        email_address varchar(255) not null,
        first_name varchar(255) not null,
        last_name varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

INSERT INTO `test`.`employees`(`email_address`, `first_name`, `last_name`) VALUES ('SamLawrence@armyspy.com', 'Sam', 'Lawrence');
INSERT INTO `test`.`employees`(`email_address`, `first_name`, `last_name`) VALUES ('MatthewAkhtar@teleworm.us', 'Matthew', 'Akhtar');
INSERT INTO `test`.`employees`(`email_address`, `first_name`, `last_name`) VALUES ('LucasShort@jourrapide.com', 'Lucas', 'Short');
INSERT INTO `test`.`employees`(`email_address`, `first_name`, `last_name`) VALUES ('PeterBriggs@jourrapide.com', 'Peter', 'Briggs');
INSERT INTO `test`.`employees`(`email_address`, `first_name`, `last_name`) VALUES ('PatrickBishop@armyspy.com', 'Patrick', 'Bishop');
INSERT INTO `test`.`employees`(`email_address`, `first_name`, `last_name`) VALUES ('DylanBull@dayrep.com', 'Dylan', 'Bull');
INSERT INTO `test`.`employees`(`email_address`, `first_name`, `last_name`) VALUES ('JacobWard@jourrapide.com', 'Jacob', 'Ward');
INSERT INTO `test`.`employees`(`email_address`, `first_name`, `last_name`) VALUES ('JoeCooper@jourrapide.com', 'Joe', 'Cooper');
INSERT INTO `test`.`employees`(`email_address`, `first_name`, `last_name`) VALUES ('MaxOwens@teleworm.us', 'Max', 'Owens');
