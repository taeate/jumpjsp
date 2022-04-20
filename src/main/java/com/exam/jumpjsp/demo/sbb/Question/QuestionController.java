package com.exam.jumpjsp.demo.sbb.Question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/article")
@Controller
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/list")
    public String showList(Model model) {

        List<QuestionDto> questionList = this.questionService.getList();
        model.addAttribute("questionList", questionList);

        return "question/list";
    }
}
