create table note_groups
(
    id INTEGER primary key auto_increment,
    title varchar(100) not null,
    created_on datetime null,
    updated_on datetime null
);
alter table notes add column note_groups_id Integer null;
alter table notes add foreign key (note_groups_id) references note_groups(id);