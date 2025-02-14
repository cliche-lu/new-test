package com.example.newtest.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.newtest.common.MyResult;
import com.example.newtest.utils.FileSerializerUtils;
import com.example.newtest.utils.InputStreamToBytes;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/file")
public class FileController {

    @PostMapping("/upload")
    public MyResult uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
//        String originalFilename = (String) params.get("originalFilename");
//        String contentType = (String) params.get("contentType");
//        Long size = (Long) params.get("size");
//        byte[] bytes = (byte[]) params.get("bytes");
//        InputStream inputStream = (InputStream) params.get("inputStream");

//        File f = new File(file.getOriginalFilename(), file.getContentType(), file.getSize(),
//                new Binary(file.getBytes()));
//        f.setMd5(MD5Util.getMD5(file.getInputStream()));

        Map<String, Object> map = new HashMap<>();
        map.put("originalFilename", file.getOriginalFilename());
        map.put("contentType", file.getContentType());
        map.put("size", file.getSize());
        map.put("bytes", file.getBytes());
        map.put("inputStream", InputStreamToBytes.toByteArray(file.getInputStream()));
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.add("token", token); // 添加自定义请求头
        HttpEntity<Object> objectHttpEntity = new HttpEntity<>(map, headers);
        ResponseEntity<String> exchange = restTemplate.exchange("http://localhost:8081/upload2", HttpMethod.POST, objectHttpEntity, String.class);
        String body = exchange.getBody();
        System.out.println("body = " + body);
        return MyResult.ok("上传成功");
    }

}
