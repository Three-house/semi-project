create table account (
a_name varchar2 (20 char) not null,
a_id varchar2 (30 char) primary key,
a_pw varchar2 (30 char) not null,
a_sex char (1 char) not null,
a_contact varchar2 (30 char) not null,
a_addr varchar2 (100 char) not null
);

insert into account values ('sr','id','pw','ø©','0101234567','¡÷º“');

delete from account where a_id = 'jsjsjs1';

select * from account;