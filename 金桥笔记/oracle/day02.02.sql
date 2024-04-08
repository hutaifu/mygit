--存储过程的创建
create procedure proc_test
as 
begin
  Dbms_Output.put_line('hello');
end; 

--调用存储过程
begin
  proc_test();
end;  

--for update ：排他锁

select * from students

update students set ssex 

--定义带参数及返回值的存储过程
create or replace procedure proc_sex(sex in number,scount out number)
as 
begin
  if sex=1 then
    select count(scode) into scount from students where ssex = '男';
  else
    select count(scode) into scount from students where ssex = '女';
  end if;
end;  

--执行
--声明变量
declare snum number;
begin
  proc_sex(1,snum);
  dbms_output.put_line(snum);
  end;
  
  
 
  
  
  
  
  
  
  
  
