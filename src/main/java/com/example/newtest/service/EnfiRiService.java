package com.example.newtest.service;

import com.alibaba.fastjson.JSONObject;
import com.example.newtest.enity.RizhiEntity;
import com.example.newtest.enity.RizhiNewEntity;
import org.springframework.http.ResponseEntity;

public interface EnfiRiService {
    /**
     * 月报接口
     *
     * @param token     token
     * @param rizhi     日志内容
     * @param data      日期 2024-12 格式：yyyy-mm
     * @param startDate 开始日期 01 格式：dd
     * @return
     */
    void enfiRi(String token, RizhiEntity rizhi, String data, String startDate);

    /**
     * 月报接口新
     *
     * @param token token
     * @param rizhi 日志内容
     * @param data 日期 2024-12 格式：yyyy-mm
     * @param startDate 开始日期 01 格式：dd
     * @param idStart id起始值
     */
    void enfiRiNew(String token, RizhiNewEntity rizhi, String data, String startDate, int idStart);
}
