package com.skypro.coursework2.controller;

import com.skypro.coursework2.model.Question;
import com.skypro.coursework2.model.service.ExaminerService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }
    @GetMapping("/get{amount}")
    public Collection<Question>getQuestions(@PathVariable int amount){
        return examinerService.getQuestions(amount);
    }
}

