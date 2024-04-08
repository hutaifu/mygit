--创建学生类
create table students(
      sno number not null,
      sname varchar2(50),
      sage number,
      birthday date,
      address varchar2(100)
)


--约束条件
--主键规则
alter table students add constraint pk_sno primary key(sno);
--内容检查约束
alter table students add constraint ck_sage check(sage > 12 and sage < 30);
--唯一约束
alter table students add constraint uni_sname unique(sname);
--以上约束都是在数据进行保存是起作用
--保存数据
insert into students(sno,sname,sage,birthday,address)
values (2,'张三丰',18,sysdate,'山东');
