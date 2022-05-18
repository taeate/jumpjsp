package com.exam.jumpjsp.demo.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @RequestMapping("/main")
    @ResponseBody
    public String showMain() {
        return "hi";
    }

    @RequestMapping("/")
    public String showRoot() {
        return "fragments/main";
    }
}
