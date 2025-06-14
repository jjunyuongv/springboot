DROP TABLE myboard;

--테이블 생성
create table myboard (
	idx number primary key, 
	name varchar2(50), 
	title varchar2(200), 
	content varchar2(2000), 
	postdate date default sysdate, 
	visitcount number default 0
);

--더미 데이터 입력
insert into myboard (idx, name, title, content)
    values (seq_board_num.nextval, '김유신', '자료실 제목1 입니다.','내용');
insert into myboard (idx, name, title, content)
    values (seq_board_num.nextval, '장보고', '자료실 제목2 입니다.','내용');
insert into myboard (idx, name, title, content)
    values (seq_board_num.nextval, '이순신', '자료실 제목3 입니다.','내용');
insert into myboard (idx, name, title, content)
    values (seq_board_num.nextval, '강감찬', '자료실 제목4 입니다.','내용');
insert into myboard (idx, name, title, content)
    values (seq_board_num.nextval, '대조영', '자료실 제목5 입니다.','내용');
commit;
select * from myboard;
