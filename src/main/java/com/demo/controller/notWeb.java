package com.demo.controller;

import com.demo.entity.Animal;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileWriter;
import java.io.StringReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * description: freemarker的使用场景：普通模式即非web模式、web模式，此demo演示普通模式
 * @author: JiuDongDong
 * date: 2017/9/9.
 */
public class notWeb {
    public static void main(String[] args) {
        // 1、构建model，封装Animal数据
        List<Animal> list = new ArrayList<>();
        // 狗
        Animal a1 = new Animal();
        a1.setName("小狗");
        a1.setPrice(80);
        list.add(a1);
        // 猫
        Animal a2 = new Animal();
        a2.setName("小喵");
        a2.setPrice(90);
        list.add(a2);

        // 2、构建model，封装“性别”数据
        Map<String, Object> sexMap = new HashMap<>();
        sexMap.put("1", "男");
        sexMap.put("0", "女");

        Map<String, Object> map = new HashMap<>();
        map.put("user", "冉冉");
        map.put("score", 10);
        map.put("team", "一班,二班");
        map.put("animals", list);
        map.put("sexMap", sexMap);
        try {
            // freemarker的配置类
            Configuration config = new Configuration();
            config.setDefaultEncoding("UTF-8");// 编码
            // 模板库位置
            File templateLocation = new File("target/classes/ftl");//相对路径
            config.setDirectoryForTemplateLoading(templateLocation);
            // 从模板库获取animal模板
            Template template = config.getTemplate("animal.ftl");
            template.process(map, new FileWriter("D:\\bb.html"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
