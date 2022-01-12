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

insert into sales values (sales_seq.nextval,'����������Ʈ','����Ʈ','����','�׽�Ʈ��','50.1','����','8000',sysdate,
'�ɼ�:������','����1','����2','����3','����');

select * from sales;

drop table sales;