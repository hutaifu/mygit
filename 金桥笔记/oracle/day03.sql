select * from EMP1 t


select dname,avg(sal) from emp e left join dept d on e.deptno = d.deptno group by dname
