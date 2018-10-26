/* 게시판 */
CREATE TABLE jsp_board (
	board_id NUMBER NOT NULL, /* 게시판 ID */
	board_subject VARCHAR2(50) NOT NULL, /* 게시판 이름 */
	board_avail INTEGER, /* 게시판 사용여부 */
	board_date DATE NOT NULL, /* 게시판 등록일 */
	board_userid VARCHAR2(50) /* 게시판 등록자 */
);

COMMENT ON TABLE jsp_board IS '게시판';

COMMENT ON COLUMN jsp_board.board_id IS '게시판 ID';

COMMENT ON COLUMN jsp_board.board_subject IS '게시판 이름';

COMMENT ON COLUMN jsp_board.board_avail IS '게시판 사용여부';

COMMENT ON COLUMN jsp_board.board_date IS '게시판 등록일';

COMMENT ON COLUMN jsp_board.board_userid IS '게시판 등록자';

CREATE UNIQUE INDEX PK_jsp_board
	ON jsp_board (
		board_id ASC
	);

ALTER TABLE jsp_board
	ADD
		CONSTRAINT PK_jsp_board
		PRIMARY KEY (
			board_id
		);

/* 게시글 */
CREATE TABLE post (
	post_id NUMBER NOT NULL, /* 게시글 ID */
	board_id NUMBER NOT NULL, /* 게시판 ID */
	post_title VARCHAR2(210) NOT NULL, /* 게시글 제목 */
	post_article CLOB NOT NULL, /* 게시글 내용 */
	post_pid NUMBER, /* 부모게시글번호 */
	post_date DATE NOT NULL, /* 게시글 등록일 */
	post_del INTEGER, /* 게시글 삭제여부 */
	post_groupId NUMBER, /* 조상게시글번호 */
	post_userid VARCHAR2(50) /* 게시글 작성자 */
);

COMMENT ON TABLE post IS '게시글';

COMMENT ON COLUMN post.post_id IS '게시글 ID';

COMMENT ON COLUMN post.board_id IS '게시판 ID';

COMMENT ON COLUMN post.post_title IS '게시글 제목';

COMMENT ON COLUMN post.post_article IS '게시글 내용';

COMMENT ON COLUMN post.post_pid IS '부모게시글번호';

COMMENT ON COLUMN post.post_date IS '게시글 등록일';

COMMENT ON COLUMN post.post_del IS '게시글 삭제여부';

COMMENT ON COLUMN post.post_groupId IS '조상게시글번호';

COMMENT ON COLUMN post.post_userid IS '게시글 작성자';

CREATE UNIQUE INDEX PK_post
	ON post (
		post_id ASC
	);

ALTER TABLE post
	ADD
		CONSTRAINT PK_post
		PRIMARY KEY (
			post_id
		);

/* 첨부파일 */
CREATE TABLE file_post (
	file_id NUMBER NOT NULL, /* 첨부파일 ID */
	file_path VARCHAR2(500), /* 첨부파일 */
	post_id NUMBER NOT NULL /* 게시글 ID */
);

COMMENT ON TABLE file_post IS '첨부파일';

COMMENT ON COLUMN file_post.file_id IS '첨부파일 ID';

COMMENT ON COLUMN file_post.file_path IS '첨부파일';

COMMENT ON COLUMN file_post.post_id IS '게시글 ID';

CREATE UNIQUE INDEX PK_file_post
	ON file_post (
		file_id ASC
	);

ALTER TABLE file_post
	ADD
		CONSTRAINT PK_file_post
		PRIMARY KEY (
			file_id
		);

/* 댓글 */
CREATE TABLE comm (
	comm_id NUMBER NOT NULL, /* 댓글ID */
	post_id NUMBER NOT NULL, /* 게시글 ID */
	comm_note VARCHAR2(255) NOT NULL, /* 댓글 내용 */
	comm_date DATE NOT NULL, /* 댓글 작성일시 */
	comm_del INTEGER, /* 댓글 삭제여부 */
	comm_userid VARCHAR2(50) /* 댓글 작성자 */
);

