--�洢���̵Ĵ���
create procedure proc_test
as 
begin
  Dbms_Output.put_line('hello');
end; 

--���ô洢����
begin
  proc_test();
end;  

--for update ��������

select * from students

update students set ssex 

--���������������ֵ�Ĵ洢����
create or replace procedure proc_sex(sex in number,scount out number)
as 
begin
  if sex=1 then
    select count(scode) into scount from students where ssex = '��';
  else
    select count(scode) into scount from students where ssex = 'Ů';
  end if;
end;  

--ִ��
--��������
declare snum number;
begin
  proc_sex(1,snum);
  dbms_output.put_line(snum);
  end;
  
  
 
  
  
  
  
  
  
  
  
