--����
--�ֵ��Ŀ¼
--��Ա������ͨ��������ѯ
--���û����������ô��Ҫÿ�����������ıȶԣ�
--�����������������������Ȼ�ȶ����е�������ֱ�Ӷ�λ
--����һ����Ҫ�����ھ�����Ϊ��ѯ���������ϡ�
--������Ҫ��ѯ������ҪС�ڱ��������ݵ�10%��
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


