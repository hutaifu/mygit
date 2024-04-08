select 'a','b','c' from dual
union
select 'd','e','f' from dual;
--去掉重复数据
select deptno from emp
union
select deptno from dept
--不去掉重复数据
select deptno from emp
union all
select deptno from dept
--只要别名一致，列名，就可以进行union关联
select ename n from emp
union
select dname n from dept

select 

--批量插入
insert into dept 
select '50','研发一部','济南' from dual
union
select '60','研发二部','青岛' from dual
union
select '70','人资部','济南' from dual;
select * from dept