COMMENT ON TABLE comm IS '댓글';

COMMENT ON COLUMN comm.comm_id IS '댓글ID';

COMMENT ON COLUMN comm.post_id IS '게시글 ID';

COMMENT ON COLUMN comm.comm_note IS '댓글 내용';

COMMENT ON COLUMN comm.comm_date IS '댓글 작성일시';

COMMENT ON COLUMN comm.comm_del IS '댓글 삭제여부';

COMMENT ON COLUMN comm.comm_userid IS '댓글 작성자';

CREATE UNIQUE INDEX PK_comm
	ON comm (
		comm_id ASC
	);

ALTER TABLE comm
	ADD
		CONSTRAINT PK_comm
		PRIMARY KEY (
			comm_id
		);

ALTER TABLE post
	ADD
		CONSTRAINT FK_jsp_board_TO_post
		FOREIGN KEY (
			board_id
		)
		REFERENCES jsp_board (
			board_id
		);

ALTER TABLE post
	ADD
		CONSTRAINT FK_post_TO_post
		FOREIGN KEY (
			post_pid
		)
		REFERENCES post (
			post_id
		);

ALTER TABLE post
	ADD
		CONSTRAINT FK_jspuser_TO_post
		FOREIGN KEY (
			post_userid
		)
		REFERENCES jspuser (
			userId
		);

ALTER TABLE file_post
	ADD
		CONSTRAINT FK_post_TO_file_post
		FOREIGN KEY (
			post_id
		)
		REFERENCES post (
			post_id
		);

ALTER TABLE comm
	ADD
		CONSTRAINT FK_post_TO_comm
		FOREIGN KEY (
			post_id
		)
		REFERENCES post (
			post_id
		);

ALTER TABLE comm
	ADD
		CONSTRAINT FK_jspuser_TO_comm
		FOREIGN KEY (
			comm_userid
		)
		REFERENCES jspuser (
			userId
		);

/* 회원 */
CREATE TABLE jspuser (
	userId VARCHAR2(50) NOT NULL, /* 회원아이디 */
	name VARCHAR2(50) NOT NULL, /* 이름 */
	pass VARCHAR2(256) NOT NULL, /* 비밀번호 */
	addr1 VARCHAR2(255), /* 도로주소 */
	addr2 VARCHAR2(255), /* 도로주소상세 */
	zip VARCHAR2(5), /* 우편번호 */
	birth DATE, /* 생년월일 */
	email VARCHAR2(40), /* 이메일 */
	tel VARCHAR2(30), /* 전화번호 */
	profile VARCHAR2(500) /* 프로필경로 */
);

COMMENT ON TABLE jspuser IS '회원';

COMMENT ON COLUMN jspuser.userId IS '회원아이디';

COMMENT ON COLUMN jspuser.name IS '이름';

COMMENT ON COLUMN jspuser.pass IS '비밀번호';

COMMENT ON COLUMN jspuser.addr1 IS '도로주소';

COMMENT ON COLUMN jspuser.addr2 IS '도로주소상세';

COMMENT ON COLUMN jspuser.zip IS '우편번호';

COMMENT ON COLUMN jspuser.birth IS '생년월일';

COMMENT ON COLUMN jspuser.email IS '이메일';

COMMENT ON COLUMN jspuser.tel IS '전화번호';

COMMENT ON COLUMN jspuser.profile IS '프로필경로';

CREATE UNIQUE INDEX PK_jspuser
	ON jspuser (
		userId ASC
	);

ALTER TABLE jspuser
	ADD
		CONSTRAINT PK_jspuser
		PRIMARY KEY (
			userId
		);

ALTER TABLE jsp_board
	ADD
		CONSTRAINT FK_jspuser_TO_jsp_board
		FOREIGN KEY (
			board_userid
		)
		REFERENCES jspuser (
			userId
		);

