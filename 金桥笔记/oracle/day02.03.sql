--������
create trigger trig_stu
after insert or update or delete
on students
for each row--����ܵ�Ӱ���������ε��ô�������
  declare info varchar2(50);
begin
  if inserting then 
    info := 'ִ������������';
    elsif updating then
      info := 'ִ���˸��²���';
      else
        info := 'ִ����ɾ������';
        end if;
        dbms_output.put_line(info);
        end;
        
select * from students;
update students set saddress = '����';
