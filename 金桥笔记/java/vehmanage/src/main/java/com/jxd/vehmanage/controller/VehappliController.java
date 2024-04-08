package com.jxd.vehmanage.controller;

import com.jxd.vehmanage.model.Vehappli;
import com.jxd.vehmanage.service.IVehappliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public String addVehAppliList(@RequestBody Vehappli vehappli){
        if (vehappliService.addVehapplis(vehappli)){
            return "success";
        }
        return "error";
    }
}
