-- 코드를 입력하세요
SELECT A.FOOD_TYPE  ,A.REST_ID  ,A.REST_NAME    ,A.FAVORITES 
FROM REST_INFO A
INNER JOIN(
                SELECT 
                        FOOD_TYPE
                        ,MAX(FAVORITES) AS FAVORITES
                FROM REST_INFO
                GROUP BY FOOD_TYPE
            ) B
            ON A.FOOD_TYPE = B.FOOD_TYPE AND A.FAVORITES = B.FAVORITES
ORDER BY A.FOOD_TYPE DESC
# 베낌