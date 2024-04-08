package com.jxd.vehmanage.controller;

import com.jxd.vehmanage.model.Vehicle;
import com.jxd.vehmanage.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
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
      return vehicleService.addVeh(vehicle);
    }

    @RequestMapping("/changeVehicle")
    public String changeVehicle(@RequestBody Vehicle vehicle){
        return vehicleService.changeVeh(vehicle);
    }

    @RequestMapping("/delVehicle")
    public String delVehicle(@RequestBody int[] vnos){
        if (vehicleService.removeVeh(vnos)){
            return "success";
        }
        return "error";
    }
    @RequestMapping("/getType")
    public List<Map<String,Object>> getType(){
        return vehicleService.getType();
    }

    @RequestMapping("/getState")
    public List<Map<String,Object>> getState(){
        return vehicleService.getState();
    }
}
