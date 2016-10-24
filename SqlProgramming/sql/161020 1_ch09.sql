-- ────────────────────────────────────────────────────────────────────────
--Section04 유일한 값만 허용하는 UNIQUE 제약 조건
-- ────────────────────────────────────────────────────────────────────────
drop table member;
create table member(
mid varchar(10) unique not null, --무결성 제약조건
mname varchar(10) not null,
mage number(3) null,
memail char(50) unique null,
mbirth date null
);

insert into member values('user1', '사용자1', 25, 'user1@sw.com', sysdate);
insert into member values('user2', '사용자2', 25, 'user2@sw.com', sysdate);
insert into member values('user3', '사용자3', 25, null, sysdate);
insert into member values('user4', '사용자4', 25, null, sysdate); --unique에서 null 일경우 null unique제약에 포함되지 않아서 중복이 허용됨으로(null은 값이 아님) 이것도 insert가 된다
insert into member values('user1', '사용자1', 25, 'u1@sw.com', sysdate); --무결성 제약조건에 위배됨(SQL 오류: ORA-00001: 무결성 제약 조건(TESTER1.SYS_C0011017)에 위배됩니다)
                                                                                               --이 식별값은 SYS_C0011017 MEMBER테이블의 제약조건에 명시되어있다
                                                                                               --이 SYS_.... 어쩌구는 오라클이 알아서 만들어냄   
                                                                                               
-- ────────────────────────────────────────────────────────────────────────
--Section06 데이터 구분을 위한 PRIMARY KEY 제약조건
-- ────────────────────────────────────────────────────────────────────────
--1. unique하면서 not null
--2. 한 테이블당 1개만 설정가능
--3. 행을 구별하는 식별값으로 사용
drop table member;
create table member(
mid varchar(10) primary key, --primary key는 unique하면 not null이다, 또 한 테이블당 이 PK는 한번만 지정가능
                                        --이것은 member테이블에서 행을 식별하는 식별자로 사용되는구나~
mname varchar(10) not null,
mage number(3) null,
memail char(50) unique null,  -- 이것은 유니크하면서 null 이구나~
mbirth date null
);

-- ────────────────────────────────────────────────────────────────────────
--Section07 참조 무결성을 위한  FOREIGN KEY 제약조건
-- ────────────────────────────────────────────────────────────────────────
--외부 테이블의 PK값만 입력할 수 있도록 함
--외부의 PK값에는 null이 들어갈수없음으로 당연히 이 FK값에도 null이 들어갈수없다
drop table board;
create table board (
  bno number(10) primary key, --이것은 board 테이블에서 행을 식별하는 식별자구나~
  btitle varchar(100) not null,
  bcontent varchar(4000) not null,
  bwriter varchar(10) references member(mid), --외부에 존재하는 PK(=unique하면서 not null)인 값을 넣겠다
  bhitcount number(5) not null,
  bdate date null
);

insert into board values(1, '제목1', '내용1', '홍길동', 0, sysdate); --홍길동이라는 값이 PK인 member테이블의 mid값에 존재하지 않으니깐 : SQL 오류: ORA-02291: 무결성 제약조건(TESTER1.SYS_C0011034)이 위배되었습니다- 부모 키가 없습니다
insert into board values(1, '제목1', '내용1', 'user1', 0, sysdate);
insert into board values(2, '제목2', '내용2', 'user1', 0, sysdate);

-- ────────────────────────────────────────────────────────────────────────
--Section08 CHECK 제약 조건
-- ────────────────────────────────────────────────────────────────────────
drop table member;
create table member(
mid varchar(10) primary key,
mname varchar(10) not null,
mage number(3) check(mage >=0 and mage <150), --보통 check를 지정할때는 null을 지정안한다 왜? check된값이 들어갈것임으로~
msex varchar(4) check(msex in ('남자', '여자') ), --in(목록중에 한값) 여기선 남자 여자중 한값만 들어감
memail char(50) unique null,
mbirth date null
);
insert into member values('user1', '사용자1', 25, '남자', 'user1@sw.com', sysdate);
insert into member values('user2', '사용자1', 200, '여자', 'user1@sw.com', sysdate); --check 제약조건에 위배됨
insert into member values('user3', '사용자1', null, null, 'user1@sw.com', sysdate); --check 제약조건에 위배됨
insert into member values('user4', '사용자1', 30, '중성', 'user1@sw.com', sysdate); --in 제약조건에 위배됨

