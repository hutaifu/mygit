select 'a','b','c' from dual
union
select 'd','e','f' from dual;
--ȥ���ظ�����
select deptno from emp
union
select deptno from dept
--��ȥ���ظ�����
select deptno from emp
union all
select deptno from dept
--ֻҪ����һ�£��������Ϳ��Խ���union����
select ename n from emp
union
select dname n from dept

select 

--��������
insert into dept 
select '50','�з�һ��','����' from dual
union
select '60','�з�����','�ൺ' from dual
union
select '70','���ʲ�','����' from dual;
select * from dept













