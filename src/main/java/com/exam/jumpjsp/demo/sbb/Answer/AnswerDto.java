package com.exam.jumpjsp.demo.sbb.Answer;

import java.time.LocalDateTime;

import com.exam.jumpjsp.demo.sbb.Question.QuestionDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerDto {
    private Integer id;
    private String content;
    private LocalDateTime createDate;
    private QuestionDto question;
}
