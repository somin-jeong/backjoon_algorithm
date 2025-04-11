-- 코드를 입력하세요
SELECT ai.ANIMAL_ID, ai.ANIMAL_TYPE, ai.NAME
from ANIMAL_OUTS ao join ANIMAL_INS ai on ao.ANIMAL_ID = ai.ANIMAL_ID
where (ao.SEX_UPON_OUTCOME like "Spayed%" or ao.SEX_UPON_OUTCOME like "Neutered%")
and ai.SEX_UPON_INTAKE like "Intact%"
order by ai.ANIMAL_ID
