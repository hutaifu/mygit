
create or replace procedure proc_sex(sex in number,scount out number)
as 
begin
  if sex=0 then
    select count(scode) into scount from students where ssex = '��';
  else
    select count(scode) into scount from students where ssex = 'Ů';
  end if;
end;  

declare snum number;
begin
  proc_sex(1,snum);
  dbms_output.put_line(snum);
  end;
  
  


---DML��������DML:insert��delete��update
  -- ����ʵ�ָ����ϸ�����������Ի��ߺ����Ե�Լ����
-- ϵͳ������
-- ���������
