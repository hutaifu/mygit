--�Ӳ�ѯ��Ϊ������Ĺ�������

--�����Ӳ�ѯ�ã�=��>,< ����ɸѡ
select ename from emp where sal = (select max(sal)  from emp)

select ename from emp where sal > (select avg(sal) from emp)

--��ѯsales�����µ�Ա������
select deptno from dept where dname = 'SALEs'; 
select ename from emp where deptno = (select deptno from dept where dname = 'SALES' );

select ename from emp where sal > (select max(sal) from emp where deptno = 30)

--�ɼ�����80�ֵ�ѧ������
--in�Ӳ�ѯ
select studentid from score where score > 80;
select sname from students where scode in (select studentid from score where score > 80)
select * from students
--������80�ֵ�ѧ����Ϣ
select sname from students where scode not in (select studentid from score where score > 80)

--exists�Ӳ�ѯ
--������80�֣�not exists.
select sname from students where exists (select * from score where score > 80 and score.studentid = students.scode)

--in��Ӧ�Գ������������ڲ��ѯ�������ٵ�ʱ��
--exists��Ӧ�ó������������ڲ�������ϴ��ʱ��
--ɾ����ʮ�����µ�ѧ����Ϣ
delete from students where scode in (select studentid from score where score < 60)

--�Ӳ�ѯ��Ϊһ����ʱ��
--���ŵ���ϸ��Ϣ���Ͳ�������
select d.*,t.dcount from dept d inner join (select deptno,count(empno) dcount  from emp group by deptno) t on d.deptno = t.deptno;
(select deptno,count(empno) dcount  from emp group by deptno) t 

--�Ӳ�ѯ��Ϊ�ֶ�
--Ա�������Ͳ�������
select ename,(select dname from dept where dept.deptno = emp.deptno ) dname from emp;

select rowid, e.* from emp e;
select rowid, d.* from dept d;
--�Բ�ѯ�����˺�Ľ�����б�ţ�ÿ�ζ��Ǵ�1��ʼ
select rownum,e.* from emp e;

select rownum,e* from emp e where job = 'MANAGER'

--Ӧ��
--ɸѡ����ǰ��������
--��ִ�� > 1500��ɸѡԴ���ݣ�Ȼ������rownum,�ٽ���rownum<= 5  ���ж�
select rownum,e.* from emp e where rownum <= 5 and sal > 1500;

--����ǰ���Ա����Ϣ
--rownum�����ɣ���<= 5���order by 
select rownum,e.* from emp e where rownum <= 5 order by sal desc;

--
select rownum,t.*  from
(select * from emp order by sal desc) t 
where rownum  <= 5

--����������10 ��Ա����Ϣ
--rownum���Խ���> >= �ж�
select rownum,e.* from emp e where rownum >= 6 and rownum <= 10; 
(select rownum r,e.* from emp e) t
select  t.*  from (select rownum r,e.* from emp e) t  where r >= 6 and r <= 10;

--����6��10λԱ����Ϣ
select * from
(select rownum r , t1.* from
(select * from emp order by sal desc) t1) t2
where r <= 10 and r >= 6





