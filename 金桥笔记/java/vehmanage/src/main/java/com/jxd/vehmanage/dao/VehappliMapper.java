package com.jxd.vehmanage.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jxd.vehmanage.model.Vehappli;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface VehappliMapper {

    /**
     * 根据申请人查询用车申请
     * @param appid 申请人编号
     * @param appvehnum 指派车牌号
     * @return 用车申请集合
     */
    IPage<Map<String,Object>> selectApplis(IPage<Vehappli> page, @Param("appid") int appid, @Param("appvehnum") String appvehnum);

    /**
     * 添加用车申请
     * @param vehappli 用车申请对象
     * @return 是否成功
     */
    boolean insertAppli(Vehappli vehappli);
}
