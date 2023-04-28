-- 코드를 입력하세요
SELECT SUBSTRING(PRODUCT_CODE,1,2) as CATEGORY, count(product_id) as PRODUCTS
from product
GROUP BY CATEGORY
order by CATEGORY ASC
