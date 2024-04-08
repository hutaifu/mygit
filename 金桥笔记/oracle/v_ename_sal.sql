
create table emp1(
       enmpo number,
       ename varchar2(50),
       bir date,
       sex varchar(3),
       deptno number(30)
)
insert into emp1 values (21,'李云龙'，to_date('1993-05-01','yyyy-mm-dd'),'男',3)

insert into emp1 values (20,'李大龙'，to_date('1993-05-02','yyyy-mm-dd'),'男',3)
insert into emp1 values (19,'李小龙'，to_date('1993-05-02','yyyy-mm-dd'),'男',2)


create view v_emp1 
as
select * from emp1

update emp1 set bir = to_date('1993-05-01','yyyy-mm-dd') where ename = '李云龙'

delete from emp1 where dname = '李云龙'





