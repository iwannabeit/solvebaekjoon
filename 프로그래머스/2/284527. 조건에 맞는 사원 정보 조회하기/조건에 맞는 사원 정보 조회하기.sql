-- 코드를 작성해주세요  
# 베낌
WITH 
cte_total_score AS(
    SELECT
        emp_no,
        SUM(score) score
    FROM
        hr_grade
    GROUP BY 
        1
),
cte_score_rnk AS(
    SELECT
        c.emp_no, e.emp_name, e.position, e.email, c.score,
        DENSE_RANK() OVER(ORDER BY score DESC) rnk
    FROM
        cte_total_score c
        JOIN hr_employees e
        ON c.emp_no = e.emp_no
)

SELECT
    score,
    emp_no,
    emp_name,
    position,
    email
FROM
    cte_score_rnk
WHERE
    rnk=1;