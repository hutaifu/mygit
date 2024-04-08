select ename,dname,sal from emp full outer join dept on emp.deptno = dept.deptno;

select count(empno),emp.deptno, dname from emp inner join dept on emp.deptno = dept.deptno group by emp.deptno ;

select * from emp.

select min(sal),job  from emp group by job;

select min(sal),deptno from emp where job = 'MANAGER' group by deptno;
select t1.ename,t1.hiredate,t2.ename,t2.hiredate from emp t1 inner join emp t2 on t1.mgr = t2.empno where t1.hiredate < t2.hiredate

select s, dept.deptno,dname from dept full outer join (select count(empno) s,deptno from emp group by deptno) cou on cou.deptno = dept.deptno;

select dname from emp inner join dept on emp.deptno = dept.deptno group by dname having count(ename)>0

select dname,avg(sal) from dept left join emp on dept.deptno = emp.deptno group by emp.deptno,dname having avg(sal) > 2000

select dname,avg(sal) from emp inner join dept on emp.deptno = dept.deptno group by dname;

select comm,dname from emp inner join dept on emp.deptno = dept.deptno 

select comm,dname from emp natural join dept 

select * from emp,dept
