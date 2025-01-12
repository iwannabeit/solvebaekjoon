-- 코드를 입력하세요
-- SELECT au.author_id, au.author_name, bk.category, bs.sales * bk.price
-- from book bk left join author au on bk.author_id = au.author_id
--     left join book_sales bs on bs.book_id = bk.book_id
-- group by bk.category, au.author_id, au.author_name

with sub as
(
select *
from book_sales
where to_char(sales_date, 'YYYY-MM') = '2022-01'
)

select au.author_id, au.author_name,category,
sum(sales * bk.price) as total_sales
from book bk join sub on bk.book_id = sub.book_id 
join author au on bk.author_id = au.author_id
group by au.author_id, au.author_name, category
order by au.author_id, category desc