--��ѯ�������е�����
select * from students;
--ָ���в�ѯ
select sno,sname,sage from students;
--����չʾ asc����
select * from students order by sno asc;
--desc����
select * from students order by sage desc;
--�Ȱ����併������������ͬ���ٰ���ѧ����������
select * from students order by sage desc,sno asc;


--where ɾѡ������ɸѡָ������


--ͨ�õĲ�ѯ�ؼ��ֹؼ�����
--��ֵ�жϺͲ����ж�
select * from students where sno = 2;
select * from students where sname='�ŷ�';
select * from students where birthday = to_date('1999-01-01','yyyy-mm-dd') 

select * from students where sno != 10;
--��ֵƥ��
select * from students where sno = 1 or sno = 9 or sno = 10;
select * from students where sno in (8,9,1);
select * from students where sno not in (8,9,10)


select * from students where sno != 8 and sno != 9 and sno != 10;

--���ӹؼ���
select * from students where sage > 20 and address = 'ɽ��';
select * from students where sage < 20 or sno < 6;

--�������͵��ֶ�
select * from students where sage >= 20;

select sname,sage,sage + 6 from students where sage + 6 >= 30;

--
select * from students where sage >= 20 and sage <= 30;
select * from students where sage between 20 and 30;
select * from students where sage < 20 or sage > 30;
select * from students where not between 20 and 30;

select * from students where sname in ('����','����','�ŷ�')

--�ַ���ģ����ѯ
--$ƥ������������ַ�
select * from students where sname like '��%';
select * from students where sname like '%��%';
--�»�������ƥ��һ�������ַ�
select * from students where sname like '��__';


--��������
select * from students where birthday <  to_date('1999-01-01','yyyy-mm-dd');

select * from students
where birthday between to_date('1999-01-01','yyyy-mm-dd') and to_date('1999-12-31','yyyy-mm-dd');
--���ڵļӼ���������ԭ���ڵĻ�������ǰ�������ƶ�����
select sname,birthday ,birthday - 30 from students;

--null ��ֵ�ж�
select * from students where address is null;
select * from students where address is not null;

--����ȥ����ѯ����е��ظ����ݣ���ʾΨһ���
select distinct sage  from students;

--�ֶε�����
select sname || '����' || sage || '��' from students

update students set address = '' where sno = 1;








