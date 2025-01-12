-- 코드를 작성해주세요

with sub as
(
    select year(differentiation_date) as date, max(size_of_colony) as size
    from ecoli_data
    group by date
)

select year(ed.differentiation_date) as year,
    (sub.size - size_of_colony) as year_dev,
    ed.id
from ecoli_data ed join sub on year(ed.differentiation_date) = sub.date
order by year, year_dev
