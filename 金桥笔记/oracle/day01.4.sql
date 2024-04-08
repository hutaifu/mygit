create table student(
       sno char(10) ,
       sname varchar2(8) ,
       sex char(2) default 'ÄĞ',
       birthday date ,
       sdept char(20)
)
alter table student add constraint pk_sno primary key(sno);
alter table student add constraint ck_sex check (sex = 'ÄĞ' or sex = 'Å®');




create table course(
       cno char(10),
       cname char(30),
       ccredit number(3) 
 )
alter table course add constraint pk_cno primary key(cno);
alter table course add constraint uni_sname unique(cname);



create table score(
       sno char(10),
       cno char(10),
       grade number(3)
)
alter table score add constraint pk_snocno primary key(sno,cno);
