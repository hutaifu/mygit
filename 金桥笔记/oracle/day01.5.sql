select * from emp

select * from emp where hiredate in(to_date('198_-%-01','yyyy-mm-dd')-1);

select * from emp where hiredate < to_date('1985-01-01','yyyy-mm-dd');

select ename from emp where ename like '______';

select ename from emp where ename like 'J%';

update emp set ename = 

select * from emp order by ename;


select ename from emp order by hiredate;

select ename,job,sal from emp order by job desc,sal��


select * from emp where hiredate in(select max())


select replace(ename,'A','a') from emp;

select substr(ename,1,3) from emp;

select ename, trunc(to_date(hiredate),'year'), trunc(to_date(hiredate),'month')  from emp;

select ename from emp order by hiredate;

select * from emp where substr(to_char(hiredate),6,1) = '2';

select ename from emp where ename like '%A%';

select table_name from user_tables;

select ename,trunc(sal/30) from emp;

select * from emp where extract(month from hiredate) = 2;

select ename,around(sysdate - hiredate,2) from en

select ename,sal from emp where sal > 2000;

select ename,mgr from emp where empno = 7499;

select ename,sal from emp where sal not between 2000 and 4000;

select ename,mgr,hiredate from emp where hiredate between to_date('1981-02-01','yyyy-mm-dd') and to_date('1982-05-01','yyyy-mm-dd')

select ename,deptno from emp where deptno = 20 or deptno = 30;

select ename,hiredate from emp where hiredate between to_date('1981-01-01','yyyy-mm-dd') and to_date('1982-01-01','yyyy-mm-dd')

select ename,job from emp where comm is null;

select ename,sal,comm from emp where comm is not null;

select ename from emp where ename like '__A%';

select ename from emp where ename like '%A%' and ename like '%E%';

select ename,job,sal from emp order by job desc ,sal;

select * from emp where hiredate = last_day(hiredate)-2;

select ename ,extract(year from hiredate)year,extract(month from hiredate)month from emp 


