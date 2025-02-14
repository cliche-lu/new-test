package com.example.newtest.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FileSerializerUtils {
    private static final Logger logger = LoggerFactory.getLogger(FileSerializerUtils.class);

    public static void main(String[] args) throws IOException {

    }

    public static String getJson(MultipartFile file) {
        // 读取文件内容为字节数组
        byte[] fileContent;
        try {
            fileContent = file.getBytes();
        } catch (IOException e) {
            logger.error("读取文件内容失败: " + e.getMessage());
            throw new RuntimeException(e);
        }

        // 创建一个包含文件内容的对象
        FileData fileData = new FileData(file.getOriginalFilename(), fileContent);

        // 创建 ObjectMapper 对象
        ObjectMapper objectMapper = new ObjectMapper();

        // 注册自定义序列化器
        SimpleModule module = new SimpleModule().addSerializer(FileData.class, new FileDataSerializer());
        objectMapper.registerModule(module);


        // 将对象序列化为 JSON

        String json;
        try {
            json = objectMapper.writeValueAsString(fileData);
        } catch (JsonProcessingException e) {
            logger.error("序列化文件内容失败: {}", e.getMessage());
            throw new RuntimeException(e);
        }
        return json;
    }

    @Data
    static class FileData {
        private String fileName;
        public byte[] content;

        public FileData(String fileName, byte[] content) {
            this.content = content;
            this.fileName = fileName;
        }
    }

    public static class FileDataSerializer extends JsonSerializer<FileData> {
        @Override
        public void serialize(FileData value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeStartObject();
            gen.writeStringField("fileName", value.getFileName());
            gen.writeBinaryField("content", value.getContent());
            gen.writeEndObject();
        }
    }
}
