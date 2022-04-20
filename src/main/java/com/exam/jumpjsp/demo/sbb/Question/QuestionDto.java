package com.exam.jumpjsp.demo.sbb.Question;

import java.time.LocalDateTime;
import java.util.List;

import com.exam.jumpjsp.demo.sbb.Answer.AnswerDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionDto {
    private Integer id;
    private String subject;
    private String content;
    private LocalDateTime createDate;
    private List<AnswerDto> answerList;
}
