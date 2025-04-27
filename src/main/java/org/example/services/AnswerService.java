package org.example.services;

import lombok.RequiredArgsConstructor;
import org.example.models.entities.AnswerEntity;
import org.example.repositories.AnswerRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;

    public AnswerEntity createAnswer(AnswerEntity answer) {
        return answerRepository.save(answer);
    }
}
