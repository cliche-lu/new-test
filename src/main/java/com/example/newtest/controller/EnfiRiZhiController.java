package com.example.newtest.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.newtest.common.Result;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/riZhiTest")
public class EnfiRiZhiController {

    @PostMapping("/test")
    public Result riZhiTest(@RequestParam String startDate, @RequestParam String endDate) throws ParseException {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate st = LocalDate.parse(startDate, dateTimeFormatter);
        LocalDate et = LocalDate.parse(endDate, dateTimeFormatter);
        while (st.isBefore(et)) {
            RestTemplate restTemplate = new RestTemplate();
            JSONObject jsonObject = JSONObject.parseObject("{\n" +
                    "    \"id\": 10,\n" +
                    "    \"addRow\": true,\n" +
                    "    \"date\": \"2024-12-04\",\n" +
                    "    \"outputQuantityHours\": 0,\n" +
                    "    \"professionalHours\": 10,\n" +
                    "    \"projectId\": \"1858677526244204691\",\n" +
                    "    \"subId\": \"1869675444215873537\",\n" +
                    "    \"dsubId\": \"1869675444224262146\"\n" +
                    "}");
            jsonObject.put("date", st);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.add("token", "JUvVVFDcgoig42aGOq9yJq2f6yXpVr0d"); // 添加自定义请求头

            String url = "http://bpm.10.30.0.176.nip.io/api/biz/workload/add";
            HttpEntity<Object> objectHttpEntity = new HttpEntity<>(jsonObject,headers);
            ResponseEntity<JSONObject> response = restTemplate.exchange(url, HttpMethod.POST, objectHttpEntity, JSONObject.class);

//            ResponseEntity<JSONObject> response = restTemplate.exchange(url, HttpMethod.POST, JSONObject.class,jsonObject, JSONObject.class);
            st = st.plusDays(1);
            System.out.println("newArrivalDate = " + st);
        }
        return Result.ok();
    }

    @PostMapping("/newTest")
    public Result riZhiTestNew(@RequestBody JSONObject jsonObject) throws ParseException {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return Result.ok();
    }
}
