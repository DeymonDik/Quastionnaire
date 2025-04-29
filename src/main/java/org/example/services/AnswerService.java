package org.example.services;

import lombok.RequiredArgsConstructor;
import org.example.models.dtos.AnswerDto;
import org.example.models.entities.AnswerEntity;
import org.example.models.entities.AnswererEntity;
import org.example.models.entities.QuestionEntity;
import org.example.models.entities.VariantEntity;
import org.example.repositories.AnswerRepository;
import org.example.repositories.AnswererRepository;
import org.example.repositories.QuestionRepository;
import org.example.repositories.VariantRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;
    private final AnswererRepository answererRepository;
    private final QuestionRepository questionRepository;
    private final VariantRepository variantRepository;

    public AnswerEntity createAnswer(AnswerDto answer) {
        AnswerEntity answerEntity = new AnswerEntity();
        Set<VariantEntity> variantsToSave = new HashSet<>();
        for (VariantEntity variant : answer.getAnswers()) {
            VariantEntity variantFromDB = variantRepository.findById(variant.getId()).orElse(null);
            variantsToSave.add(Objects.requireNonNullElse(variantFromDB, variant));
        }
        answerEntity.setAnswers(variantsToSave);
        answerEntity.setCreateDate(Objects.requireNonNullElse(answer.getCreateTime(), LocalDateTime.now()));
        AnswererEntity answerer = answererRepository.findById(answer.getAnswererId()).orElse(null);
        answerEntity.setAnswerer(answerer);
        answerEntity.setAnswer(answer.getAnswer());
        QuestionEntity question = questionRepository.findById(answer.getQuestionId()).orElse(null);
        answerEntity.setQuestion(question);
        return answerRepository.save(answerEntity);
    }
}
