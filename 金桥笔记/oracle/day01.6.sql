--����
insert into students (sno,sname,sage,birthday,address)
values (seq_stu.nextval,'�ŷ�',20,to_date('1999-09-09','yyyy-mm-dd'),'ɽ��')

--��ѯ���ݱ�
select * from students

insert into students (sno,sage,sname)values (seq_stu.nextval,20,'����')
--����ȫ���ֶΣ�˳��Ҫ�ͽ�������е�˳����ȫһ��
insert into students values (seq_stu.nextval,'�ܲ�'��23��to_date('1999-08-08','yyyy-mm-dd'),'ɽ��')

--ɾ������
delete from students where sname = '����';

--�޸�����
update students set birthday = to_date('1999-01-01','yyyy-mm-dd')
where sname = '����'

update students set birthday = to_date('1999-01-02','yyyy-mm-dd'),
address = 'ɽ��'
where sno = 6

