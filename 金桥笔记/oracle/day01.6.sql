--新增
insert into students (sno,sname,sage,birthday,address)
values (seq_stu.nextval,'张飞',20,to_date('1999-09-09','yyyy-mm-dd'),'山东')

--查询数据表
select * from students

insert into students (sno,sage,sname)values (seq_stu.nextval,20,'赵云')
--插入全部字段，顺序要和建表语句中的顺序完全一致
insert into students values (seq_stu.nextval,'曹操'，23，to_date('1999-08-08','yyyy-mm-dd'),'山东')

--删除数据
delete from students where sname = '李四';

--修改数据
update students set birthday = to_date('1999-01-01','yyyy-mm-dd')
where sname = '刘备'

update students set birthday = to_date('1999-01-02','yyyy-mm-dd'),
address = '山东'
where sno = 6

