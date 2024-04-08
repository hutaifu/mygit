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
    IPage<Map<String,Object>> selectApplis(IPage<Vehappli> page, @Param("appid") Integer appid,
                                           @Param("appvehnum") String appvehnum,@Param("appdate") String appdate);

    /**
     * 添加用车申请
     * @param map 用车申请对象
     * @return 是否成功
     */
    boolean insertAppli(Map<String,Object> map);

    /**
     * 修改用车申请
     * @param vehappli 修改后的申请
     * @return 是否成功
     */
    boolean updateAppli(Vehappli vehappli);

    /**
     * 获取用车申请部门信息
     * @return 返回部门集合
     */
    List<Map<String,Object>> selectDept();

    /**
     * 添加额外的申请信息
     * @return 是否成功
     */
    boolean insertextraapp(Map<String,Object> map);

    /**
     * 根据车牌号修改出车状态
     * @param vstateno
     * @param appvehnum
     * @return
     */
    boolean updatevstateno(@Param("vstateno") Integer vstateno,@Param("appvehnum") String appvehnum );

    boolean delappli(@Param("appno") Integer appno);
}
