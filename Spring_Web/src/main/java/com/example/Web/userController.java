package com.example.Web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class userController {

    @RequestMapping("/quick")
    public String save() {
        return "success.jsp";
    }
    @RequestMapping("/quick1")
    public String save1() {
        return "Spring_web1";
    }
}
