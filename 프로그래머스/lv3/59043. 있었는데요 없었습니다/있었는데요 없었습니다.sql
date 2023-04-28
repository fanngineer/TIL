-- 코드를 입력하세요
SELECT o.ANIMAL_ID, o.NAME from ANIMAL_INS i join ANIMAL_OUTS o on i.ANIMAL_ID = o.ANIMAL_ID where i.DATETIME > o.datetime order by i.datetime