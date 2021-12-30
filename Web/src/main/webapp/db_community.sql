create table community(
	c_no number(3) primary key,
	c_userId varchar2(50 char) not null,
	c_title varchar2(50 char) not null,
	c_content varchar2(200 char) not null,
	c_img varchar2(30 char) not null,
	c_date date not null
);

create sequence community_seq;

insert into community values (community_seq.nextval, '�������̵�','Ŀ������','Ŀ�±�','Ŀ�»���',sysdate);

select * from community;