-------------------------
--행 순번 붙이기
-------------------------
select rownum, bno, btitle from board order by bno; --rownum을 잘못쓴 예 : 정렬되기 전에 데이터가 나와서 뒤죽박죽( 즉 rownum의 순서는 order by 전이다(
-- 그래서 서브쿼리를 이용한다
select rownum, bno, btitle
from (select bno, btitle from board order by bno desc); --이렇게 서브쿼리로 정렬된 테이블을 얻고 그것의 rownum을 얻는다!(즉 이미 정렬된 상테에서 rownum을 적용시킴)

-------------------------
--최근 삽입된 행 5개를 가져와라
-------------------------
select rownum, bno, btitle
from (select bno, btitle from board order by bno desc)
where rownum<=5; -- rownumd은 <=x <x 처럼 작은건 가능한데 >x, >=x이렇게는 사용안됨. rownum이 1부터시작하니깐..

-------------------------
--행의 순번이 11~20번까지를 가져와라
-------------------------
select rownum, bno, btitle
from (select bno, btitle from board order by bno desc)
where rownum>5; -- rownumd은 <=x <x 처럼 작은건 가능한데 >x, >=x이렇게는 사용안됨. rownum이 1부터시작하니깐..
--즉 rownum은 번호를 매길때마다 조건을 검사하는데 이 조건(where에 나오는 조건들)이 false가 될때까지만 rownum이 동작됨! 그래서 위는 처음시작하자마자 false이니깐 안되는거임
--그런데 일부분만 가져다 써야한다면?
select rn, bno, btitle --select rownum, bno, btitle 이렇게하면 또 순번을 매기니 안되고 아래에서 rownum as rn(로 별칭=엘리아스)를 주고 그걸 여기서 사용하면 ! 해결!
from (
  select rownum as rn, bno, btitle
  from (select bno, btitle from board order by bno desc)
  where rownum<=20 --마지막행의 순번
)
where rn>=11; --시작행의 순번

-------------------------
-- 1페이지에 10개씩 구성하고, n번째 페이지를 가져와라
-------------------------
select rn, bno, btitle --select rownum, bno, btitle 이렇게하면 또 순번을 매기니 안되고 아래에서 rownum as rn(로 별칭=엘리아스)를 주고 그걸 여기서 사용하면 ! 해결!
from (
  select rownum as rn, bno, btitle
  from (select bno, btitle from board order by bno desc)
  where rownum<=(2*10) --마지막행의 순번  (2*10) 에서 2는 페이지 번호(즉 2페이꺼를 가져와라)
)
where rn>=( (2-1)*10+1 );  --시작행의 순번 ( (2-1)*10+1 )에서 (2-1)의 2는 페이지 번호(즉 2페이꺼를 가져와라)





