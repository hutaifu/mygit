package com.jxd.vehmanage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jxd.vehmanage.model.Vehappli;
import com.jxd.vehmanage.model.Vehicle;

import java.util.List;
import java.util.Map;

public interface IVehappliService {

    /**
     * 根据员工编号，是否有车牌号，分页查询申请记录
     * @param queryMap 查询条件集合，分页信息，申请员工编号，是否以指派车辆
     * @return 申请记录集合
     */
    Map<String,Object> getVehapplis(Map<String,String> queryMap);

    /**
     * 添加申请记录
     * @param map 要添加的申请记录
     * @return 是否成功
     */
    boolean addVehapplis(Map<String,Object> map);

    /**
     * 修改申请记录
     * @param map 修改后的记录
     * @return 是否成功
     */
    boolean changeAppli(Map<String,String> map);

    /**
     * 修改申请记录和车辆
     * @param map 修改信息集合
     * @return
     */
    boolean changeAppliAndVeh(Map<String,String> map);

    /**
     * 得到部门信息
     * @return 返回部门集合
     */
    List<Map<String,Object>> getDept();

    /**
     * 删除申请信息
     * @param appno 编号
     * @return 是否成功
     */
    boolean delappli(Integer appno);
}


