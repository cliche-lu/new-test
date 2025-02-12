package com.example.newtest.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/other")
public class OtherController {
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;


    @RequestMapping(method = RequestMethod.GET, value = "/json")

    public void jsonTest() {
        HttpEntity<JSONObject> formEntity = new HttpEntity(null, null);
        JSONObject str = restTemplate.getForObject("https://api.vgomap.com/api/Map/Data/1792429544318308352", JSONObject.class);
        JSONObject data = null;
        if (str != null) {
            data = str.getJSONObject("data");
        }
        String mapData = data.getString("mapData");
        JSONObject jsonObject = JSON.parseObject(mapData);
        JSONArray polygonData = jsonObject.getJSONArray("polygonData");
        JSONObject jsonObject1 = polygonData.getJSONObject(0);
        String s = jsonObject1.getString("name").replaceAll("\\s*", "");
        jsonObject1.getJSONObject("center");
        System.out.println("mapData = " + mapData);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/redis")
    public void redisTest() {
        redisTemplate.delete("test");
    }
}
