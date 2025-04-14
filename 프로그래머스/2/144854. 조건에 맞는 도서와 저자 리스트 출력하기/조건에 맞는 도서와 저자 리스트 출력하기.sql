-- 코드를 입력하세요
SELECT b.BOOK_ID, a.AUTHOR_NAME, DATE_FORMAT(b.PUBLISHED_DATE, '%Y-%m-%d')
From BOOK b join AUTHOR a on b.AUTHOR_ID = a.AUTHOR_ID
Where b.CATEGORY = '경제'
Order by PUBLISHED_DATE