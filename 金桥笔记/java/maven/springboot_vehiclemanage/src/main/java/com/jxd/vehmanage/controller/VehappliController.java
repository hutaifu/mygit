package com.jxd.vehmanage.controller;

import com.jxd.vehmanage.model.Vehappli;
import com.jxd.vehmanage.model.Vehicle;
import com.jxd.vehmanage.service.IVehappliService;
import com.jxd.vehmanage.util.FrontToInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.rowset.serial.SerialStruct;
import java.util.List;
import java.util.Map;

/**
 * @ClassName VehappliController
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/28
 * @Version 1.0
 */
@RestController
public class VehappliController {

    @Autowired
    private IVehappliService vehappliService;

    @RequestMapping("/getVehAppliList")
    public Map<String,Object> getVehAppliList(@RequestBody Map<String,String> queryMap){
        return vehappliService.getVehapplis(queryMap);
    }

    @RequestMapping("/addVehAppliList")
    public String addVehAppliList(@RequestBody Map<String,Object> map){
        if (vehappliService.addVehapplis(map)){
            return "success";
        }
        return "error";
    }

    @RequestMapping("/changeAppli")
    public String changeAppl(@RequestBody Map<String ,String> map){
        if (vehappliService.changeAppli(map)){
            return "success";
        }
        return "error";
    }
    @RequestMapping("/changeAppliAndVeh")
    public String changeApplAndVeh(@RequestBody Map<String,String> map){
        if (vehappliService.changeAppliAndVeh(map)){
            return "success";
        }
        return "error";
    }

    @RequestMapping("/getDept")
    public List<Map<String,Object>> getDept(){
        return vehappliService.getDept();
    }

    @RequestMapping("/delAppli")
    public String delappli(@RequestBody Map<String,String> map){
        Integer appno = FrontToInteger.toInteger(map.get("appno"));
        if (vehappliService.delappli(appno)){
            return "success";
        }
        return "error";
    }
}
