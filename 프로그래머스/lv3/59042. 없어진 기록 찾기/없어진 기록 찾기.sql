-- 코드를 입력하세요
SELECT o.ANIMAL_ID, o.NAME from ANIMAL_OUTS o left join ANIMAL_INS i on o.animal_id = i.animal_id where i.datetime is null order by o.animal_id