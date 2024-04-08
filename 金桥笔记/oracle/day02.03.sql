--触发器
create trigger trig_stu
after insert or update or delete
on students
for each row--针对受到影响的行数多次调用触发器，
  declare info varchar2(50);
begin
  if inserting then 
    info := '执行了新增操作';
    elsif updating then
      info := '执行了更新操作';
      else
        info := '执行了删除操作';
        end if;
        dbms_output.put_line(info);
        end;
        
select * from students;
update students set saddress = '济南';
