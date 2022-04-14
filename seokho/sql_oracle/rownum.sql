select rownum, empno, ename, job, sal
from emp
where rownum <= 5;
/
select empno, ename, job, sal
from emp
order by sal desc fetch first 4 rows only;
/
select empno, ename, job, sal
from emp
order by sal desc
fetch first 20 percent rows only;
/
-- with ties는 값이 동일하다면 갯수 제한 없이 같이 출력한다.
select empno, ename, job, sal
from emp
order by sal desc
fetch first 2 rows with ties;

--offset옵션을 이용하면 출력이 시작되는 행의 위치를 지정할 수 있다. (9입력시 10부터 출력)
select empno, ename, job, sal
from emp
order by sal desc
offset 9 rows;
--offset과 fetch 조합
select empno, ename, job, sal
from emp
order by sal desc
offset 9 rows fetch first 2 rows only;