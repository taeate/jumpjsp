package com.exam.jumpjsp.demo.sbb.Question;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.exam.jumpjsp.demo.sbb.DataNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final ModelMapper modelMapper;

    private QuestionDto of(Question question) {

        return modelMapper.map(question, QuestionDto.class);
    }

    public List<QuestionDto> getList() {

        List<Question> questionList = this.questionRepository.findAll();

        List<QuestionDto> questionDtoList = questionList.stream().map(q -> of(q)).collect(Collectors.toList());

        return questionDtoList;
    }

    public Question getQuestion(Integer id) {

        Optional<Question> question = this.questionRepository.findById(id);

        if (question.isPresent()) {
            return question.get();
        } else {
            throw new DataNotFoundException("찾을수없습니다.");
        }

    }

    public Page<Question> getList(int page) {

        Pageable pageable = PageRequest.of(page, 10);

        return this.questionRepository.findAll(pageable);
    }
}
