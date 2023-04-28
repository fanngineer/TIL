-- 코드를 입력하세요
SELECT BOOK_ID,	AUTHOR_NAME, date_format(published_date,'%Y-%m-%d') PUBLISHED_DATE from book b join author a on b.author_id = a.author_id where category = '경제' order by PUBLISHED_DATE