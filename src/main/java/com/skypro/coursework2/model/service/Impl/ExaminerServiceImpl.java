package com.skypro.coursework2.model.service.Impl;

import com.skypro.coursework2.exception.NotEnoughQuestionsInStorageException;
import com.skypro.coursework2.model.Question;
import com.skypro.coursework2.model.service.ExaminerService;
import com.skypro.coursework2.model.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        int size = questionService.getAll().size();
        if(amount>size) {
            throw new NotEnoughQuestionsInStorageException();
        }
        Set<Question> questions = new HashSet<>();
        while (questions.size()<amount){
            Question randomQuestion = questionService.getRandomQuestion();
            questions.add(randomQuestion);
        }
        return questions;
    }
}
