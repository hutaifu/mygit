
create or replace procedure proc_sex(sex in number,scount out number)
as 
begin
  if sex=0 then
    select count(scode) into scount from students where ssex = '男';
  else
    select count(scode) into scount from students where ssex = '女';
  end if;
end;  

declare snum number;
begin
  proc_sex(1,snum);
  dbms_output.put_line(snum);
  end;
  
  


---DML触发器，DML:insert，delete，update
  -- 用于实现更加严格的数据完整性或者合理性的约束。
-- 系统触发器
-- 替代触发器
