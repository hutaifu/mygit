package com.jxd.vehmanage.service;

import com.jxd.vehmanage.model.Vehappli;

import java.util.Map;

public interface IVehappliService {

    /**
     * 根据员工编号，是否有车牌号，分页查询申请记录
     * @param queryMap 查询条件集合，分页信息，申请员工编号，是否以指派车辆
     * @return 申请记录集合
     */
    Map<String,Object> getVehapplis(Map<String, String> queryMap);

    /**
     * 添加申请记录
     * @param vehappli 要添加的申请记录
     * @return 是否成功
     */
    boolean addVehapplis(Vehappli vehappli);
}
