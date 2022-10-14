-- 데이터 연동 후 intelliJ에서 쿼리 날리고 확인

select *
from seoul_hospital;

select count(*)
from seoul_hospital;

select district,
       count(category) cnt
from seoul_hospital
group by district
order by cnt desc;

select *
from seoul_hospital limit 1000;
