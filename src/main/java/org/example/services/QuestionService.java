package org.example.services;

import lombok.RequiredArgsConstructor;
import org.example.models.entities.QuestionEntity;
import org.example.repositories.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    public List<QuestionEntity> getQuestions() {
        return questionRepository.findAll();
    }

    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }

    public QuestionEntity createQuestion(QuestionEntity question) {
        return questionRepository.save(question);
    }

    public QuestionEntity changeQuestion(Long id, QuestionEntity question) {
        QuestionEntity questionEntity = questionRepository.findById(id).orElseThrow();
        questionEntity.setQuestion(question.getQuestion());
        questionEntity.setType(question.getType());
        questionEntity.setGroup(question.getGroup());
        questionEntity.setCreateTime(question.getCreateTime());
        questionEntity.setVariants(question.getVariants());
        return questionRepository.save(questionEntity);
    }
}
