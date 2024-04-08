--nvl()  将空值显示为其他值
select * from emp where comm is null;
select ename,sal * 12 + comm sal_year from emp;

select ename,nvl(comm,0)from emp;

--decode 判断方法
select ename,job,decode(job,'CLERK','业务员','MANAGER','经理') from emp;

--case when
select ename,job,
case 
  when job = 'CLERK' then '业务员'
  when job = 'MANAGER'then '经理'
  else '其他'
  end job02
  from emp;
  
  --求所有人工资之和
  select sum(sal) from emp;
 --平均工资
  select avg(sal) from emp; 
  --多少员工
  select count(empno) from emp;
  --最高工资
  select max(sal) from emp;
  --最低工资
  select min(sal) from emp;
  
  select sum(sal),avg(sal),max(sal),count(sal) from emp;
  
  select max(sal) from emp where job = 'CLERK';
  
  --查询最高工资的人
  
  
  
  --高于平均工资的员工信息
  select ename from emp where sal > (select avg(sal) from emp);
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
