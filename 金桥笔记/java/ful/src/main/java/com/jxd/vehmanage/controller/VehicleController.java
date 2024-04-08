package com.jxd.vehmanage.controller;

import com.jxd.vehmanage.model.Vehicle;
import com.jxd.vehmanage.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ClassName VehicleController
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/28
 * @Version 1.0
 */
@RestController
public class VehicleController {

    @Autowired
    private IVehicleService vehicleService;

    @RequestMapping("/getVehicleList")
    public Map<String,Object> getVehicleList(@RequestBody Map<String,String> queryMap){
        return vehicleService.gettVehicles(queryMap);
    }

    @RequestMapping("/addVehicle")
    public String addVehicle(@RequestBody Vehicle vehicle){
        if (vehicleService.addVeh(vehicle)){
            return "新增成功";
        }
        return "新增失败";
    }

    @RequestMapping("/changeVehicle")
    public String changeVehicle(@RequestBody Vehicle vehicle){
        if (vehicleService.changeVeh(vehicle)){
            return "修改成功";
        }
        return "修改失败";
    }

    @RequestMapping("/delVehicle")
    public String delVehicle(@RequestBody int[] vnos){
        if (vehicleService.removeVeh(vnos)){
            return "删除成功";
        }
        return "删除失败";
    }
}
