-- 코드를 작성해주세요
# 베낌
WITH SKILL_CHECK AS (
    SELECT 
        D.ID,
        D.EMAIL,
        D.SKILL_CODE,
        SUM(CASE WHEN S.CATEGORY = 'Front End' THEN S.CODE ELSE 0 END) AS FRONT_END_CODE,
        SUM(CASE WHEN S.NAME = 'Python' THEN S.CODE ELSE 0 END) AS PYTHON_CODE,
        SUM(CASE WHEN S.NAME = 'C#' THEN S.CODE ELSE 0 END) AS CSHARP_CODE
    FROM DEVELOPERS D
    CROSS JOIN SKILLCODES S
    GROUP BY D.ID, D.EMAIL, D.SKILL_CODE
)
SELECT 
    CASE 
        WHEN (SKILL_CODE & FRONT_END_CODE) > 0 
             AND (SKILL_CODE & PYTHON_CODE) > 0 THEN 'A'
        WHEN (SKILL_CODE & CSHARP_CODE) > 0 THEN 'B'
        WHEN (SKILL_CODE & FRONT_END_CODE) > 0 THEN 'C'
    END AS GRADE,
    ID,
    EMAIL
FROM SKILL_CHECK
WHERE (
    ((SKILL_CODE & FRONT_END_CODE) > 0 AND (SKILL_CODE & PYTHON_CODE) > 0) 
    OR (SKILL_CODE & CSHARP_CODE) > 0  
    OR (SKILL_CODE & FRONT_END_CODE) > 0  
)
ORDER BY GRADE, ID
