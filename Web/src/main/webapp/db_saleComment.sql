create table saleComment(

	sc_boardID int,
	sc_commentID int,
	sc_bbsID int,
	sc_userID varchar2(50 char),
	sc_commentDate varchar2(50 char),
	sc_commentText varchar2(300 char),
	sc_commentAvailable int

);

alter table saleComment add primary key (sc_commentID, sc_bbsID);

alter table saleComment
add constraint sc_bbsID foreign key (sc_bbsID) references sales (s_no);