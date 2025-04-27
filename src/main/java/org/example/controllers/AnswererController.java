package org.example.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.models.entities.AnswererEntity;
import org.example.services.AnswererService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin
@RequiredArgsConstructor
@RestController("answerer")
@RequestMapping("answerer")
public class AnswererController {

    private final AnswererService answererService;

    @GetMapping("list")
    public List<AnswererEntity> getAnswerers() {
        return answererService.getAnswerers();
    }

    @PostMapping("create")
    public AnswererEntity create(@RequestBody AnswererEntity answer) {
        return answererService.createAnswerer(answer);
    }
}
