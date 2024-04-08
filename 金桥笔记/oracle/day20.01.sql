--子查询作为外层结果的过滤条件

--单行子查询用！=，>,< 进行筛选
select ename from emp where sal = (select max(sal)  from emp)

select ename from emp where sal > (select avg(sal) from emp)

--查询sales部们下的员工姓名
select deptno from dept where dname = 'SALEs'; 
select ename from emp where deptno = (select deptno from dept where dname = 'SALES' );

select ename from emp where sal > (select max(sal) from emp where deptno = 30)

--成绩高于80分的学生姓名
--in子查询
select studentid from score where score > 80;
select sname from students where scode in (select studentid from score where score > 80)
select * from students
--不高于80分的学生信息
select sname from students where scode not in (select studentid from score where score > 80)

--exists子查询
--不高于80分，not exists.
select sname from students where exists (select * from score where score > 80 and score.studentid = students.scode)

--in的应以场景，适用于内层查询数量较少的时侯
--exists的应用场景，适用于内层表数量较大的时候
--删除六十分以下的学生信息
delete from students where scode in (select studentid from score where score < 60)

--子查询作为一张临时表
--部门的详细信息，和部门人数
select d.*,t.dcount from dept d inner join (select deptno,count(empno) dcount  from emp group by deptno) t on d.deptno = t.deptno;
(select deptno,count(empno) dcount  from emp group by deptno) t 

--子查询作为字段
--员工姓名和部门名称
select ename,(select dname from dept where dept.deptno = emp.deptno ) dname from emp;

select rowid, e.* from emp e;
select rowid, d.* from dept d;
--对查询及过滤后的结果进行编号，每次都是从1开始
select rownum,e.* from emp e;

select rownum,e* from emp e where job = 'MANAGER'

--应用
--筛选表中前几条数据
--先执行 > 1500，筛选源数据，然后生成rownum,再进行rownum<= 5  的判断
select rownum,e.* from emp e where rownum <= 5 and sal > 1500;

--工资前五的员工信息
--rownum先生成，再<= 5最后order by 
select rownum,e.* from emp e where rownum <= 5 order by sal desc;

--
select rownum,t.*  from
(select * from emp order by sal desc) t 
where rownum  <= 5

--工资再六到10 的员工信息
--rownum可以进行> >= 判断
select rownum,e.* from emp e where rownum >= 6 and rownum <= 10; 
(select rownum r,e.* from emp e) t
select  t.*  from (select rownum r,e.* from emp e) t  where r >= 6 and r <= 10;

--工资6到10位员工信息
select * from
(select rownum r , t1.* from
(select * from emp order by sal desc) t1) t2
where r <= 10 and r >= 6





