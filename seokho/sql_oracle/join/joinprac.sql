--OUTER JOIN
--QEUI JOIN시 출력되지 않는 정보도 볼 수 있다.
--EQUI JOIN은 양쪽에 다 존재하는 데이터만 출력된다.
--RIGHT OUTER JOIN은 오른쪽에 존재하는 데이터를 모두 출력한다. (+) 기호는 부족한 쪽에
SELECT E.ename, D.loc
FROM emp E, dept D
WHERE E.deptno(+) = D.deptno;

--SELF JOIN
SELECT e.ename as 사원, e.job as 직업, m.ename as 관리자, m.job as 직업
FROM emp e, emp m
WHERE e.mgr = m.empno and e.job = 'SALESMAN';
/
--ON절 조인
SELECT e.ename as 이름, e.job as 직업, e.sal as 월급, d.loc as 부서위치
FROM emp e JOIN dept d
ON e.deptno = d.deptno
where e.job = 'SALESMAN';


