--Section01 시퀀스 생성
create sequence seq_1; --시퀀스 생성하기
--다음수 얻기
select seq_1.nextval from dual; --LAST_NUMBER
--현재부여된 번호(다음수얻기 현재값과 동일하다)
select seq_1.currval from dual; --현재연결에서의 최근 부여값을 구하는것

--시퀀스를 상세하게 만드는 방법
create sequence seq_2
  start with 101
  increment by 10
  maxvalue 1000
  nocycle --cycle는 되돌아고싶을때(반복하고싶을때)
  nocache;
select seq_2.nextval from dual;

--시퀀스를 지우는 방법
drop sequence seq_1;
drop sequence seq_2;

--Section04 인덱스 개요 p490
set timing on;
select * from board where btitle like '%9333%'; --DBMS는 저장된 순서대로 하나씩 찾아낸다 이것이 TABLE 스캔(위에서 아래방향)
--이렇게 순차검색보다는 인덱스가 더 효율적이다(인덱스를 통해 where조건절에 대한 조회속도를 빠르게하기 위해서)
create index inx_board_btitle on board(btitle); --조건으로 자주사용하는 컬럼을 인덱스로 만드는것) / 1. 중복이 되도 상관없는 컬럼에 만드는 인덱스
select * from board where btitle like '%9333%';
drop index inx_board_btitle;

select * from board where bno=9333; --인덱스만들기전
create unique index seq_board_bno on board(bno); --인덱스 지정하기 / 2. 중복이 없는 컬럼에 만드는 인덱스(여기선 직접만든방식)
select * from board where bno=9333; --인덱스만든다음
drop index seq_board_bno;

-- 이건 시험에 안나오고 왜 쓰이는지만 알자! (시험에 인덱스를 만드는 코드는 안나옴)
--1. 중복이 되도 상관없는 컬럼에 만드는 인덱스
--   -> 수동으로 만드는건데 인덱스가 없는것보다 빠르게 검색된다
--2. 중복이 없는 컬럼에 만드는 인덱스
--   -> PK를 설정하고나 유니크제약을 설정하면 자동으로 만들어짐(물론 수동으로 만들수있지만 자동으로 만들어지니 따로 만들필요가없다)


