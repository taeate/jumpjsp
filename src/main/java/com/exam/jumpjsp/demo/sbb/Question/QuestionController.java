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

    private final QuestionRepository questionRepository;

    @GetMapping("/list")
    public String showList(Model model) {

        List<Question> questionList = this.questionRepository.findAll();
        model.addAttribute("questionList", questionList);

        return "question/list";
    }
}
