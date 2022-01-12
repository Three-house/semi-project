create table sales(
s_no number(3) primary key,
s_name varchar2(20 char) not null,
s_salesort varchar2(20 char) not null,
s_location varchar2(20 char) not null,
s_address varchar2(30 char) not null,
s_size varchar2(20 char) not null,
s_condition varchar2(20 char) not null,
s_price varchar2(20 char) not null,
s_date date not null,
s_etc varchar2(500 char) not null,
s_img1 varchar2(50 char) not null,
s_img2 varchar2(50 char) not null,
s_img3 varchar2(50 char) not null,
s_contact varchar2(20 char) not null
);

create sequence sales_seq;

insert into sales values (sales_seq.nextval,'망원동아파트','아파트','서울','테스트용','50.1','전세','8000',sysdate,
'옵션:에어컨','사진1','사진2','사진3','전번');

select * from sales;

drop table sales;