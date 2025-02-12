package com.example.newtest.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.newtest.enity.AddParam;
import com.example.newtest.enity.RizhiEntity;
import com.example.newtest.enity.RizhiNewEntity;
import com.example.newtest.service.EnfiRiService;
import com.example.newtest.utils.HolidayChecker;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@Service
public class EnfiRiServiceImpl implements EnfiRiService {

    public static final String url = "http://bpm.10.30.0.176.nip.io/api/biz/workload/add";

    @Override
    public void enfiRi(String token, RizhiEntity rizhi, String data, String startDate) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        if (StringUtils.isEmpty(startDate)) {
            startDate = "01";
        }
        String a = data + "-" + startDate;
        LocalDate st = LocalDate.parse(a, dateTimeFormatter);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("token", token); // 添加自定义请求头
        RestTemplate restTemplate = new RestTemplate();
        int num = 0;
        while (st.isBefore(LocalDate.now())) {
//            判断是否为星期天 不是星期天则调用
            boolean b = st.getDayOfWeek() == DayOfWeek.SUNDAY;
            if (b) {
                b = HolidayChecker.needWorkSunDay(st);
            }
//            判断是否为节假日
            boolean b1 = HolidayChecker.isHoliday(st);


            rizhi.setDate(st.format(dateTimeFormatter));

//            判断不是周末/周末调休/不是节假日调用接口
            if (!b && !b1) {
//                System.out.println("调用接口,日期是 " + rizhi.getDate() + "入参：" + rizhi);
             /*   ResponseEntity<JSONObject> jsonObjectResponseEntity = postRequest(headers, rizhi, restTemplate);
                HttpStatusCode statusCode = jsonObjectResponseEntity.getStatusCode();
                System.out.println("jsonObjectResponseEntity.getStatusCode() = " + statusCode);
                if (statusCode == HttpStatus.OK || statusCode.value() == 200) {
                    System.out.println("成功");
                    num++;
                }*/
            } else {
                System.out.println("不调用接口,日期是 " + rizhi.getDate() + "入参：" + rizhi);
            }
            st = st.plusDays(1);
            System.out.println("newArrivalDate = " + st);
        }
        System.out.println("调用成功次数：num = " + num);
    }

    @Override
    public void enfiRiNew(String token, RizhiNewEntity rizhi, String data, String startDate, int idStart) {
        if (StringUtils.isEmpty(startDate)) {
            startDate = "01";
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("token", token); // 添加自定义请求头
        RestTemplate restTemplate = new RestTemplate();

        getData(rizhi, idStart, data, startDate);
        System.out.println("rizhi = " + rizhi);
        ResponseEntity<JSONObject> jsonObjectResponseEntity = postRequest(headers, rizhi, restTemplate);
        System.out.println("jsonObjectResponseEntity = " + jsonObjectResponseEntity);
        System.out.println("restTemplate = " + restTemplate);

    }


    private ResponseEntity<JSONObject> postRequest(HttpHeaders headers, RizhiEntity rizhi, RestTemplate restTemplate) {
        HttpEntity<Object> objectHttpEntity = new HttpEntity<>(rizhi, headers);
        return restTemplate.exchange(url, HttpMethod.POST, objectHttpEntity, JSONObject.class);
    }

    private ResponseEntity<JSONObject> postRequest(HttpHeaders headers, RizhiNewEntity rizhi, RestTemplate restTemplate) {
        HttpEntity<Object> objectHttpEntity = new HttpEntity<>(rizhi, headers);
        return restTemplate.exchange(url, HttpMethod.POST, objectHttpEntity, JSONObject.class);
    }


    private void getData(RizhiNewEntity rizhi, int idStart, String data, String startDate) {
        ArrayList<AddParam> addParams = new ArrayList<>();
        String a = data + "-" + startDate;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate st = LocalDate.parse(a, dateTimeFormatter);
        while (st.isBefore(LocalDate.now())) {
//            判断是否为星期天 不是星期天则调用
            boolean b = st.getDayOfWeek() == DayOfWeek.SUNDAY;
            if (b) {
                b = HolidayChecker.needWorkSunDay(st);
            }
//            判断是否为节假日
            boolean b1 = HolidayChecker.isHoliday(st);

//            判断不是周末/周末调休/不是节假日调用接口
            if (!b && !b1) {
                idStart++;
                AddParam addParam = new AddParam();
                addParam.setId(idStart);
                addParam.setAddRow(true);
                addParam.setDate(st.format(dateTimeFormatter));
                addParam.setSurplusHours(7.5);
                addParam.setOutputQuantityHours(0);
                addParam.setProfessionalHours(7.5);
                addParam.setTextHours(0);
                addParams.add(addParam);
            }
            st = st.plusDays(1);
            System.out.println("newArrivalDate = " + st);
        }
        rizhi.setAddParams(addParams);
        rizhi.setEditParams(new ArrayList<>());
    }

}
