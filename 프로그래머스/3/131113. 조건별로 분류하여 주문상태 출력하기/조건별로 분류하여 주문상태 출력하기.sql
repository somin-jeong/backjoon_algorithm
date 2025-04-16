-- 코드를 입력하세요
SELECT ORDER_ID, PRODUCT_ID, date_format(OUT_DATE, "%Y-%m-%d"),
case when OUT_DATE <= date_format("2022-05-01", "%Y-%m-%d") then "출고완료"
when OUT_DATE is null then "출고미정"
else "출고대기" end "출고여부"
from FOOD_ORDER
order by ORDER_ID