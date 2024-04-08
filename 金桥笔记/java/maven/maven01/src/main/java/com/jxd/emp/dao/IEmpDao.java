package com.jxd.emp.dao;

import com.jxd.emp.model.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IEmpDao {

    /**
     * 查询所有员工信息
     * @return 员工集合
     */
    List<Emp> getAllEmp();

    /**
     * 新增员工
     * @param emp 新增员工对象
     * @return 新增条数
     */
    int addEmp(Emp emp);

    /**
     * 根据员工编号修改员工信息
     * @param emp 要修改的员工对象
     * @return 是否修改成功
     */
    boolean updateEmp(Emp emp);

    /**
     * 根据员工编号删除员工信息
     * @param empno 要删除的员工编号
     * @return 删除的行数 #{}
     */
    int deleteEmp(Integer empno);

    /**
     * 根据编号查询员工
     * @param empno 员工对象
     * @return
     */
    Emp getEmpByNo(int empno);

    /**
     * 通过员工的姓名和工作查找
     * @param ename 姓名
     * @param job 工作
     * @return 员工对象
     */
    List<Emp> getEmpByNameAndJob(@Param("ename") String ename, @Param("job") String job);

    /**
     * 根据姓名和工作查询信息
     * @param map map中封装了姓名和工作
     * @return 对象
     */
    Emp getEmpByNameAndJob2(Map<String,String> map);

    /**
     * 按照姓名查询工作
     * @param ename 要查询的姓名
     * @return 工作
     */
    String getJobByEname(String ename);

    /**
     * 分页查询员工信息
     * @param count 跳过多少条
     * @param pageSize 没页多少条
     * @return 查询到的员工信息
     */
    List<Emp> getEmpByPage(@Param("count") int count,@Param("pageSize") int pageSize);

    /**
     * 根据员工编号批量删除员工信息
     * @param empnos 要删除的员工编号
     * @return 是否要删除成功
     */
    boolean deleteBatch(@Param("empnos") int[] empnos);

    /**
     * 查询员工的信息及其部门 一个员工有一个部门，一对一
     * 这种一对一的关系没有合适的实体类存储时，可以封装成map
     * @return map
     */
    List<Map<String,Object>> getEmpAndDept();

    /**
     * 批量新增员工
     * @param emps 要新增的员工
     * @return 是否新增成功
     */
    boolean addBatchEmp(List<Emp> emps);

    /**
     * 批量更新员工信息
     * @param emps 要更新的员工信息
     * @return
     */
    boolean updateBatchEmp(List<Emp> emps);
}
