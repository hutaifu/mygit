--��������
create sequence seq_stu
start with 1
increment by 1
nomaxvalue

--���е�ʹ��
select seq_stu.nextval from dual;--��ȡ���е���һ��ֵ
select seq_stu.currval from dual;                --��ȡ���еĵ�ǰֵrom dual;


--�����е���һ��ֵ��Ϊѧ����ѧ��
insert into students (sno,sname,sage) values
(seq_stu.nextval,'����'��28)

--��ѯ����
select * from students;
