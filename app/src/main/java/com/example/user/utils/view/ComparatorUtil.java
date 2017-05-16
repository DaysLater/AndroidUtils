package com.example.user.utils.view;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 项目名称：AndroidUtils
 * 类描述：ComparatorUtil 描述: 排序的工具类
 * 创建人：songlijie
 * 创建时间：2017/5/16 10:58
 * 邮箱:814326663@qq.com
 */
public class ComparatorUtil {

    /**
     * 分组排序 把一类的分组到一起
     *
     * @param array  集合
     * @param srckey array中包含的object中的一个key
     * @return Map<String, List<JSONObject>>  map 集合
     */
    public static Map<String, List<JSONObject>> handleData(JSONArray array, String srckey) {
        Map<String, List<JSONObject>> map = new HashMap<String, List<JSONObject>>();
        for (int i = 0; i < array.size(); i++) {
            JSONObject json = array.getJSONObject(i);
            String teamId = json.getString(srckey);
            if (map.containsKey(teamId)) {
                List<JSONObject> list = map.get(teamId);
                list.add(json);
            } else {
                List<JSONObject> list = new ArrayList();
                list.add(json);
                map.put(teamId, list);
            }
        }
        return map;
    }

    /**
     * 获取map中集合
     *
     * @param data       map数据
     * @param srcKey     jsonobject中的key
     * @param comparator 排序方法 如果不排序则传null
     * @return List<JSONObject> 返回集合
     */
    public static List<JSONObject> getItems(Map<String, List<JSONObject>> data, String srcKey, Comparator comparator) {
        List<JSONObject> myActivityItems = new ArrayList<>();
        Iterator iter = data.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            String entryKey = (String) entry.getKey();
            List<JSONObject> val = (List<JSONObject>) entry.getValue();
            // 对list进行排序
            if (comparator != null) {
                Collections.sort(val, comparator);
            }
            String userId = val.get(0).getString(srcKey);
            for (int i = 0; i < val.size(); i++) {
                JSONObject object = val.get(i);
                JSONObject jsonObject = new JSONObject();
                jsonObject.put(srcKey, userId);
                jsonObject.put("object", object.toJSONString());
                myActivityItems.add(jsonObject);
            }
        }
        return myActivityItems;
    }
}
