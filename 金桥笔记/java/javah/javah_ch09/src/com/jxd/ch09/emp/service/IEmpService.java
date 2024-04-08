package com.jxd.ch09.emp.service;

import java.util.List;
import java.util.Map;

public interface IEmpService {
    /**
     * 查询员工信息和其部门名称
     * @return
     */
    List<Map<String,Object>> selectEmpinfo(String name);
}
