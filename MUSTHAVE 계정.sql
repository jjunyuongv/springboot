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

-------------------------------
drop table transaction_pay;
drop table transaction_ticket;

create table transaction_pay (
    userid varchar2(30) not null,  
    amount number not null
); 

create table transaction_ticket (
    userid varchar2(30) not null,
    t_count number(2) not null 
        check(t_count<=5)
);

insert into transaction_ticket values ('tjoeun', 2);
insert into transaction_pay values ('tjoeun', 20000);

insert into transaction_ticket values ('error', 8);
insert into transaction_pay values ('error', 80000);

commit;

-----------------------------------------------
create table security_admin (
    user_id varchar2(30) primary key,
    user_pw varchar2(200) not null,
    authority varchar2(20) default 'ROLE_USER',
    enabled number(1) default 1
);

insert into security_admin values ('user1', '1234', 'ROLE_USER', 1);
insert into security_admin values ('user2', '1234', 'ROLE_USER', 0);    
insert into security_admin values ('admin1', '1234', 'ROLE_ADMIN', 1);    
insert into security_admin values ('admin2', '1234', 'ROLE_ADMIN', 0);   
commit;

select * from security_admin;

update security_admin set user_pw='$2a$10$47LoTH3WzjOStQPjcYfZ7uE4rH2PnQ.9WZXJ7E7XOJtxxmILdSqYi';
select * from security_admin;
commit;




