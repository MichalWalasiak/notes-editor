drop table if exists notes;
create table notes(
    id INTEGER primary key auto_increment,
    title varchar(100) not null,
    content varchar(400) not null
)