--字符函数
--获取某个字符的ascii码
select ascii('a') from dual;

--字符串的拼接||
select 'a'  ||   'b' from dual;
select ename || job from emp;
select concat (ename,job) from emp;

--长度
select length(ename) from emp;

--转大小写
select lower(job) from emp;
select upper('hello') from dual;
--字符串的查询，数据库中字符的下标从1开始
--返回某个子字符串在大字符串中的位置，如果不存在返回零
select ename, instr(ename,'A') from emp;
--截取字符串,从哪个位置开始截取，截取几个。
select ename,substr(ename,1,2) from emp;
select ename,substr(ename,3,2) from emp;
--字符串的替换,将原来的字符替换为目标字符
select job,replace(job,'M','m') from emp;

--字符串去空格
select ltrim('==hello==','=') from dual;
select rtrim('==hello==','=' from dual;
select ltrim('  hello  ') from dual;
--去掉两侧符号
select trim('=' from '==hello==') from dual;
select trim('  hello  ') from dual;
--数字函数
--绝对值
select abs(-3) from dual;
--余弦
select cos(10) from dual;
--反余弦
select acos(10) from dual;
--对数
select log(2,8) from dual;
--秘术
select power(4,4) from dual;
--余数
select mod(8,3) from dual;
--求平方根
select sqrt(256) from dual;
--大于或者等于某个数的最小整数
select ceil(5.9) from dual;
--小于等于某个数的最大整数
select floor(5.9) from dual;
--四舍五入操作
select round(123.45,1) from dual;
select round(123.45) from dual;
--截断函数
select trunc(123.45,1) from dual;
select trunc(123.999) from dual;
--日期函数
--获取指定月数后的日期,可以是负数，不能小数
select hiredate，add_months(hiredate,-3) from emp;
--获取某个日期当月的最后一天
select hiredate,last_day(hiredate) from emp;
--获取两个日期之间的月份
select hiredate,months_between(sysdate,hiredate) from emp;

--转换函数
--将字符串换为日期
select '1999-09-09', to_date('1999-09-09','yyyy-mm-dd') from dual;


--日期换为字符串
select hiredate,to_char(hiredate,'yyyy-mm-dd') from emp;
select hiredate,to_char(hiredate,'yyyy') from emp;

--将字符串转换为数字
select '123', to_number('123') from dual;






































