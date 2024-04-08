package com.jxd.bookmanger.util;

import com.jxd.bookmanger.model.VoBook;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.List;

/**
 * @ClassName ToJson
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/28
 * @Version 1.0
 */

public class LayuiToJson {
    public static JSONObject getjson(List list){
        //将list转换为json数组
        JSONArray jsonArray = JSONArray.fromObject(list);
        // 创建json对象
        JSONObject json = new JSONObject();
        // 将数据放到json对象中
        json.put("code",0);
        json.put("msg","");
        json.put("count",list.size());
        json.put("data",jsonArray);
        return json;

    }
}
