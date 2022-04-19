package com.exam.jumpjsp.demo.sbb.Question;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class QuestionController {

    @RequestMapping("/question/list")
    @ResponseBody
    public String showList() {
        return "question List";
    }
}
