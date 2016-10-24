--ch08:DML(Data Manipulation Language) - 데이터 관련된 명령어
--                                                      저장(insert), 수정(update), 삭제(delete), 조회(select)
--        DDL(Data Definition Language) - 데이터베이스 객체(Object)와 관련된 명령어
--                                                  생성(create), 삭제(drop), 수정(alter)
--        DCL(Data Control Language) - 권한 및 사용자와 관련된 명령어
--                                               권한할당(grant), 권한삭제(revoke), 작업반영(commit), 작업취소(rollback)

--Section01 테이블의 내용을 추가하는 INSERT 문
insert into member(mid, mname, mage, mbirth)
values('user3', '사용자3', 10, '2006.5.16');

insert into member(mid, mname)
values('user4', '사용자4'); --나머지 컬럼에 not null가 없어서 실행됨

insert into member
values('user5', '사용자3', null, null); --컬럼을 생략하는데신 존재하는 컬럼과 일치하게 데이터를 넣어줌

insert into board(BNO, BTITLE, BCONTENT, BWRITER, BHITCOUNT, BDATE)
values(4, '제목4', '내용4', 'user2', 0, '16/10/19');

insert into board
values(5, '제목5', '내용5', 'user3', 0, sysdate);

insert into board(BNO, BTITLE, BCONTENT, BWRITER)
values(6, '제목6', '내용6', 'user2');

--Section02 테이블의 내용을 수정하는 UPDATE문
update member set mage=10; --이렇게 쓰면 큰일남 모든 mage값이 10으로 바뀜 ㄸㄸㄸㄸㄸㄸㄸ
--그래서 update문은 반드시 where와 함께써야한다
update member set mage=10 where mid='user4';
update member set mage=20, mbirth='2001.08.10' where mid='user5';
update member set mage=mage+1 where mid='user4';

--Section03 테이블의 내용을 삭제하는 DELETE문
delete member; --마찬가지로 큰일남 ㅋㅋㅋㅋㅋㅋㅋㅋ
delete member where mid='user5'; --그래서 where과 함께 쓴다
delete member where mage<=20;

--Section04 트랜젝션 관리
create table account(
  ano varchar(20) not null,
  abalance number(10) null
);
insert into account(ano, abalance) values('111-111', 1000000);
insert into account(ano, abalance) values('111-112', 0);
commit;
--계좌이체 : 출급작업 + 입금작업 -> ★트랜잰션 작업 = All or Nothing으로 구성됨
--1.출금작업
update account set abalance=abalance-10000 where ano='111-111';
select * from account;
    --계좌에서 출금했음
--2.입금작업
update account set abalance=abalance+10000 where ano='111-113'; 
    --근데 위에는 데이터가 없음
    --그래서 출금은 성공했으나, 입금이 실패했기때문에 전체를 실패처리해야함
rollback; --그래서 롤백함(1,2과정 취소)
    --그러나 출금은 성공했고 입금도 성공했다면 전체를 영구반영 처리해야함
commit; --그래서 커밋함(1,2,과정 반영)
