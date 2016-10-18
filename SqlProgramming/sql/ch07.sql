--Section01 테이블 구조를 만드는 CREATE TABLE문
create table member (
  mid varchar(10) not null,
  mname varchar(10) not null,
  mage number(3,0) null,
  mbirth date null
);

create table board (
  bno number(10) not null,
  btitle varchar(100) not null,
  bcontent varchar(4000) not null,
  bwriter varchar(10) not null,
  bhitcount number(5) not null,
  bdate date null
);

--Section02 테이블 구조를 변경하는 ALTER TABLE 문
alter table member add email varchar(100) null;
alter table member modify email varchar(50) null;
alter table member drop column email;


--Section03 테이블명을 변경하는 RENAME문
alter table member rename to member2;
--alter table 옛날이름 rename to 새로운이름;

--Section04 테이블을 삭제하는 DROP TABLE문
drop table member;
drop table board;



