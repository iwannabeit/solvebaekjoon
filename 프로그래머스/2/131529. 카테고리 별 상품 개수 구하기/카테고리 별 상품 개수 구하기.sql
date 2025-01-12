-- 코드를 입력하세요
SELECT
    LEFT(product_code, 2) category,
    COUNT(product_id) products
FROM
    product
GROUP BY
    1
ORDER BY
    1;