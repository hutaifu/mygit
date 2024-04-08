--查询表中所有的数据
select * from students;
--指定列查询
select sno,sname,sage from students;
--排序展示 asc升序
select * from students order by sno asc;
--desc降序
select * from students order by sage desc;
--先按年龄降序排序，年龄相同的再按照学号升序排序
select * from students order by sage desc,sno asc;


--where 删选条件，筛选指定的行


--通用的查询关键字关键符号
--等值判断和不等判断
select * from students where sno = 2;
select * from students where sname='张飞';
select * from students where birthday = to_date('1999-01-01','yyyy-mm-dd') 

select * from students where sno != 10;
--多值匹配
select * from students where sno = 1 or sno = 9 or sno = 10;
select * from students where sno in (8,9,1);
select * from students where sno not in (8,9,10)


select * from students where sno != 8 and sno != 9 and sno != 10;

--连接关键字
select * from students where sage > 20 and address = '山东';
select * from students where sage < 20 or sno < 6;

--数字类型的字段
select * from students where sage >= 20;

select sname,sage,sage + 6 from students where sage + 6 >= 30;

--
select * from students where sage >= 20 and sage <= 30;
select * from students where sage between 20 and 30;
select * from students where sage < 20 or sage > 30;
select * from students where not between 20 and 30;

select * from students where sname in ('刘备','关羽','张飞')

--字符串模糊查询
--$匹配任意个任意字符
select * from students where sname like '张%';
select * from students where sname like '%三%';
--下划线用于匹配一个任意字符
select * from students where sname like '张__';


--日期类型
select * from students where birthday <  to_date('1999-01-01','yyyy-mm-dd');

select * from students
where birthday between to_date('1999-01-01','yyyy-mm-dd') and to_date('1999-12-31','yyyy-mm-dd');
--日期的加减操作是再原日期的基础上往前或往后推多少天
select sname,birthday ,birthday - 30 from students;

--null 空值判断
select * from students where address is null;
select * from students where address is not null;

--用于去掉查询结果中的重复数据，显示唯一结果
select distinct sage  from students;

--字段的连接
select sname || '今年' || sage || '岁' from students

update students set address = '' where sno = 1;








