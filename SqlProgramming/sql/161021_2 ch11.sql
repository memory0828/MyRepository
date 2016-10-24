--tester1에서 실행함
--Section01 서브쿼리의 기본 개념
--이문세 사원의 부서 이름은?
select dname
from dept
where deptno=(select deptno from emp where ename='이문세'); --()안의 내용은 서브쿼리 : 이 서브쿼리를 실행한 결과가 조건이 됨
--위를 Join문으로 바꿔보자( 서브쿼리는 언제든 join문으로 바꿀수있고 join문도 언제든 서브쿼리로 바꿀수있다!)
select dname
from emp, dept
where emp.deptno = dept.deptno
         and ename='이문세';
--특별한 경우가 아니면 첫번째 서브쿼리 방식으로 하는게 속도는 더 빠르다? 왜? join은 같은 값끼리 연결시키는게 시간이 오래걸림!
--근데 서브쿼리는 그냥 테이블을 연결시키는게 아니라 값만 받아서 그 값으로 또다른 결과값을 나타내는거임
--반면 join은 테이블을 연결시키는것이기 때문에 행이 많을수록 시간 소요가 많아짐

--1.1 단일행 서브 쿼리
--이문세 사원의 부서명은?
select dname
from dept
where deptno=(select deptno from emp where ename='이문세');
--최저 봉급을 받아가는 사원의 정보는?
select *
from emp
where sal=(select min(sal) from emp);
--평균 봉급 이상을 받아가는 사원의 수는?
select count(*)
from emp
where sal>=(select avg(sal) from emp);

--Section02 다중행 서브쿼리
--서울에 근무하는 사원의 이름은?
select ename
from emp
where deptno in (select deptno from dept where loc='서울');
--★★★시험문제★★★In을 생각잘해야함! 서브쿼리에서는 결과값이 3개가 나오는데 서브쿼리가 다중값이 될경우에는 in이라는 연산자로 해결해야한다.

--2.4 Exitsts 연산자
--＠사원이 1명이라도 존재하는 부서의 이름은?
select d.DNAME
from dept  d, emp e
where d.DEPTNO=e.DEPTNO
group by d.DNAME;
--위를 책에 나온 표현으로 exists 써서~~ 아래~
select dname
from dept
where exists (select * from emp where emp.deptno=dept.deptno);
-- 서브쿼리의 조건에서 바로 주쿼리의 테이블을 쓸 수 있는데
-- 주쿼리의 행의 값을 하나씩 받아서 ()안의 서브쿼리를 각각 한번씩 실행(즉 주쿼리의값이 10개가 있다면, 서브쿼리도 10개 실행)

--＠사원이 존재하지않는 부서의 이름은?
--방법1
select d.DNAME
from dept d left outer join emp e
on d.DEPTNO=e.DEPTNO
where e.DEPTNO is null;
--방법2
select dname
from dept
where not dname in (
 select distinct dname
 from emp e, dept d
 where d.deptno=e.deptno);
--위를 책에 나온 표현으로 exists 써서~~ 아래~
select dname
from dept
where not exists (select * from emp where emp.deptno=dept.deptno);

--Section03 서브쿼리를 이용하여 테이블을 생성하고 데이터를 조작하기
--emp 테이블 복제해서 emp2로 만드세요?(하나의 DDL로 작성하시오)
create table emp2
as
select * from emp;
--위 방법은 제약조건(pk, fk, check제약, not null)은 복제가 되지 않습니다 : 테이블의 컬럼과 값은 복사가 되는데 제약조건들이 복사가 안됨
--위 방법은 인덱스도 복제가 되지 않습니다
--그래서 복제하고 나서 제약조건이랑 인덱스는 별도로 만들어야합니다.

--emp 테이블의 구조만 복재해서 emp3로 만드세요?
--제약 조건과 인덱스는 복재하지 않아도 됨
create table emp3
as
select * from emp where 1=0;

--3.3 서브쿼리로 데이터를 삽입하기
--emp3을 만들었다면 10번 부서의 사원들만 복사하세요
insert into emp3
select * from emp where deptno=10;

--3.4 서브쿼리를 이용한 데이터 변경
--20번 부서의 위치를 40번 부서의 위치로 변경하세요
update dept
set loc=(select loc from dept where deptno=40)
where deptno=20;
--3.5 서브쿼리를 이용한 데이터 삭제
--영업부서의 사원을 삭제하세요
delete emp where deptno=(select deptno from dept where dname='영업부');


