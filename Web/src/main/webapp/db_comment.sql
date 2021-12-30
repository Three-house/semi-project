
CREATE TABLE comments(
	boardID int,
	commentID int,
	bbsID int,
	userID varchar2(50 char),
	commentDate date,
	commentText varchar2(300 char),
	commentAvailable int
);

alter table comments add primary key (commentID, bbsID);

alter table comments 
add constraint bbsID foreign key (bbsID) references community (c_no);

