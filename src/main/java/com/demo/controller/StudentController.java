package com.demo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

/**
 * description: freemarker、SpringMVC整合
 *      1、创建ftl模板文件
 *      2、配置freemarker模板加载地址
 *      3、配置freemarker解析器
 *      4、code controller
 * @author: JiuDongDong
 * date: 2017/9/8.
 */
@Controller
public class StudentController {

    @RequestMapping("/helloWorld")
    public String helloWorld(Model model) {
        String word0 = "Hello！ ";
        String word1 = "This is my freemarker demo！";
        //将数据添加到视图数据容器中
        model.addAttribute("theFirstWorld", word0);
        model.addAttribute("theSecondWorld", word1);
        return "Hello.ftl";
    }
}
