--ֻ��DBAȨ�޵��û����ܴ�����ͼ����
--������ϸ��Ϣ��ƽ������
create view v_dept_sal
as 
select d.* ,avg_sal from scott.dept d
inner join (select deptno,avg(sal) avg_sal from scott.emp group by deptno) t
on d.deptno = t.deptno;

--��ѯ��ͼ
--������Դ�ڻ�������ͼ�����洢����
select * from v_dept_sal

--ɾ����ͼ
drop view v_dept_sal;


create view v_dept_mancount
as
select dname,count(empno)from
(select * from dept inner join emp on dept.deptno = emp.deptno)group by dname
