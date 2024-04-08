create view v_dept_mancount
as
select dname,count(empno) emcoun from
(select * from dept inner join emp on dept.deptno = emp.deptno)group by dname

replace view v_dept_mancount
as
select dname,avg(sal) avg_sal from
(select * from dept inner join emp on dept.deptno = emp.deptno)group by dname

drop view v_dept_mancount