-- ────────────────────────────────────────────────────────────────────────
--Section09 DEFAULT 제약조건
-- ────────────────────────────────────────────────────────────────────────
drop table board;
create table board (
  bno number(10) primary key,
  btitle varchar(100) not null,
  bcontent varchar(4000) not null,
  bwriter varchar(10) not null,
  bhitcount number(5) default 0, --값이 주어지지 않으면 0이 들어가라
  bkind varchar(15) default '자유', --값이 주어지지 않으면 '자유'가 들어가라
  bdate date null
);
insert into board values(1, '제목1', '내용1', 'user1', 0, '자유', sysdate);
insert into board values(2, '제목2', '내용2', 'user1', '자유', sysdate); --default값이 지정되도 컬럼항목의 숫자를 일치시켜야함으로 이건 에러
insert into board values(2, '제목2', '내용2', 'user1', default, '자유', sysdate); --근데 이렇게 default를 넣으면 자동으로 default값이 들어감
insert into board(BNO, BTITLE, BCONTENT, BWRITER)
values(3, '제목3', '내용3', 'user3'); --이렇게하면 자동으로 default가 들어가고 bdate는 null이 들어가겠지~

--Section05 컬럼 레벨로 제약 조건 설정(Section05, 10, 11는 함께 보면 좋음)
drop table board;
drop table member;
create table member(
  mid varchar(10) primary key, --이건 컬럼 레벨로 제약조건 을 설정한거고
  mage varchar(10) not null
);
create table member(
  mid varchar(10) constraint pk_member_mid primary key, --이건 컬럼 레벨로 제약조건 을 설정한거고(위에꺼랑 동일한데 프라이머리 키이름을 따로 지정)
  mage varchar(10) constraint ch_member_mage check(mage >=0 and mage <150)
  --바로 위꺼는 앞에서 나왔듯이 오라클에서 제약조건이름을 sys로 지정하는데 위처럼 해서 제약조건이름을 ch_member_mage이런 식으로 내가 지정함
  --이름지정규칙 : 회사마다 다르지만 보통  제약제조건_테이블이름_컬럼이름 이런식으로 이름을 정함
);
create table board(
  bno number(10) constraint pk_board_bno primary key,
  bwriter varchar(10) constraint fk_board_bwriter references member(mid) --foreign key라는 키워드가 필요없음(바로 컬럼에 적용되니깐) 하지만 테이블단위로 제약조건을 지정할때는 이 키워드를 써야함
);

-- ────────────────────────────────────────────────────────────────────────
--Section10 테이블 레벨로 제약 조건 설정(Section05, 10, 11는 함께 보면 좋음)
-- ────────────────────────────────────────────────────────────────────────
create table member(
  mid varchar(10) not null,
  mage varchar(10) not null,
  constraint pk_member_mid primary key (mid) --pk_member_mid(이건 제약조건의이름임)
);
create table member(
  ssn1 varchar(6), ---pk가 지정되니 그냥 not null 처리가된다고 보면됨
  ssn2 varchar(7), ---pk가 지정되니 그냥 not null 처리가된다고 보면됨
  mage varchar(10) not null,
  constraint pk_member_ssn primary key (ssn1, ssn2), -- 복합키 : 이걸통해서 이렇게 두개의 컬럼을 조합해서 하나의 PK로 지정함
  constraint ch_member_mage check(mage >=0 and mage <150) --이건 이렇게 따로 지정가능!
);
create table board(
  bno number(10), 
  bwriter varchar(10), 
  constraint pk_board_bno primary key(bno),
  constraint fk_board_bwriter foreign key(bwriter) references member(mid) --foreign key를 넣어서 어떤 컬럼과 연결시킬건지 지정해줘야함
);

-- ────────────────────────────────────────────────────────────────────────
--Section11 제약조건 변경하기(Section05, 10, 11는 함께 보면 좋음)
-- ────────────────────────────────────────────────────────────────────────
--11.1 제약 조건 추가하기
drop table member;
--1). 이 테이블에서 기본적인 제약조건만 넣고 다른곳에서 제약조건을 넣는다
create table member(
  ssn1 varchar(6) not null,
  ssn2 varchar(7) not null,
  mage varchar(10) not null
); 
--2). 이렇게 테이블 생성후 제약조건을 따로 지정가능
alter table member 
add constraint pk_member_ssn primary key (ssn1, ssn2);
alter table member 
add constraint ch_member_mage check(mage >=0 and mage <150);

