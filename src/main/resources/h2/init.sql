create table user (
    id bigint auto_increment,
    name varchar(50),
    balance int,
    primary key (id)
);

create table user_transaction (
    id bigint auto_increment,
    user_id bigint,
    amount int,
    transaction_date timestamp,
    foreign key (user_id) references user(id) on delete cascade
);

insert into user (name, balance) values ('Manoj k', 2000), ('Ananya Yadav', 2000), ('Shreya Yadav', 2000), ('Sunita K', 2000);