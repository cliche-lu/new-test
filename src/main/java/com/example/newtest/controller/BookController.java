package com.example.newtest.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.newtest.common.Result;
import com.example.newtest.enity.Book;
import com.example.newtest.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Hades
 * @Date: 2023/9/25
 * @Description: BookController
 * @PROJECT_NAME: new-test
 * @Package_name: IntelliJ IDEA
 **/
@RestController
@Slf4j
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/findAll")
    public Result findAll() {
        List<Book> books = bookService.findAll();
//        log的打印方法
        books.forEach(book ->log.info("信息{}",book.toString()));
        log.error("错误信息{}","23" );
        return Result.ok(books);
    }

    @GetMapping("/findById")
    public Result findById(@RequestParam Integer id) {
        Book books = bookService.findById(id);
        return Result.ok(books);
    }

    @GetMapping("/findByName")
    public Result findByName(@RequestParam String name) {
        List<Book> bookList = bookService.findByName(name);
        return Result.ok(bookList);
    }

    @GetMapping("/findAllReport")
    public Map findAllReport() {
        HashMap<String, List<Book>> map = new HashMap<>();
        List<Book> books = bookService.findAll();
        map.put("data", books);
        return map;
    }

    @GetMapping("/findAllReport1")
    public Map findAllReport1(@RequestParam Integer id) {
        HashMap<String, List<Book>> map = new HashMap<>();
        Book book = bookService.findById(id);
        List<Book> books = new ArrayList<>();
        books.add(book);
        map.put("data", books);
        return map;
    }

    @PostMapping("/updateById")
    public Result updateById(@RequestBody Book book) {
        boolean i = bookService.updateById(book);
        if (i) {
            return Result.ok();
        } else {
            return Result.fail("插入失败！");
        }

    }

    @GetMapping("/test")
    public Result myTest(@RequestParam String name, @RequestParam String name1) {
        List<Book> list = bookService.selectName(name, name1);

        return Result.ok(list);

    }

    @PostMapping("/insert")
    public Result insert(@RequestBody Book book) {
        boolean save = bookService.save(book);

        return Result.ok(save);

    }

    @GetMapping("/testParms")
    public Result testParms(@RequestParam String name, String name1) {
        List<Book> list = new ArrayList<>();
        if (StringUtils.isEmpty(name1)) {
            list = bookService.findByName(name);
        } else {
            list = bookService.selectName(name, name1);
        }

        return Result.ok(list);

    }

    @PostMapping("/save")
    public Result save(@RequestBody Book book) {
        boolean i = bookService.save(book);
        if (i) {
            return Result.ok();
        } else {
            return Result.fail("失败");
        }
    }

    @GetMapping("/testMapParams")
    public Result testMapParams(@RequestBody Map<String,Object> params) {

        return Result.ok(params);
    }
}