--@이건 board
create table board(
  bno number(10), 
  bwriter varchar(10)
);
alter table board
add constraint pk_board_bno primary key(bno);
alter table board
add constraint fk_board_bwriter foreign key(bwriter) references member(mid);

--★(Section05, 10, 11까지 내용정리) 제약조건을 추가하는 방법 3가지
--1. 컬럼을 선언한 할 때 제약조건을 주는 방법
--2. 테이블단위로 컬럼을 다 정의해놓고 마지막에 제약조건을 지정해주는 방법
--3. 테이블을 다 생성하고 나서 이후에 수정을 하면서 제약조건을 추가하는 방법

--11.3 제약 제거 하기
drop table board;
drop table member;
create table member(
  ssn1 varchar(6),
  ssn2 varchar(7),
  mage varchar(10) not null,
  constraint pk_member_ssn primary key (ssn1, ssn2),
  constraint ch_member_mage check(mage >=0 and mage <150)
);
alter table member drop primary key; --이렇게 제약조건 없앰!
alter table member drop constraint ch_member_mage; --이렇게 제약조건 없앰!

-- ────────────────────────────────────────────────────────────────────────
--Section12 제약조건의 비활성화와 CASCADE
-- ────────────────────────────────────────────────────────────────────────
drop table board;
drop table member;
create table member(
  mid varchar(10) constraint pk_member_mid primary key,
  mage varchar(10) constraint ch_member_mage check(mage >=0 and mage <150)
);
create table board(
  bno number(10) constraint pk_board_bno primary key,
  bwriter varchar(10) constraint fk_board_bwriter references member(mid)
);
--외부의 데이터(수십만건 수백만건)을 가지고 와야할경우
--제약조건이 들어가있으면 insert성능이 나빠짐. 그래서 제약조건을 제거하지 않으면서 기능만 잠시 꺼두는게 필요함!

--12.1 제약 조건의 활성화
alter table board disable primary key;
--12.2 제약 조건의 비활성화
alter table board enable primary key;
--12.3 CASCADE
alter table member disable primary key; --이건 member의 mid에 연결된 다른 테이블의 fk때문에 비활성처리가안됨
alter table member disable primary key cascade; --그래서 cascade(=계단식으로 영향을 미침)를 써서 이걸 바꿈으로서 이 member의 mid를 참조하는 다른 모든 테이블들의 fk들까지도 비활성화 시킴
alter table member enable primary key; --이렇게하면 이 member의 pk는 활성화 되지만, 이 member의 mid를 참조하던 다른 테이블들의 fk는 활성화가 안됨
alter table board enable constraint fk_board_bwriter; --그래서 이렇게 일일이 ㅠㅠ.. 각각의 테이블들의 fk를 활성화시켜야함

--12.4 (책에없는부분)ON DELETE CASADE
insert into member values('user1', 25);
insert into board values(1, 'user1');
insert into board values(2, 'user1');
delete from member where mid='user1'; -- 외부테이블에서 fk로 참조하고있어서 삭제안됨(애러남) 그래서~
delete from board where bwriter='user1'; -- 이렇게 지우고
delete from member where mid='user1'; -- 이렇게 지워야함(이렇게하는건 데이터가 몇개없을때나 쓰는거지 안좋은방법이지)
--그래서 user1을 지우면 자동적으로 참조하고 있는 다른테이블들의 값들도 다 지우도록 해보자
drop table board;
drop table member;
create table member(
  mid varchar(10) constraint pk_member_mid primary key,
  mage varchar(10) constraint ch_member_mage check(mage >=0 and mage <150)
);
create table board(
  bno number(10) constraint pk_board_bno primary key,
  bwriter varchar(10) constraint fk_board_bwriter references member(mid) on delete cascade --이렇게 on delete cascade를 지정하면 참조하고있는 member의 mid가 삭제가 될때 자동적으로 이 테이블에서 참조하고 있는 행은 다 지워버려!
);
insert into member values('user1', 25);
insert into board values(1, 'user1');
insert into board values(2, 'user1');
delete from member where mid='user1';  -- 위에 board테이블의 bwriter에서 on delete cascade를 지정하고 이걸 수행하니 board테이블에 있는 데이터까지도 지워짐!




