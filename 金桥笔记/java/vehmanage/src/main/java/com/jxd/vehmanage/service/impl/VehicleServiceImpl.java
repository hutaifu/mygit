package com.jxd.vehmanage.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxd.vehmanage.dao.VehicleMapper;
import com.jxd.vehmanage.model.Vehappli;
import com.jxd.vehmanage.model.Vehicle;
import com.jxd.vehmanage.service.IVehicleService;
import com.jxd.vehmanage.util.FrontToInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName VehicleServiceImpl
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/27
 * @Version 1.0
 */
@Service
public class VehicleServiceImpl implements IVehicleService {

    @Autowired
    private VehicleMapper vehicleMapper;

    /**
     * 根据车辆编号，类型，状态，座位数分页查询车辆
     * @param queryMap 查询条件集合，分页信息，车辆编号，类型编号，状态编号，座位数
     * @return 返回map集合
     */
    @Override
    public Map<String, Object> gettVehicles(Map<String, String> queryMap) {
        String page = queryMap.get("page");
        String limit = queryMap.get("limit");
        Integer vno = FrontToInteger.toInteger(queryMap.get("vno"));
        Integer vtypeno = FrontToInteger.toInteger(queryMap.get("vtypeno"));
        Integer vstateno = FrontToInteger.toInteger(queryMap.get("vstateno"));
        Integer vsitnum = FrontToInteger.toInteger(queryMap.get("vsitnum"));
        Map<String, Object> map = new HashMap(4);
        if(page != null && limit != null){
            IPage<Vehicle> pages = new Page(Integer.parseInt(page),Integer.parseInt(limit));
            IPage<Map<String,Object>> pageResult = vehicleMapper.selectVehicles(pages,vno,vtypeno,vstateno,vsitnum);
            map.put("count",pageResult.getTotal());
            map.put("data",pageResult.getRecords());
            map.put("code",0);
            return map;
        }else{
            map.put("data", (Object)null);
            map.put("code", "500");
            map.put("msg", "参数不符");
            map.put("count", (Object)null);
            return map;
        }
    }

    /**
     * 增加车辆
     *
     * @param vehicle 增加的车辆对象
     * @return 是否成功
     */
    @Override
    public boolean addVeh(Vehicle vehicle) {
        return vehicleMapper.insertVeh(vehicle);
    }

    /**
     * 修改车辆
     *
     * @param vehicle 修改后的车辆
     * @return 是否成功
     */
    @Override
    public boolean changeVeh(Vehicle vehicle) {
        return vehicleMapper.updateVeh(vehicle);
    }

    /**
     * 删除车辆
     *
     * @param vnos 要删除的车辆编号数组
     * @return 是否成功
     */
    @Override
    public boolean removeVeh(int[] vnos) {
        return vehicleMapper.delVeh(vnos);
    }
}
