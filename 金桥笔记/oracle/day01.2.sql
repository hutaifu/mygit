--����ѧ����
create table students(
      sno number not null,
      sname varchar2(50),
      sage number,
      birthday date,
      address varchar2(100)
)


--Լ������
--��������
alter table students add constraint pk_sno primary key(sno);
--���ݼ��Լ��
alter table students add constraint ck_sage check(sage > 12 and sage < 30);
--ΨһԼ��
alter table students add constraint uni_sname unique(sname);
--����Լ�����������ݽ��б�����������
--��������
insert into students(sno,sname,sage,birthday,address)
values (2,'������',18,sysdate,'ɽ��');
