--�ַ�����
--��ȡĳ���ַ���ascii��
select ascii('a') from dual;

--�ַ�����ƴ��||
select 'a'  ||   'b' from dual;
select ename || job from emp;
select concat (ename,job) from emp;

--����
select length(ename) from emp;

--ת��Сд
select lower(job) from emp;
select upper('hello') from dual;
--�ַ����Ĳ�ѯ�����ݿ����ַ����±��1��ʼ
--����ĳ�����ַ����ڴ��ַ����е�λ�ã���������ڷ�����
select ename, instr(ename,'A') from emp;
--��ȡ�ַ���,���ĸ�λ�ÿ�ʼ��ȡ����ȡ������
select ename,substr(ename,1,2) from emp;
select ename,substr(ename,3,2) from emp;
--�ַ������滻,��ԭ�����ַ��滻ΪĿ���ַ�
select job,replace(job,'M','m') from emp;

--�ַ���ȥ�ո�
select ltrim('==hello==','=') from dual;
select rtrim('==hello==','=' from dual;
select ltrim('  hello  ') from dual;
--ȥ���������
select trim('=' from '==hello==') from dual;
select trim('  hello  ') from dual;
--���ֺ���
--����ֵ
select abs(-3) from dual;
--����
select cos(10) from dual;
--������
select acos(10) from dual;
--����
select log(2,8) from dual;
--����
select power(4,4) from dual;
--����
select mod(8,3) from dual;
--��ƽ����
select sqrt(256) from dual;
--���ڻ��ߵ���ĳ��������С����
select ceil(5.9) from dual;
--С�ڵ���ĳ�������������
select floor(5.9) from dual;
--�����������
select round(123.45,1) from dual;
select round(123.45) from dual;
--�ضϺ���
select trunc(123.45,1) from dual;
select trunc(123.999) from dual;
--���ں���
--��ȡָ�������������,�����Ǹ���������С��
select hiredate��add_months(hiredate,-3) from emp;
--��ȡĳ�����ڵ��µ����һ��
select hiredate,last_day(hiredate) from emp;
--��ȡ��������֮����·�
select hiredate,months_between(sysdate,hiredate) from emp;

--ת������
--���ַ�����Ϊ����
select '1999-09-09', to_date('1999-09-09','yyyy-mm-dd') from dual;


--���ڻ�Ϊ�ַ���
select hiredate,to_char(hiredate,'yyyy-mm-dd') from emp;
select hiredate,to_char(hiredate,'yyyy') from emp;

--���ַ���ת��Ϊ����
select '123', to_number('123') from dual;






































