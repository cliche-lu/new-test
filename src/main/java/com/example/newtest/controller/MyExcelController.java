package com.example.newtest.controller;

import com.alibaba.excel.EasyExcel;
import com.example.newtest.common.Result;
import com.example.newtest.enity.DemoData;
import com.example.newtest.enity.DemoTestData;
import com.example.newtest.excel.DemoDataListener;
import com.example.newtest.excel.DemoDataTestListener;
import com.example.newtest.service.MyTestService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Auther: 93285
 * @Date: 2024/1/4
 * @Description: MyExcelController
 * @PROJECT_NAME: cliche
 * @Package_name: IntelliJ IDEA
 **/
@RestController
@RequestMapping("/excel")
public class MyExcelController {

    @Resource
    private MyTestService myTestService;


    @PostMapping("/test")
    public Result read(@RequestParam("file") MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        DemoDataListener productPlanReadListener = new DemoDataListener();
        EasyExcel.read(inputStream, DemoData.class ,productPlanReadListener).sheet().headRowNumber(2).doRead();
        List<DemoData> cachedDataList = productPlanReadListener.getCachedDataList();
        return Result.ok(cachedDataList);
    }

    @PostMapping("/test01")
    public Result test01(@RequestParam("file") MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        DemoDataTestListener productPlanReadListener = new DemoDataTestListener();
        EasyExcel.read(inputStream, DemoTestData.class ,productPlanReadListener).sheet().headRowNumber(2).doRead();
        List<DemoTestData> cachedDataList = productPlanReadListener.getCachedDataList();
        return Result.ok(cachedDataList);
    }

    @PostMapping("/test02")
    public Result test02(@RequestParam("file") MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        DemoDataTestListener productPlanReadListener = new DemoDataTestListener();
        productPlanReadListener.setMyTestService(myTestService);
        EasyExcel.read(inputStream, DemoTestData.class ,productPlanReadListener).sheet().headRowNumber(2).doRead();
        List<DemoTestData> cachedDataList = productPlanReadListener.getCachedDataList();
        return Result.ok(cachedDataList);
    }
}
