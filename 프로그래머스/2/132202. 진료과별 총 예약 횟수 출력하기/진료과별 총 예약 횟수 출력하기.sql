-- 코드를 입력하세요
SELECT MCDP_CD, count(*)
from APPOINTMENT
where DATE_FORMAT(APNT_YMD, '%m')='05'
group by MCDP_CD
order by count(*), MCDP_CD