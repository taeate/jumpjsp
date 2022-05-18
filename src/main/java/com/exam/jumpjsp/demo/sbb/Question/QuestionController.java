package com.exam.jumpjsp.demo.sbb.Question;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/article")
@Controller
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/list")
    public String showList(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {

        Page<Question> questionList = questionService.getList(page);

        model.addAttribute("questionList", questionList);

        return "question/list";
    }

    @GetMapping("/create")
    public String showWrite(){
        return "question_form";
    }


    @GetMapping("/question/detail/{id}")
    public String showDetail(Model model, @PathVariable("id") Integer id) {

        Question question = this.questionService.getQuestion(id);

        model.addAttribute("question", question);
        return "question/detail";
    }

}
