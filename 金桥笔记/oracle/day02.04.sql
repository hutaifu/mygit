--索引
--字典的目录
--在员工表中通过姓名查询
--如果没有索引，那么需要每条进行完整的比对，
--如果在姓名上添加索引后，首先会比对所有的姓名，直接定位
--所有一般需要创建在经常作为查询条件的列上。
--当我们要查询的数据要小于表中总数据的10%。
create index in_ename on emp (ename) ;

create tablespace myspace
datafile 'd:\my01.ora' size 10M
         'd:\my02.ora' size 10M
  extent management local
  uniform size 10M;
select * from emp
select * from dept
  
select ename from emp where sal >
(select sal from emp where ename = 'SMITH') 

select ename,dname from (select dname from dept where deptno in (select deptno from emp  where job = 'CLERK')) t
inner join 

select dname,ename from(select dname,ename,job from dept inner join emp on dept.deptno = emp.deptno) where job = 'CLERK'

select ename from emp where deptno = (select deptno from dept where dname = 'SALES')

select ename from emp where job = (select job from emp where ename = 'SCOTT')


