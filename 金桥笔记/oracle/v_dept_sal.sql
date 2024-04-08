--只有DBA权限的用户才能创建视图对象
--部门详细信息，平均工资
create view v_dept_sal
as 
select d.* ,avg_sal from scott.dept d
inner join (select deptno,avg(sal) avg_sal from scott.emp group by deptno) t
on d.deptno = t.deptno;

--查询视图
--数据来源于基础表，视图本身不存储数据
select * from v_dept_sal

--删除视图
drop view v_dept_sal;


create view v_dept_mancount
as
select dname,count(empno)from
(select * from dept inner join emp on dept.deptno = emp.deptno)group by dname
