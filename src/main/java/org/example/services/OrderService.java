package org.example.services;

import lombok.RequiredArgsConstructor;
import org.example.models.entities.AnswerEntity;
import org.example.repositories.AnswerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final AnswerRepository answerRepository;

    public List<AnswerEntity> getOrders() {
        return answerRepository.findAll();
    }
}