ALTER TABLE post
	ADD
		CONSTRAINT FK_jsp_board_TO_post
		FOREIGN KEY (
			board_id
		)
		REFERENCES jsp_board (
			board_id
		);

ALTER TABLE post
	ADD
		CONSTRAINT FK_post_TO_post
		FOREIGN KEY (
			post_pid
		)
		REFERENCES post (
			post_id
		);

ALTER TABLE post
	ADD
		CONSTRAINT FK_jspuser_TO_post
		FOREIGN KEY (
			post_userid
		)
		REFERENCES jspuser (
			userId
		);

ALTER TABLE file_post
	ADD
		CONSTRAINT FK_post_TO_file_post
		FOREIGN KEY (
			post_id
		)
		REFERENCES post (
			post_id
		);

ALTER TABLE comm
	ADD
		CONSTRAINT FK_post_TO_comm
		FOREIGN KEY (
			post_id
		)
		REFERENCES post (
			post_id
		);

ALTER TABLE comm
	ADD
		CONSTRAINT FK_jspuser_TO_comm
		FOREIGN KEY (
			comm_userid
		)
		REFERENCES jspuser (
			userId
		);

--drop table file_post;
--drop table comm;
--drop table post;
--drop table jsp_board;
--drop table jspuser;

/*** 시퀀스들 ***/
CREATE SEQUENCE boardNo 
START WITH 1 
INCREMENT BY 1;
--drop sequence postNo;
CREATE SEQUENCE postNo 
START WITH 1 
INCREMENT BY 1;

CREATE SEQUENCE commNo 
START WITH 1 
INCREMENT BY 1; 

CREATE SEQUENCE fileNo 
START WITH 1 
INCREMENT BY 1;      

--DUMMY DATA
--BOARD
INSERT INTO jsp_board (board_id, board_subject, board_avail, board_date, board_userid ) VALUES (boardNo.nextVal, '공지', 0, sysdate, 'brown');
INSERT INTO jsp_board (board_id, board_subject, board_avail, board_date, board_userid ) VALUES (boardNo.nextVal, '자유게시판', 0, sysdate, 'brown');
INSERT INTO jsp_board (board_id, board_subject, board_avail, board_date, board_userid ) VALUES (boardNo.nextVal, '기린 유머', 0, sysdate, 'brown');
--POST
INSERT INTO post (POST_ID, BOARD_ID, POST_TITLE, POST_ARTICLE, POST_PID, POST_DATE, POST_DEL, POST_GROUPID, POST_USERID ) 
VALUES ( postNo.nextVal, 2, '자유를 갈망합니다', '프리덤!!! 모두 갑시다! 자유를 향해', '', sysdate, 0, postNo.nextVal, 'brown');

INSERT INTO post (POST_ID, BOARD_ID, POST_TITLE, POST_ARTICLE, POST_PID, POST_DATE, POST_DEL, POST_GROUPID, POST_USERID ) 
VALUES ( postNo.nextVal, 1, '첫번째 공지', '모두 반갑습니다. 깨끗한 커뮤니티를 부탁드립니다!', '', sysdate, 0, postNo.nextVal, 'brown');
INSERT INTO post (POST_ID, BOARD_ID, POST_TITLE, POST_ARTICLE, POST_PID, POST_DATE, POST_DEL, POST_GROUPID, POST_USERID ) 
VALUES ( postNo.nextVal, 1, '두번째 공지', '날이 추우니 옷은 따뜻하게 입으세요~', '', sysdate, 0, postNo.nextVal, 'sally');
INSERT INTO post (post_id, board_id, post_title, post_article, post_pid, post_date, post_del, post_groupid, post_userid ) 
VALUES (postNo.nextVal, 1, postNo.nextVal, '날이 추우니 옷은 따뜻하게 입으세요~', '', sysdate, 0, postNo.nextVal, 'sally');
INSERT INTO post (POST_ID, BOARD_ID, POST_TITLE, POST_ARTICLE, POST_PID, POST_DATE, POST_DEL, POST_GROUPID, POST_USERID ) 
VALUES ( postNo.nextVal, 1, '두번째공지 답글', '내일부터 날이 풀린대요', 2, sysdate, 0, 2, 'sally');
UPDATE post SET post_groupid = post_id WHERE post_id = '1p14';
select * from post order by post_date;

