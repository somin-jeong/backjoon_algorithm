-- 코드를 입력하세요
SELECT b.CATEGORY, SUM(bs.SALES) AS TOTAL_SALES
from BOOK b join BOOK_SALES bs on b.BOOK_ID = bs.BOOK_ID
where YEAR(bs.SALES_DATE) = 2022 and MONTH(bs.SALES_DATE) = 1
group by b.CATEGORY
order by b.CATEGORY