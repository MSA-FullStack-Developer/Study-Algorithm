--SUM,MIN,MAX사용하기

--최댓값 구하기
--원래 생각 ROWNUM을 사용해 orderby로 정렬후 첫번째 행 출력
--SELECT datetime from (select datetime from ANIMAL_INS order by datetime desc)
--where rownum = 1
--그 이후 MAX를 사용하여 해결
SELECT MAX(DATETIME) as datetime from ANIMAL_INS

--최솟값 구하기
-- 코드를 입력하세요
SELECT MIN(DATETIME) as datetime from ANIMAL_INS

--동물 수 구하기
-- 코드를 입력하세요
SELECT count(*) as cnt from ANIMAL_INS 

--중복 제거하기
--중복을 제거하고 그 컬럼의 COUNT가 필요하다면 COUNT안에 DISTINCT하기
-- 코드를 입력하세요
SELECT count(DISTINCT NAME) as cnt
FROM ANIMAL_INS
WHERE NAME IS NOT NULL
