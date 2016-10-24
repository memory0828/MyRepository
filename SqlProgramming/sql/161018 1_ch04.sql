--Section01 그룹함수
--사원들의 전체 봉급의 합 - 집계합수(Aggregate Functions)
select sum(sal) from emp;
--월급을 가장 많이 받아가는 사원의 정보
select * from emp where sal=max(sal); --select쿼리 뒤에는 올수있지만 where에는 이것처럼 올수없다
select * from emp where sal=
                                       (select max(sal) from emp); --메인쿼리안에 또다른 쿼리가 좋제하는거 = 서브쿼리
--평균 월급 보다 많이 받아가는 사원의 정보
select * from emp where sal > (select avg(sal) from emp);
--전체 사원의 수 = 전체 행수
select count(*) from emp; --전체 행수 카운터 구함( *를 줄때랑 컬럼을 줄떄랑 해석이 달라진다)
select count(empno) from emp; --empno의 개수를 카운터 구함
select count(comm) from emp; --comm의 개수 카운터 구함( null 제외시킴)
--평균 월급 보다 많이 받아가는 사원의 수
select count(*) from emp where sal > (select avg(sal) from emp); --이 서브쿼리조건을 만족하는 행의 수 구해짐

--1.1 그룹 함수와 NULL 값
--그룹 함수와 단순 컬럼
select avg(comm) as from emp;  --avg도 결국 null값을 빼고 계산하게됨
select sum(comm) / count(*) from emp; --왜 이 두값은 차이가 나는가?
select sum(comm) / count(comm) from emp; --이렇게해야 위 꺼랑 차이가 없음
--사원의 직위 개수는?
select count(distinct job) from emp;

--Section02 데이터 그룹 : GROUP BY 절
--부서별로 평균 봉급은?
select deptno, sal from emp order by deptno; -- deptno그룹당 하나의 값이 묶어서 나오도록 만듬
--★★★시험문제★★★
--이건 공식처럼 쓰임!
--select [그룹핑컬럼]+집계함수 from emp group by [그룹핑컬럼] : 이렇듯 group by 뒤에있는 이 그룹핑컬럼 내용은 반드시 select 뒤에 나와야하고 거기에 집계함수도 나와야함
select deptno, avg(sal) from emp group by deptno;
select deptno, avg(sal) from emp group by deptno order by deptno; --order by 추가해봄
select deptno, round(avg(sal),1) from emp group by deptno order by deptno; --order by 추가+round추가해봄
--직급별 평균 봉급은?
select job, avg(sal) from emp group by job;
--부서별(1차그룹핑) 직급별(2차그룹핑) 평균 봉급은?
select deptno, job, avg(sal) from emp group by deptno, job order by deptno; --다시말하지만 group by뒤에있는 컬럼이 반드시 select 뒤에 나와야한다!

--Section03 그룹 결과 제한 : HAVING 절
--부서의 평균 봉급이 500 이상인 부서 번호와 평균 봉급은?
select deptno, avg(sal) from emp group by deptno having avg(sal)>500;
--where 뒤에는 그루핑 전의 조건이 나오고 | 그루핑 후의 조건은 having 에 뒤에 나온다
--★★★시험문제★★★
--사원중에서 부서별 평균 봉급이 300이상인 부서와 사원의 평균 봉급은?
select deptno, avg(sal) from emp where job='사원' group by deptno having avg(sal) >= 300;
--사원중에서 부서별 평균 봉급이 300이상인 부서와 사원의 평균 봉급 및 수는?
select deptno, avg(sal), count(*) from emp
where job='사원' group by deptno having avg(sal) >= 300;
--급여 총액 1000 이상인 직급에 대해서 직급과 급여 총액을 표시하되
--직급이 사원인 사람은 제외시킨 후 급여 총액에 따라 정렬하시오
select job, sum(sal) as salary from emp
where job<>'사원' group by job having sum(sal)>=1000
order by salary; --이건 순서가 정해져있음 order by 는 항상 마지막 결과가 나오고 나서의 정렬이다





