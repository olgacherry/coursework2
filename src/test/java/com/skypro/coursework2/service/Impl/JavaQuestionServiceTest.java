package com.skypro.coursework2.service.Impl;

import com.skypro.coursework2.model.Question;
import com.skypro.coursework2.model.service.Impl.JavaQuestionService;
import com.skypro.coursework2.model.service.QuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;

public class JavaQuestionServiceTest {
    private final QuestionService questionService = new JavaQuestionService();
@Test
    public void shouldCorrectlyAddNewQuestion(){
    Question question = new Question("question","answer");
    Question addedQuestion= questionService.add(question);
    Assertions.assertEquals(question,addedQuestion);
}
@Test
    public void shouldReturnAllExistedQuestions(){
    Question question = new Question("question","answer");
    Collection<Question>all=questionService.getAll();
    Assertions.assertEquals(all.size(),1);
}



}
