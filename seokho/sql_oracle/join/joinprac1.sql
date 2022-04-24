select e.ename 이름, e.job 직업, e.sal 월급, d.loc 부서위치
from emp e JOIN dept d
on e.deptno = d.deptno
where e.job= 'SALESMAN';

--ANSI 조인 9i버전 부터 지원
SELECT e.ename, d.loc
from emp e JOIN dept d
on e.deptno = d.deptno;
-- 여러 테이블 조인 ANSI
SELECT e.ename, d.loc, s.grade
FROM emp e 
JOIN dept d ON e.deptno = d.deptno
JOIN salgrade s ON e.sal between s.losal and s.hisal;

--여러 테이블의 데이터를 조인(USING)
--WHERE절 대신 USING절을 사용해서 조인
-- USING절은 반드시 괄호 사용해야함!
SELECT e.ename, e.job, e.sal, d.loc
FROM emp e JOIN dept d
USING (deptno)
WHERE e.job = 'SALESMAN';
--여러 테이블 조인 (USING)
SELECT e.ename, d.loc, s.grade
FROM emp e
JOIN dept d USING (deptno)
JOIN salgrade s ON e.sal between s.losal and s.hisal;
    
-- 조인 조건을 주지 않는 NATURAL JOIN
-- 두테이블에 존재하는 동일 컬럼에 대해 암시적으로 조인을 진행한다.
-- 조건절에 기술 할 때 연결고리가 되는 컬럼은 별칭을 주면 안된다. 
SELECT e.ename, e.job, e.sal, d.loc
FROM emp e natural join dept d
where e.job = 'SALESMAN';

-- RIGHT OUTER JOIN 오른쪽 데이터 전부(ANSI)
SELECT e.ename, e.job, e.sal, d.loc
FROM emp e RIGHT OUTER JOIN dept d
ON e.deptno = d.deptno;
-- RIGHT OUTER JOIN (오라클)
SELECT e.ename, d.loc
FROM emp e, dept d
WHERE e.deptno (+) = d.deptno;

--RIGHT OUTER JOIN (USING)
SELECT e.ename, d.loc
FROM emp e RIGHT OUTER JOIN dept d
USING (deptno);

--FULL OUTER JOIN (ANSI)
SELECT e.ename, e.job, e.sal, d.loc
FROM emp e FULL OUTER JOIN dept d
ON (e.deptno = d.deptno);

--FULL OUTER JOIN (오라클로 불가능)
SELECT e.ename, d.loc
FROM emp e, dept d
WHERE e.deptno (+) = d.deptno (+);

--FULL OUTER JOIN (UNION)
SELECT e.ename, e.job, e.sal, d.loc
FROM emp e LEFT OUTER JOIN dept d
ON (e.deptno = d.deptno)
UNION
SELECT e.ename, e.job, e.sal, d.loc
FROM emp e RIGHT OUTER JOIN dept d
ON (e.deptno = d.deptno);

--UNION ALL 여러 쿼리결과를 위아래로 하나로 출력하는 방법
-- TO_NUMBER: deptno가 숫자 타입이기 때문에 동일하게 맞춤
-- 집합 연산자 작성시 주의사항
-- UNION ALL 위쪽 쿼리와 아래쪽 퀴리의 컬럼수, 데이터타입이 동일해야함.
-- 결과로 출력되는 컬럼명은 위쪽 쿼리의 컬럼명으로 출력됩니다.
-- ORDER BY절은 제일 아래만 가능
SELECT deptno, sum(sal)
FROM emp
GROUP BY deptno
UNION ALL
SELECT TO_NUMBER(null) , sum(sal)
FROM emp;

