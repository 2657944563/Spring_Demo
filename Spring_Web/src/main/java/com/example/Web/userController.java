package com.example.Web;

import com.example.doMain.VO;
import com.example.doMain.user;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@Controller
//@RequestMapping("/user")
public class userController {

    @RequestMapping("/quick")
    public String save() {
        return "/success.jsp";
    }

    @RequestMapping(value = "/quick2", params = {"name", "password!123"})
    public String save3() {
        return "/success.jsp";
    }

    @RequestMapping("/quick1")
    public String save1() {
        System.out.println("访问quick1的get方法");
        return "/Spring_web1";
    }

    @RequestMapping(value = "/quick1", method = RequestMethod.POST)
    public String save2() {
        System.out.println("访问quick1的post方法");
        return "/Spring_web1";
    }

    //    @RequestMapping("/quick3")
//    public String save4() {
//        System.out.println("访问quick3的get方法");
//        return "su";
//    }

    @RequestMapping("/quick4")
    public String save4() {
        return "forward:/success.jsp";
    }

    @RequestMapping("/quick5")
    public String save5() {
        return "redirect:/success.jsp";
    }

    /**
     * 手动创建modelAndView并且返回
     *
     * @return 返回一个设置了视图源和提供给页面使用的参数的modelandview对象
     */
    @RequestMapping("/quick6")
    public ModelAndView save6() {
        ModelAndView modelAndView = new ModelAndView("success.jsp");
        modelAndView.addObject("name", "2657944563");
        return modelAndView;
    }

    /**
     * MVC提供注入的参数
     *
     * @param modelAndView MVC提供，用于返回，并且设置参数
     * @return 返回一个页面模块
     */
    @RequestMapping("/quick7")
    public ModelAndView save7(ModelAndView modelAndView) {
        modelAndView.setViewName("success.jsp");
        modelAndView.addObject("name", "quick7");
        return modelAndView;
    }

    /**
     * MVC注入一个Model对象用于输入参数提供给展示层
     *
     * @param model MVC提供
     * @return 返回一个页面的路径+名称
     */
    @RequestMapping("/quick8")
    public String save8(Model model) {
        model.addAttribute("name", "quick8");
        return "success.jsp";
    }

    /**
     * 使用response进行数据回写
     *
     * @param response MVC注入的一个response对象用于数据回写
     */
    @RequestMapping("/quick9")
    public void save9(HttpServletResponse response) {
        response.setContentType("text/html; charset=UTF-8");
        try {
            response.getWriter().println("回写数据测试");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用@ResponseBody表示这个是一个回写数据的
     *
     * @return 返回回写的数据
     */
    @RequestMapping("/quick10")
    @ResponseBody
    public String save10() {
        return "@Response注解回写数据测试";
    }

    /**
     * 使用jackson对数据回写json格式进行格式化
     *
     * @return json数据
     */
    @RequestMapping("/quick11")
    @ResponseBody
    public String save11() throws JsonProcessingException {
        user User = new user();
        User.setAge(12);
        User.setName("zhangsan");
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(User);
    }

    @RequestMapping("/quick12")
    @ResponseBody
    public user save12() throws JsonProcessingException {
        user User = new user();
        User.setAge(123);
        User.setName("wangwu");
        return User;
    }

    /**
     * 获取请求参数
     *
     * @param name 传入的name参数
     * @param age  传入的age参数
     * @return 返回的需要json表示的对象
     * @throws JsonProcessingException 抛出转换错误
     * @RequestParam 这个注解用于指定前端的参数名称，如果不写那么就是形参名
     * defaultValue 表示默认值
     * required 表示是否必须拥有这个参数
     */
    @RequestMapping("/quick13")
    @ResponseBody
    public user save13(@RequestParam(value = "Name", defaultValue = "刘德华") String name,
                       @RequestParam(value = "Age", defaultValue = "18", required = false) int age)
            throws JsonProcessingException {
        user User = new user();
        User.setAge(age);
        User.setName(name);
        return User;
    }

    @RequestMapping("/quick14")
    @ResponseBody
    public user save14(user User) throws JsonProcessingException {
        return User;
    }

    @RequestMapping("/quick15")
    @ResponseBody
    public String[] save15(String[] strs) throws JsonProcessingException {
        return strs;
    }

    @RequestMapping("/quick16")
    @ResponseBody
    public VO save16(VO vo) throws JsonProcessingException {
        return vo;
    }

    /**
     * Restful 风格，将参数封装url
     *
     * @param name 请求的name
     * @param age  请求的age
     * @return 返回对应的字符串
     * @throws JsonProcessingException
     */
    @RequestMapping(value = "/quick17/{name}/{age}", method = RequestMethod.GET)
    @ResponseBody
    public String save17(@PathVariable(value = "name") String name, @PathVariable("age") int age) throws JsonProcessingException {
        return name + age;
    }

    /**
     * 配置类型转换器，转换日期类型
     *
     * @param date 传入的数据通过类型转换器转换为日期
     * @return 返回日期string
     * @throws JsonProcessingException
     */
    @RequestMapping(value = "/quick18", method = RequestMethod.GET)
    @ResponseBody
    public String save18(Date date) throws JsonProcessingException {
        return date.toString();
    }

    /**
     * 获取请求头传入指定的形参
     *
     * @param str 用于存放请RequestHeader指定的请求头求头
     * @return 返回请求头数据
     */
    @RequestMapping(value = "/quick19", method = RequestMethod.GET)
    @ResponseBody
    public String save19(@RequestHeader(value = "user-agent", required = false) String str, HttpSession httpSession) {
        return str + '\n' + httpSession.toString();
    }

    /**
     * 尝试获取Cookie的值，获取指定Cookie里的JSESSIONID的值
     *
     * @param cookie 返回获得的Cookie的值
     * @return 交由Mvc控制器回写Cookie数据
     */
    @RequestMapping(value = "/quick20", method = RequestMethod.GET)
    @ResponseBody
    public String save20(@CookieValue(value = "JSESSIONID") String cookie) {
        return cookie;
    }


    @RequestMapping(value = "/quick21", method = RequestMethod.POST)
    @ResponseBody
    public String save21(String name, MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String contentType = file.getContentType();
        file.transferTo(new File("C://" + originalFilename));
        return originalFilename + ":" + contentType;
    }
}
