package com.cliche.newtest.controller;


import com.cliche.newtest.common.MyResult;
import com.cliche.newtest.enity.File;
import com.cliche.newtest.service.FileService;
import com.cliche.newtest.utils.InputStreamToBytes;
import com.cliche.newtest.utils.MD5Util;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired
    private FileService fileService;
    @Value("${server.address}")
    private String serverAddress;
    @Value("${server.port}")
    private String serverPort;
    /*@PostMapping("/upload1")
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
    }*/

    @RequestMapping(value = "/")
    public String index(Model model) {
        // 展示最新二十条数据
        model.addAttribute("files", fileService.listFilesByPage(0, 20));
        return "index";
    }

    /**
     * 分页查询文件
     *
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @GetMapping("files/{pageIndex}/{pageSize}")
    @ResponseBody
    public List<File> listFilesByPage(@PathVariable int pageIndex, @PathVariable int pageSize) {
        return fileService.listFilesByPage(pageIndex, pageSize);
    }

    /**
     * 获取文件片信息
     *
     * @param id
     * @return
     * @throws UnsupportedEncodingException
     */
    @GetMapping("files/{id}")
    @ResponseBody
    public ResponseEntity<Object> serveFile(@PathVariable String id) throws UnsupportedEncodingException {

        Optional<File> file = fileService.getFileById(id);

        if (file.isPresent()) {
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName=" + new String(file.get().getName().getBytes("utf-8"),"ISO-8859-1"))
                    .header(HttpHeaders.CONTENT_TYPE, "application/octet-stream")
                    .header(HttpHeaders.CONTENT_LENGTH, file.get().getSize() + "").header("Connection", "close")
                    .body(file.get().getContent().getData());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("File was not fount");
        }

    }

    /**
     * 在线显示文件
     *
     * @param id
     * @return
     */
    @GetMapping("/view/{id}")
    @ResponseBody
    public ResponseEntity<Object> serveFileOnline(@PathVariable String id) {

        Optional<File> file = fileService.getFileById(id);

        return file.<ResponseEntity<Object>>map(value -> ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "fileName=\"" + value.getName() + "\"")
                .header(HttpHeaders.CONTENT_TYPE, value.getContentType())
                .header(HttpHeaders.CONTENT_LENGTH, String.valueOf(value.getSize())).header("Connection", "close")
                .body(value.getContent().getData())).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("File was not fount"));

    }

    /**
     * 上传
     *
     * @param file
     * @param redirectAttributes
     * @return
     */
    @PostMapping("/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

        try {
            File f = new File(file.getOriginalFilename(), file.getContentType(), file.getSize(),
                    new Binary(file.getBytes()));
            f.setMd5(MD5Util.getMD5(file.getInputStream()));
            fileService.saveFile(f);
        } catch (IOException | NoSuchAlgorithmException ex) {
            ex.printStackTrace();
            redirectAttributes.addFlashAttribute("message", "Your " + file.getOriginalFilename() + " is wrong!");
            return "redirect:/";
        }

        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/";
    }

    /**
     * 上传接口
     *
     * @param file
     * @return
     */
    @PostMapping("/upload")
    @ResponseBody
    public MyResult handleFileUpload(@RequestParam("file") MultipartFile file) {
        File returnFile = null;
        try {
            File f = new File(file.getOriginalFilename(), file.getContentType(), file.getSize(),
                    new Binary(file.getBytes()));
            f.setMd5(MD5Util.getMD5(file.getInputStream()));
            returnFile = fileService.saveFile(f);
            String path = "http://" + serverAddress + ":" + serverPort + "/file/view/" + returnFile.getId();
            return MyResult.success(path);

        } catch (IOException | NoSuchAlgorithmException ex) {
            ex.printStackTrace();
            return MyResult.fail(ex.getMessage());
        }

    }

    /**
     * 删除文件
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteFile(@PathVariable String id) {

        try {
            fileService.removeFile(id);
            return ResponseEntity.status(HttpStatus.OK).body("DELETE Success!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
