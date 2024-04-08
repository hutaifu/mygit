package com.jxd.vehmanage.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxd.vehmanage.dao.VehappliMapper;
import com.jxd.vehmanage.dao.VehicleMapper;
import com.jxd.vehmanage.model.Vehappli;
import com.jxd.vehmanage.model.Vehicle;
import com.jxd.vehmanage.service.IVehappliService;
import com.jxd.vehmanage.util.FrontToInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
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

    @Autowired
    private VehicleMapper vehicleMapper;


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
        String appdate = queryMap.get("appdate");
        Map<String, Object> map = new HashMap(4);
        if(page != null && limit != null){
            IPage<Vehappli> pages = new Page(Integer.parseInt(page),Integer.parseInt(limit));
            IPage<Map<String,Object>> pageResult = vehappliMapper.selectApplis(pages,appid,appvehnum,appdate);
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
     * @param map 要添加的申请记录
     * @return 是否成功
     */
    @Override
    @Transactional
    public boolean addVehapplis(Map<String,Object> map) {
        if (vehappliMapper.insertAppli(map) && vehappliMapper.insertextraapp(map)){
            return true;
        } else {
            return false;
        }
    }

    /**
     * 修改申请记录和车辆，还车
     *
     * @param map 修改后的记录
     * @return 是否成功
     */
    @Override
    @Transactional
    public boolean changeAppli(Map<String,String> map) {
        Vehappli vehappli = new Vehappli(Integer.parseInt(map.get("appno")),Integer.parseInt(map.get("appid")),map.get("appdate"),Integer.parseInt(map.get("appvehtypeno")),
                                         map.get("exusetime"),map.get("exreturntime"),map.get("appreason"),map.get("appvehnum"),Double.parseDouble(map.get("appgomil")),map.get("gotime"),
                                        Double.parseDouble(map.get("appbackmil")),map.get("backtime"), Double.parseDouble(map.get("usemil")));
        if (vehappliMapper.updateAppli(vehappli) && vehappliMapper.updatevstateno(Integer.parseInt(map.get("vstateno")),vehappli.getAppvehnum())){
            return true;
        }
            return false;

    }

    /**
     * 修改申请记录和车辆,指派车辆
     *
     * @param map 修改信息集合
     * @return
     */
    @Override
    @Transactional
    public boolean changeAppliAndVeh(Map<String,String> map) {
        Vehappli vehappli = new Vehappli(Integer.parseInt(map.get("appno")),Integer.parseInt(map.get("appid")),map.get("appdate"),Integer.parseInt(map.get("appvehtypeno")),
                                        map.get("exusetime"),map.get("exreturntime"),map.get("appreason"),map.get("appvehnum"),null,null,null,null,
                                        null);
        Vehicle vehicle = new Vehicle(Integer.parseInt(map.get("vno")),Integer.parseInt(map.get("vtypeno")),map.get("vnum"),Double.parseDouble(map.get("vcurmil")),map.get("vprutime"),
                                    Integer.parseInt(map.get("vstateno")),Integer.parseInt(map.get("vsitnum")));
        if (vehappliMapper.updateAppli(vehappli) && vehicleMapper.updateVeh(vehicle)){
            return true;
        }
        return false;

    }


    /**
     * 得到部门信息
     *
     * @return 返回部门集合
     */
    @Override
    public List<Map<String, Object>> getDept() {
        return vehappliMapper.selectDept();
    }

    /**
     * 删除申请信息
     *
     * @param appno 编号
     * @return 是否成功
     */
    @Override
    public boolean delappli(Integer appno) {
        return vehappliMapper.delappli(appno);
    }
}
