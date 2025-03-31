-- 코드를 입력하세요
SELECT CATEGORY, count(PRODUCT_ID) as PRODUCTS
from (select PRODUCT_ID, substr(PRODUCT_CODE, 1, 2) as CATEGORY from PRODUCT) as a
group by CATEGORY
order by CATEGORY