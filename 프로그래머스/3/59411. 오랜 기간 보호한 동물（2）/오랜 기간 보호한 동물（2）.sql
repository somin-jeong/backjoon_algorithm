-- 코드를 입력하세요
SELECT ai.ANIMAL_ID, ai.NAME
from ANIMAL_INS ai join ANIMAL_OUTS ao on ai.ANIMAL_ID = ao.ANIMAL_ID
order by ai.DATETIME - ao.DATETIME
limit 2
