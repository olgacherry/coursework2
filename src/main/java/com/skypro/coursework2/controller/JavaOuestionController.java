package com.skypro.coursework2.controller;

import com.skypro.coursework2.model.Question;
import com.skypro.coursework2.model.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaOuestionController {
    private final QuestionService questionService;

    public JavaOuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }
    @GetMapping
public Collection<Question> getAll(){
        return questionService.getAll();
}
@GetMapping("/add")
public Question add(@RequestParam String questionText,@RequestParam String answer){
        return questionService.add(questionText,answer);
    }
    @GetMapping("/remove")
    public Question remove(@RequestParam String questionText,@RequestParam String answer){
        return questionService.remove(new Question(questionText,answer));
    }


}
