package com.example.demo.controller;


import com.example.demo.model.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.UUID;


@RestController
@RequestMapping("/test2")
public class TestController2 {

    private static String _SESSION_KEY = "SESSION_KEY";

    //传递参数
    @RequestMapping("/getname")
    public String getName(HttpServletRequest request) {
        return "Name ->" + request.getParameter("name");//Servlet 方式
    }
//Spring MVC 方式
    @RequestMapping("/getname2")
    public String getName2(String name) {
        return "Name -> " + name;
    }
//传递多个参数
    @RequestMapping("/getname3")
    public String getName3(String name,Integer age) {
        return "Name -> " + name + "age" + age ;
    }

//    传递对象
    @RequestMapping("/user")
    public User add(User user) {
        return user;
    }
//对传递的对象重命名
    @RequestMapping("/rename")
    public String reName(@RequestParam(value = "n",required = false) String name) {
//        使用标签 @RequestParam 来进行对接收的前端对象在我们自己的代码里重命名
//前端传递参数必须传递n(属性不能为空),如果参数n属于是可传可不传,在其中加参数 required = false,因为默认是ture
        return name;
    }


//    后端拿到 前端的json 对象
    @RequestMapping("/add_json")
    public User addByJson(@RequestBody User user) {
        return user;
    }


//    获取URL中的参数
    @RequestMapping("/detail/{aid}")
//    datail 后面传递的是参数,必须使用花括号
    public Integer detail(@PathVariable("aid") Integer aid) {
        return aid;
    }

//    获取多个参数
    @RequestMapping("/datail2/{aid}/{name}")
//    datail2 后面的参数可以传递多个
    public String datail2(@PathVariable Integer aid,@PathVariable String name) {
//        如果URL中参数和方法的参数名字相同可以省略括号的内容直接在变量类型前设置
        return "aid:" + aid + "name:" + name;
    }



//    上传文件
    @RequestMapping("/upload")
    public String upload(@RequestPart("myfile")MultipartFile file) throws IOException {
        //1.生成一个唯一的Id || UUID 是全球唯一Id
        String name = UUID.randomUUID().toString().replace("-","");
        //2.得到源文件的后缀名
        name += (file.getOriginalFilename().
                substring(file.getOriginalFilename().lastIndexOf(".")));
        //保存路径
        String path = "D:\\image\\" + name;
        //保存文件
        file.transferTo(new File(path));
        return path;
    }

//    获取Cookie
    @RequestMapping("/getcookie")
    public String getCookie(@CookieValue(value = "java",required = false)String ck) {
        return ck;
    }

//设置session
    @RequestMapping("/set_sess")
    public String setSess(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(session != null) {
            session.setAttribute(_SESSION_KEY,"张三");
            return "session set success";
        }else {
            return "session set fail";
        }
    }

//    获取session
    @RequestMapping("/get_sess")
    public String getSess(@SessionAttribute(required = false,value = "SESSION_KEY")String name) {
        return name;
    }
}
