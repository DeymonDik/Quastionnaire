package org.example.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.models.entities.QuestionEntity;
import org.example.services.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin
@RequiredArgsConstructor
@RestController("question")
@RequestMapping("question")
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("list")
    public List<QuestionEntity> getQuestions() {
        return questionService.getQuestions();
    }

    @PostMapping("create")
    public QuestionEntity create(@RequestBody QuestionEntity question) {
        return questionService.createQuestion(question);
    }

    @PutMapping("change")
    public QuestionEntity change(@RequestParam("id") Long id, @RequestBody QuestionEntity question) {
        return questionService.changeQuestion(id, question);
    }

    @DeleteMapping("delete")
    public void delete(@RequestParam("id") Long id) {
        questionService.deleteQuestion(id);
    }
}
