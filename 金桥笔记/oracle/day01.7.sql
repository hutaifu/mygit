--nvl()  ����ֵ��ʾΪ����ֵ
select * from emp where comm is null;
select ename,sal * 12 + comm sal_year from emp;

select ename,nvl(comm,0)from emp;

--decode �жϷ���
select ename,job,decode(job,'CLERK','ҵ��Ա','MANAGER','����') from emp;

--case when
select ename,job,
case 
  when job = 'CLERK' then 'ҵ��Ա'
  when job = 'MANAGER'then '����'
  else '����'
  end job02
  from emp;
  
  --�������˹���֮��
  select sum(sal) from emp;
 --ƽ������
  select avg(sal) from emp; 
  --����Ա��
  select count(empno) from emp;
  --��߹���
  select max(sal) from emp;
  --��͹���
  select min(sal) from emp;
  
  select sum(sal),avg(sal),max(sal),count(sal) from emp;
  
  select max(sal) from emp where job = 'CLERK';
  
  --��ѯ��߹��ʵ���
  
  
  
  --����ƽ�����ʵ�Ա����Ϣ
  select ename from emp where sal > (select avg(sal) from emp);
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
