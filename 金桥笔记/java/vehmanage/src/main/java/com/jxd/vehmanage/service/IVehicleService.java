package com.jxd.vehmanage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jxd.vehmanage.model.Vehicle;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface IVehicleService {

    /**
     * 根据车辆编号，类型，状态，座位数分页查询车辆
     * @param queryMap 查询条件集合，分页信息，车辆编号，类型编号，状态编号，座位数
     * @return 返回map集合
     */
    Map<String,Object> gettVehicles(Map<String, String> queryMap);

    /**
     * 增加车辆
     * @param vehicle 增加的车辆对象
     * @return 是否成功
     */
    boolean addVeh(Vehicle vehicle);

    /**
     * 修改车辆
     * @param vehicle 修改后的车辆
     * @return 是否成功
     */
    boolean changeVeh(Vehicle vehicle);

    /**
     * 删除车辆
     * @param vnos 要删除的车辆编号数组
     * @return 是否成功
     */
    boolean removeVeh(int[] vnos);

}
