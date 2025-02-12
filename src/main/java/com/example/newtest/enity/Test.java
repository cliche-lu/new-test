package com.example.newtest.enity;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 93285
 * @Date: 2024/2/28
 * @Description: Test
 * @PROJECT_NAME: cliche
 * @Package_name: IntelliJ IDEA
 **/
public class Test {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Book book = new Book();
            book.setAuthor("测试");
            book.setPrice(100.00);
        }

//        books.add()
    }
}
