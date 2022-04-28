package com.exam.jumpjsp.demo.sbb.Question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping("/question/detail/{id}")
    public String showDetail(Model model, @PathVariable("id") Integer id) {

        Question question = this.questionService.getQuestion(id);

        model.addAttribute("question", question);
        return "question/detail";
    }
}
