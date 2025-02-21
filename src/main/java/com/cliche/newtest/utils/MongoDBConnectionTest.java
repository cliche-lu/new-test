package com.cliche.newtest.utils;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnectionTest {
    public static void main(String[] args) {
        String uri = "mongodb://localhost:27017/mydatabase"; // 修改为你的MongoDB连接字符串
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("mydatabase");
            System.out.println("Connected to MongoDB!");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Failed to connect to MongoDB.");
        }
    }
}
