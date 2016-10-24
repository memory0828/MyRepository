--Section03 Equi Join( = Inner Join) - hr테이블에서 테스트함
-- 조인 대상이 되는 두 테이블에서 공통으로 존재하는 컬럼의 값이 일치하는 행을 연결하여 결과를 생성하는 조인 방법
-- ( = 각각의 테이블에 동일한 데이터를 가진 컬럼을 연결시키면 각각 테이블이지만 행이 이어지는 결과가 나옴)

--101번 사원의 부서 이름은?
select department_name
from departments d, employees e --테이블을 두개쓰겠다는 의미고
where employee_id=101 and d.department_id=e.department_id; -- and 뒤에 있는건 앞 두 테이블의 연결조건
--위처럼 사용할수도 있지만 아래 방식이 더 통용(표준)된 방식임
--5.2절에서 소개된 ANSI Innser Join 문법
select department_name
from departments d
inner join employees e--테이블을 두개쓰겠다는 의미고
on d.department_id=e.department_id
where employee_id=101; -- and 뒤에 있는건 앞 두 테이블의 연결조건
--위가 표준 Inner Join SQL문
--------------------------------------------------------------------------------------
--sales 부서가 있는 도시는?
select department_name, city
from departments d, locations l
where d.location_id=l.location_id
          and department_name='Sales';
--위를 ANSI Inner Join 문법으로
select department_name, city
from departments d
inner join locations l
on d.location_id=l.location_id
where department_name='Sales';
--------------------------------------------------------------------------------------
--101번 사원의 부서 번호와 부서 이름은?
select d.department_id, d.department_name
from employees e, departments d --테이블 2개
where e.department_id=d.department_id  --연결조건 1개
          and employee_id =101;
--sql문을 설계할때 연결조건부터 넣는게 더 편리하다

--★★★시험문제볼때~~★★★
--★테이블의 개수-1개의 연결조건은 반드시필요함!
--★from 다음에 테이블이 2개 이상이 나오면 뒤에 연결조건에 테이블개수-1개가 있는지 봐야함 없으면 그건 틀림없이 실행이 안된다
--그래서 다음 문제가있는 sql문이라는 문제가 나오면 이 기준으로 먼저 살펴봐라!

--------------------------------------------------------------------------------------
--101번 사원의 근무 도시는?
select city
from employees e, departments d, locations l --테이블 3개
where e.department_id=d.department_id -연결조건1
        and d.location_id=l.location_id --연결조건2 -> 총 2개
        and employee_id =101;
--위를 ANSI Inner Join 문법으로
select city
from employees e
inner join  departments d on e.department_id=d.department_id
inner join  locations l on d.location_id=l.location_id
where employee_id =101;
--------------------------------------------------------------------------------------
--101번 사원의 사번, first_name, 부서번호, 부서이름, 나라, 도시는?
select e.employee_id, e.first_name, e.department_id, d.department_name, c.country_name, l.city
from employees e, departments d, locations l, countries c
where e.department_id=d.department_id
         and d.location_id=l.location_id
         and l.country_id=c.country_id
         and employee_id =101;
--위를 ANSI Inner Join 문법으로
select e.employee_id, e.first_name, e.department_id, d.department_name, c.country_name, l.city
from employees e
inner join departments d on e.department_id=d.department_id
inner join locations l on d.location_id=l.location_id
inner join countries c on l.country_id=c.country_id
where employee_id =101;

--Section04 Self Join(=Inner Join)
--101번 사원의 관리자 이름은?
select e2.first_name
from employees e1, employees e2
where e1.manager_id=e2.employee_id
and e1.employee_id=101;
--먼저 101번 찾아서 101번의 manager_id에 해당하는 e2.employee_id를 찾아서 그 first_name를 출력하라


--(책에없는 내용)5.3 ANSI Outer Join
create table member (
  mid varchar(10) primary key,
  mname varchar(10) not null
);

create table board (
  bno number(5)  primary key,
  btitle varchar(100) not null,
  bwriter varchar(10) not null references member(mid)
);
insert into member values('user1', '사용자1');
insert into member values('user2', '사용자2');
insert into member values('user3', '사용자3');
insert into member values('user4', '사용자4');
insert into member values('user5', '사용자5');
insert into board values(1, '제목1', 'user1');
insert into board values(2, '제목2', 'user2');
insert into board values(3, '제목3', 'user3');

-- 게시물을 한번도 작성하지 않은 맴버의 정보는? 
--LEFT Outer Join
select mid, mname, bno, btitle
from member left outer join board --left outer join 기준으로 왼쪽기준(member)에 있는건 다 나온다 / 오른쪽(board)에 있는건 왼쪽(member)에는 있는데 여기에 없는건 null로 나온다
on member.mid=board.bwriter;
--Right Outer Join
select bno, btitle, mid, mname
from board right outer join member --right outer join 기준으로 왼쪽(board)에 있는건 오른쪽(member)에는 있는데 여기에 없는건 null로 나온다 / 오른쪽(member)에 있는건 다 나온다
on board.bwriter=member.mid;
--Full Outer Join                                                  
select mid, mname, bno, btitle
from member full outer join board --양쪽 모두 출력~
on member.mid=board.bwriter;

--오라클에서만 사용하는 방식(시험에 안나옴 ㅋ)
select mid, mname, bno, btitle
from member, board
where member.mid=board.bwriter(+); --여기(member)에는 존재하는데 여기(board)에는 존재하지 않는놈은 행은하나 더 추가하데 null에 해당된다~ 뜻
                                                  --left join과 동일한효과
select bno, btitle, mid, mname
from board, member
where board.bwriter(+)=member.mid; --member에는 존재하나 여기(board)에는 존재하지 않는놈은 행은하나 더 추가하데 null에 해당된다 / 여기(member)에는 존재하는거 모두 출력~ 뜻
                                                  --right join과 동일한효과
