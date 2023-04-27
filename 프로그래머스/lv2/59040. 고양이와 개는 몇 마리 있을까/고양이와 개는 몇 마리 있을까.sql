-- 코드를 입력하세요
SELECT ANIMAL_TYPE, COUNT(ANIMAL_ID) as count from animal_ins where ANIMAL_TYPE = 'Cat' or  ANIMAL_TYPE = 'Dog' group by animal_type order by animal_type;