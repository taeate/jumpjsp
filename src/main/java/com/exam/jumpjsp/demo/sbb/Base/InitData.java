package com.exam.jumpjsp.demo.sbb.Base;

import java.time.LocalDateTime;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.exam.jumpjsp.demo.sbb.Question.Question;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Profile("local")
@Component
@RequiredArgsConstructor
public class InitData {

    private final InitMemberService initMemberService;

    @PostConstruct
    public void init() {
        initMemberService.init();
    }

    @Component
    static class InitMemberService {

        @PersistenceContext
        private EntityManager em;

        @Transactional
        public void init() {

            for (int i = 0; i < 200; i++) {

                Question q1 = new Question();
                q1.setSubject("테스트 게시물");
                q1.setContent("sbb에 대해서 알고 싶습니다.");
                q1.setCreateDate(LocalDateTime.now());
                em.persist(q1);

            }
        }
    }
}