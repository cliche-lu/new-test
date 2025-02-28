package com.cliche.newtest.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cliche.newtest.common.CodeEnum;

/**
 * @Author: cliche
 * @Date: 2024/5/10
 * @Description: EnumUtil
 * @PROJECT_NAME: new-test
 * @Package_name: IntelliJ IDEA
 **/
public class EnumUtil {

    private EnumUtil() {

    }

    /**
     * 根据code，获取枚举类msg
     *
     * @param code code
     * @param t    枚举类.class
     * @param <T>
     * @return msg
     */
    public static <T extends CodeEnum> String getByCode(String code, Class<T> t) {
        String res = "";
        for (T item : t.getEnumConstants()) {
            if (item.getCode().equals(code)) {
                res = item.getMsg();
                break;
            }
        }
        return res;
    }

    /**
     * 根据msg，获取枚举类code
     *
     * @param msg code
     * @param t   枚举类.class
     * @param <T>
     * @return msg
     */
    public static <T extends CodeEnum> String getByMsg(String msg, Class<T> t) {
        String res = "";
        for (T item : t.getEnumConstants()) {
            if (item.getMsg().equals(msg)) {
                res = item.getCode();
                break;
            }
        }
        return res;
    }

    public static <T extends CodeEnum> JSONArray getByEnumList(Class<T> t) {
        JSONArray jsonArray = new JSONArray();
        for (T item : t.getEnumConstants()) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", item.getCode());
            jsonObject.put("msg", item.getMsg());
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }


}
