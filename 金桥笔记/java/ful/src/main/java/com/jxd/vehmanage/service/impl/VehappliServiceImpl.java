package com.jxd.vehmanage.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxd.vehmanage.dao.VehappliMapper;
import com.jxd.vehmanage.model.Vehappli;
import com.jxd.vehmanage.service.IVehappliService;
import com.jxd.vehmanage.util.FrontToInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName VehappliServiceImpl
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/27
 * @Version 1.0
 */
@Service
public class VehappliServiceImpl implements IVehappliService {

    @Autowired
    private VehappliMapper vehappliMapper;


    /**
     * 根据员工编号，是否有车牌号，分页查询申请记录
     * @param queryMap 查询条件集合，分页信息，申请员工编号，是否以指派车辆
     * @return 申请记录集合
     */
    @Override
    public Map<String, Object> getVehapplis(Map<String, String> queryMap) {
        String page = queryMap.get("page");
        String limit = queryMap.get("limit");
        Integer appid = FrontToInteger.toInteger(queryMap.get("appid"));
        String appvehnum = queryMap.get("appvehnum");
        Map<String, Object> map = new HashMap(4);
        if(page != null && limit != null){
            IPage<Vehappli> pages = new Page(Integer.parseInt(page),Integer.parseInt(limit));
            IPage<Map<String,Object>> pageResult = vehappliMapper.selectApplis(pages,appid,appvehnum);
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
     * 添加申请记录
     *
     * @param vehappli 要添加的申请记录
     * @return 是否成功
     */
    @Override
    public boolean addVehapplis(Vehappli vehappli) {
        return vehappliMapper.insertAppli(vehappli);
    }
}
