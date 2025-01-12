-- 코드를 입력하세요
-- SELECT category, max(price) max_price, product_name
-- from food_product
-- where category in ('과자', '국', '김치', '식용유')
-- group by category, product_name
-- order by max_price desc

SELECT fp.category, fp.price AS max_price, fp.product_name
FROM food_product fp
WHERE fp.category IN ('과자', '국', '김치', '식용유')
  AND fp.price = (
    SELECT MAX(price)
    FROM food_product
    WHERE category = fp.category
  )
order by max_price desc