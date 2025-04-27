package org.example.services;

import lombok.RequiredArgsConstructor;
import org.example.models.entities.AnswererEntity;
import org.example.repositories.AnswererRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnswererService {

    private final AnswererRepository answererRepository;

    public List<AnswererEntity> getAnswerers() {
        return answererRepository.findAll();
    }

    public AnswererEntity createAnswerer(AnswererEntity answerer) {
        return answererRepository.save(answerer);
    }
}
