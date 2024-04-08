--创建序列
create sequence seq_stu
start with 1
increment by 1
nomaxvalue

--序列的使用
select seq_stu.nextval from dual;--获取序列的下一个值
select seq_stu.currval from dual;                --获取序列的当前值rom dual;


--用序列的下一个值作为学生的学号
insert into students (sno,sname,sage) values
(seq_stu.nextval,'刘备'，28)

--查询数据
select * from students;
