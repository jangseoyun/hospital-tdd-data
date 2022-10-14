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
from seoul_hospital
limit 1000;

select subdivision,
       count(subdivision) cnt
from seoul_hospital
group by subdivision
order by cnt desc;

select subdivision,
       name
from seoul_hospital
where subdivision like '%치과%';

select district,
    count(district) cnt
from seoul_hospital
where subdivision like '%성형외과%'
group by district
order by cnt desc;




