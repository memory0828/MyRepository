-- ────────────────────────────────────────────────────────────────────────
-- 1장
-- ────────────────────────────────────────────────────────────────────────
-- 1.1 문장과 절
select * from emp;
-- 1.2 특정 데이터만 보기
select empno, ename from emp;
-- 1.3 산술 연산자(Result Set)
select ename, sal, sal*12 from emp; -- sal*12는 결과셋에만 생성되는 내용일뿐 실제 DB에는 있는 내용이 아니다 이것을 결과셋(=Result Set) 라고 한다
-- 1.4 null도 데이터다( -> null 연산시 주의할점 ) p65
--    오라클에서 null은 데이터가 없다라는 표현이기 때문에 데이터가 없을 표현하는 키워드이다. null이 데이터다라고 하면 혼남! 책에서 표현한건 좀 이상함
select ename, sal, comm, sal*12+comm from emp; --null의 값을 넣고 연산하면 전체의 값은 null이 나옴
select ename, sal, comm, sal*12+nvl(comm,0) from emp; -- 함수호출 nvl(comm,0)로 첫번째 인수값이 널이라면 0으로 바꿔서 계산한다
--    함수와 메소드의 차이점 : 함수는 실행 블록일 뿐. 메소드는 객체내부에서의 실행블록(객체가가진 기능=객체라는 개념이 들어감)
-- 1.5 컬럼 이름에 별칭 지정하기 p67
select ename as 이름, sal as 월급, comm 보너스, sal*12+nvl(comm,0) 연봉 from emp;
--    ename as 이름(같음-> ename 이름) 이렇게 하면 결과화면에 컬럼이름이 바꿔 컬럼의 별칭 지정하기
--    (as는 있어도 되고 없어도 되는 옵션)
--    ■오라클에서는 데이터를 제외한 컬럼명들을 대소문자를 가리지 않는다~
-- 1.6 Concatenation 연산자(문자열 결합) p69
select empno, ename from emp;
select (empno || '-' || ename) as 이름 from emp;
---   문자, 문자열 모두 ' '로 표시한다
---   문자열과 문자열을 결합할때는 || 를 쓴다
select ename || '의 직급은' || job || '입니다.' as 직급 from emp;
-- 1.7 DISTINCT 키워드 (중복 제거)
--    사원이 있는 부서 번호는?
select distinct deptno from emp;

-- ────────────────────────────────────────────────────────────────────────
-- 2장
-- ────────────────────────────────────────────────────────────────────────
-- 조건절 작성
select ename from emp where deptno=20;
-- 2.1 비교 연산자
select ename from emp where deptno!=20;
select ename from emp where deptno<>20;
select ename from emp where sal>=500;
-- 2.1.1 문자 데이터 조회
select ename from emp where ename='이문세';
-- 2.1.2 날짜 데이터 조회
-- 2005년 1월 1일 이전에 입사한 사원의 정보
select * from emp where hiredate < '05/01/01';
select * from emp where hiredate < '2005.01.01';
select * from emp where hiredate < '2005-01-01';
select * from emp where hiredate < to_date('2005-01-01', 'YYYY/MM/DD'); --옛날 방식 문자를 날짜로 바꿔주는 to_date함수를 사용했음
-- 2.2 논리 연산자
-- 2.2.1 AND 연산자
-- 10번 부서에 소속된 사원중에서 직급이 과장인 사원의 정보
select * from emp where deptno=10 and job='과장';
-- 월급이 400이상 500이하인 사원의 정보
select * from emp where 400<=sal and sal<=500;
-- 2.2.2 OR 연산자
-- 10번 부서에 소속된 사원 또는 직급이 과장인 사원의 정보
select * from emp where deptno=10 or job='과장';
-- 2.2.3 NOT 연산자
-- 10번 부서가 아닌 사원의 정보
select * from emp where deptno!=10;
select * from emp where deptno<>10;
select * from emp where not deptno=10;
-- 2.3 BETWEEN AND 연산자
-- 월급이 400이상 500이하인 사원의 정보
select * from emp where 400<=sal and sal<=500;
select * from emp where sal between 400 and 500; --위랑 똑같은 방법( 위는 연산자2개사용 여기선 1개사용)
select * from emp where ename between '바' and '자';
-- 2.4 IN 연산자
-- 보너스가 80이거나 100이거나 200인 사원의 정보
select * from emp where comm=80 or comm=100 or comm=200;
select * from emp where comm in (80, 100, 200); --숫자 문자도 모두 사용가능함. 안에 들어가는 개수의 제한없음
-- 2.5 LIKE 연산자와 와일드 카드
-- 2.5.1 와일드카드(%) 사용하기
-- 성이 이씨인 사원의 정보
select * from emp where ename between '이' and '익';
select * from emp where ename like '이%';
-- 이름 중에 '성'이 포함된 사원의 정보
select * from emp where ename like '%성%';
-- 2.5.1 와일드카드(_) 사용하기
-- 이름 중에 두번째 글자가 '성'인 사원의 정보
select * from emp where ename like '_성%';
-- 이름 중에 '성'이 포함되지 않는 사원의 정보
select * from emp where not ename like '%성%'; --보통 이렇게 조건전체를 부정하는 느낌으로 사용됨
select * from emp where ename not like '%성%'; --이렇게도 쓸수있지만...
-- 2.6 NULL을 위한 연산자
-- 보너스가 없는(null)인 사원의 정보
select * from emp where comm=null; --이렇게 쓰면 안먹힘(안됨!)
select * from emp where comm is null; --이렇게 써야함
select * from emp where comm is not null;








