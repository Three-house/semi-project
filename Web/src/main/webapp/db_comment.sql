drop table replies;

drop sequence replies_seq;

create table replies(
	re_no number(3) primary key,
	re_name varchar2(50 char) not null,
	re_content varchar2(300 char) not null,
	re_date date not null
);

create sequence replies_seq;

select * from REPLIES;