--USER
insert into jspuser values ('brown','브라운', 'brownpass', '대전시 중구 대흥동 76', '2층 대덕인재개발원', '34940', to_date('20180808','yyyymmdd'), 'brown@gmail.com', '123123123', '');
insert into jspuser values ('sally', '샐리', 'sallypass', '대전시 중구 대흥동 76', '2층 대덕인재개발원', '34940', to_date('20180427', 'yyyymmdd'), 'sally@gmail.con', '123123123', '');
insert into jspuser values ('cony', '코니', 'conypass', '대전시 중구 대흥동 76', '2층 대덕인재개발원', '34940', to_date('20180717', 'yyyymmdd'), 'cony@gmail.con', '123123123', '');
insert into jspuser values ('moon', '문', 'moonpass','대전시 중구 대흥동 76', '2층 대덕인재개발원', '34940', to_date('20181006', 'yyyymmdd'), 'moon@gmail.con','123123123', '');
insert into jspuser values ('james', '제임스', 'jamespass', '대전시 중구 대흥동 76', '2층 대덕인재개발원', '34940',to_date('20180214', 'yyyymmdd'), 'james@gmail.con','123123123', '');
Update jspuser Set pass='f01471c38113db263f9a532d8b6c054af31bf653aeea92d1c284cdd022b9' Where userid = 'brown';
--COMM
insert into comm values (commNo.nextVal, 23, '댓글 test1', sysdate, 0, 'brown');
--FILE_POST

commit;
rollback;
select * from jsp_board;
select * from jspuser;
select * from post;
select * from file_post;
select * from comm;
desc comm;

/* Vo 만들기 */
select 'private ' || 
        decode(lower(data_type), 'number', 'int ', 'String ')||
        lower(column_name) || ';'
from    cols
where   lower(table_name) = 'comm';


/* 페이징 처리 */
--정렬 기준 : userId
--***rownum은 중간 번호부터 찾기가 불가능하기 때문에 inline으로 작업해줍니다.
select *
from ( 
    select rownum rnum, a.* 
    from (
        select jspuser.*
        from   jspuser
        order by userId) a)
where rnum between 11 and 20;
--query id : selectUserPageList
--메소드 인자 kr.or.ddit.util.model.PageVo (page, pageSize)
select *
from ( 
    select rownum rnum, a.* 
    from (
        select jspuser.*
        from   jspuser
        order by userId) a)
where rnum between #{page}*#{pageSize}-(#{pageSize}-1)
            and #{page}*#{pageSize};

--게시글 정렬
select board_id, post_id,lpad('┗ ',(level-1)*4, ' ')|| post_title title, post_article, post_pid, post_groupid, post_date, post_del, post_userid, level 
from post
start with post_pid is null 
connect by prior post_id = post_pid
order siblings by  post_groupid desc, post_id asc;

--게시글 페이징 정렬
select *
from (
    select rownum rnum, a.* 
    from (
        select board_id, post_id,lpad('┗ ',(level-1)*4, ' ')|| post_title title, post_article, post_pid, post_groupid, post_date, post_del, post_userid, level 
        from post
        where board_id = 1
        start with post_pid is null 
        connect by prior post_id = post_pid
        order siblings by  post_groupid desc, post_id asc) a)
where rnum between 1 and 10;

    
select rownum as rnum, data.*
from (
    select lpad(' ',(level-1)*4, ' ')|| title, board.*, level as le
    from board
    start with pid is null 
    connect by prior id = pid
    order siblings by id desc, uploaddate asc
    ) data;

commit;



