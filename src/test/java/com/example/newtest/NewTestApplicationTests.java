package com.example.newtest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.newtest.controller.BookController;
import com.example.newtest.enity.*;
import com.example.newtest.service.BookService;
import com.example.newtest.service.EnfiRiService;
import com.example.newtest.service.ISysPermissionService;
import com.example.newtest.service.MyTestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class NewTestApplicationTests {

    @Autowired
    private BookController bookController;

    @Autowired
    private ISysPermissionService sysPermissionService;

    @Autowired
    private BookService bookService;

    @Autowired
    private MyTestService myTestService;

//    @Autowired
//    private RabbitMQSenderService rabbitMQSenderService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private EnfiRiService enfiRiService;


    @Test
    public void test2() {
        String token = "5jVjDbR1wUHEKocElycR1L7xiBjKLIDb";
        RizhiNewEntity rizhiNewEntity = new RizhiNewEntity();
        rizhiNewEntity.setProjectId("1858677526244204691");
        rizhiNewEntity.setSubId("1869675444215873537");
        rizhiNewEntity.setDsubId("1869675444224262146");
        enfiRiService.enfiRiNew(token, rizhiNewEntity,"2024-12","06",3);
    }

    @Test
    public void test1() {
        String token = "JZ2T2XyfdrIzofunARBo5a24EvOJbBUp";
        RizhiEntity rizhiEntity = new RizhiEntity();
        rizhiEntity.setId(0);
        rizhiEntity.setAddRow(true);
//        rizhiEntity.setDate("2024-12-04");
        rizhiEntity.setOutputQuantityHours(0);
        rizhiEntity.setProfessionalHours(10);
        rizhiEntity.setProjectId("1858677526244204691");
        rizhiEntity.setSubId("1870035043053862913");
        rizhiEntity.setDsubId("1870035043062251521");
        enfiRiService.enfiRi(token, rizhiEntity,"2024-09","02");
    }

    @Test
    public void sendMsg() {
//        d1f91f3cac78b65c61f13403ad61a9a9
//        e253e471-0933-4bfa-b940-ad091e7f52bd
        String queueName = "myQueue";
        String msg = "hello word";

        rabbitTemplate.convertAndSend(queueName, msg);
//        Book book = new Book();
//        book.setPrice(10.123);
//        book.setName("myTest");
//        Message message = new FormattedMessage(ENGLISH,"my_first_msg",book);
//        rabbitMQSenderService.send("mytest","myKey",message);
    }

    @Test
    public void test() {
//        Book book = new Book();
//        book.setId("1");
//        book.setAuthor("123");
//        boolean allTest = bookService.updateById(book);
//        System.out.println("allTest = " + allTest);
//        List<Book> byName = bookService.findByName("1");
        List<Book> byName = bookService.likeTest("1");
        System.out.println("byName = " + byName);
    }

    @Test
    public void insertTest() {
        Book book = new Book();
        book.setAuthor("13123");
        bookController.insert(book);
    }

    @Test
    public void contextLoads() {
//        bookController.testParms(nema)
//    使用 BeanUtils.copyProperties(Object dest,Object orig) 和 PropertyUtils.copyProperties(Object dest,Object orig)，
//    原理无非是反射读取到属性列表，然后循环赋值，主要注意的只拷贝dest和orig的相同的名称的字段，
//    比如orig有一个userName属性，dest有一个userName属性，则orig的userName会赋值到dest的userName上。
        Book book = new Book();
        book.setName("123");
        book.setPages(100);
        book.setAuthor("cliche");

        BookTest bookTest = new BookTest();
        BeanUtils.copyProperties(book, bookTest, "name", "author");
        System.out.println("bookTest = " + bookTest);

    }

    @Test
    public void addPermissionTest() {
        String father = "铁路转运";
        String permission = "transferTask";
        SysPermission one = sysPermissionService.getOne(new QueryWrapper<SysPermission>().like("name", father));
        System.out.println("one = " + one);
        List<SysPermission> sysPermissionList = new ArrayList<>();

        SysPermission sysPermission = new SysPermission();


        sysPermission.setName("批量删除");
        sysPermission.setPerms("tms:" + permission + ":deleteBatch");
        sysPermissionList.add(sysPermission);

        SysPermission sysPermission1 = new SysPermission();

        sysPermission1.setName("删除");
        sysPermission1.setPerms("tms:" + permission + ":delete");
        sysPermissionList.add(sysPermission1);

        SysPermission sysPermission2 = new SysPermission();

        sysPermission2.setName("修改");
        sysPermission2.setPerms("tms:" + permission + ":edit");
        sysPermissionList.add(sysPermission2);

        SysPermission sysPermission3 = new SysPermission();

        sysPermission3.setName("列表页");
        sysPermission3.setPerms("tms:" + permission + ":list");
        sysPermissionList.add(sysPermission3);

        SysPermission sysPermission4 = new SysPermission();

        sysPermission4.setName("新增");
        sysPermission4.setPerms("tms:" + permission + ":add");
        sysPermissionList.add(sysPermission4);

        SysPermission sysPermission5 = new SysPermission();

        sysPermission5.setName("详情");
        sysPermission5.setPerms("tms:" + permission + ":queryById");
        sysPermissionList.add(sysPermission5);

        sysPermissionList.forEach(a -> {
            a.setMenuType(2);
            a.setPermsType("1");
//    a.setParentId("1742081614361427969");
            a.setParentId(one.getId());
            a.setCreateTime(new Date());
            a.setDelFlag(0);
            a.setRoute(true);
            a.setStatus("1");
            a.setLeaf(true);
            a.setCreateBy("myTest");
        });

        System.out.println("sysPermissionList = " + sysPermissionList);

        sysPermissionService.saveBatch(sysPermissionList);
    }

}
