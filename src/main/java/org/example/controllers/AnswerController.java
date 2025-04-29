package org.example.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.models.dtos.AnswerDto;
import org.example.models.entities.AnswerEntity;
import org.example.services.AnswerService;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin
@RequiredArgsConstructor
@RestController("answer")
@RequestMapping("answer")
public class AnswerController {

    private final AnswerService answerService;

    @PostMapping("create")
    public AnswerEntity create(@RequestBody AnswerDto answer) {
        return answerService.createAnswer(answer);
    }
}
