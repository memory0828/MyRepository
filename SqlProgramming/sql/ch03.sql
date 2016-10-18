--Section01 DUAL 테이블
select * from dual;
select 10+20 from dual; --dual이라는 가상의 테이블로 계산값 이용
select sysdate from dual; --오라클 dbms의 날짜
--Section02 숫자 함수
--2.1 절대값을 구하는 ABS 함수
SELECT ABS(-15) "Absolute"  FROM DUAL;
update emp set sal=sal/7;
select * from emp;
rollback;
--------------------------------------------
--소수 첫째자리까지 나타내기(반올림)
select sal, round(sal) from emp;
select sal, round(sal,1) from emp;
--바로 아래 정수(소수를 정수로 만드는 방법)
select sal, floor(sal) from emp;
--바로 위 정수
select sal, ceil(sal) from emp;
--소수 첫째자리까지 나타내기(짤라내기)
select sal, trunc(sal) from emp;
select sal, trunc(sal,1) from emp;

--Section03 문자 처리 함수 -- localhost_orcl_hr로 테스트
--3.1 대소문자 변환함수
select phone_number from employees where lower(first_name)='steven';
--3.2 생략
--3.3 문자 조작 함수
--3.3.1 문자열 일부만 추출하는 SUBSTR 함수
select * from employees;
select substr(first_name, 1,5) from employees;
--3.3.5 특정 기호로 채우는 LPAD/RPAD 함수
select lpad('oracle', 20, '*') from dual;
select rpad('oracle', 20, '*') from dual;
--★★★시험문제★★★10자리 공간에 사원 이름(first_name)을 5자리까지만 나오게 하고 나머지는 오른쪽(*) 처리를 하시오
select rpad(substr(first_name, 1,5), 10, '*') from employees;

--Section04 형 변환 함수 -- localhost_orcl_hr로 테스트
--4.1.1 날짜형을 문자형으로 변환하기
select hire_date, to_char(hire_date, 'YYYY.MM.DD DAY') from employees;
--4.1.1 문자형을 날짜형으로 변환하기
select first_name, hire_date from employees where hire_date='2003.06.17';
select first_name, hire_date from employees where hire_date='2003-06-17';
select first_name, hire_date from employees where hire_date='2003/06/17';
select first_name, hire_date from employees where hire_date='20030617';
select first_name, hire_date from employees where hire_date='030617';
select first_name, hire_date from employees where hire_date=to_date('2003.06.17'); --위방식들보다 이방식을  써야함
select first_name, hire_date from employees where hire_date=to_date('06-17-2003', 'MM-DD-YYYY');

--Section05 날짜함수 -- localhost_orcl_hr로 테스트
--5.1 DBMS의 현재 날짜
select sysdate from dual;
--★★★시험문제★★★DBMS의 현재 날짜를 '2016.10.17 월요일'로 변환해 보세요
select to_char(sysdate, 'YYYY.MM.DD DAY') from dual ;

--Section06 NULL을 다른 값으로 변환하는 NVL함수 -- localhost_orcl_hr로 테스트
select salary*12 + nvl(commission_pct,0)*salary from employees;
select nvl2(
        commission_pct, --애가 
        salary*12+commission_pct*salary, --null이 아니면 이값이 리턴값
        salary*12 --null이면 이값이 리턴
        ) from employees;



