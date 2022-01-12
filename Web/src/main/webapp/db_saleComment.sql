create table saleReply(
	s_no number(3) primary key,
	s_name varchar2 (50 char) not null,
	s_content varchar2 (300 char) not null,
	s_date date not null
);

create sequence saleReply_seq;

select * from saleReply;