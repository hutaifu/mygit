package com.jxd.vehmanage.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jxd.vehmanage.model.Vehicle;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface VehicleMapper {

    /**
     * 根据车辆编号，类型，状态，座位数分页查询车辆
     * @param page 分页
     * @param vno 编号
     * @param vtypeno 类型编号
     * @param vstateno 状态编号
     * @param vsitnum 最少座位数
     * @return 返回map集合
     */
    IPage<Map<String,Object>> selectVehicles(IPage<Vehicle> page, @Param("vno") int vno, @Param("vtypeno") int vtypeno,
                                             @Param("vstateno") int vstateno, @Param("vsitnum") int vsitnum);

    /**
     * 增加车辆
     * @param vehicle 增加的车辆对象
     * @return 是否成功
     */
    boolean insertVeh(Vehicle vehicle);

    /**
     * 修改车辆
     * @param vehicle 修改后的车辆
     * @return 是否成功
     */
    boolean updateVeh(Vehicle vehicle);

    /**
     * 删除车辆
     * @param vnos 要删除的车辆编号数组
     * @return 是否成功
     */
    boolean delVeh(int[] vnos);






}
