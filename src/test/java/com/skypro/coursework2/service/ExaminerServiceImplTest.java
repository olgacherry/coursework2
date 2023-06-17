package com.skypro.coursework2.service;

import com.skypro.coursework2.model.Question;
import com.skypro.coursework2.model.service.ExaminerService;
import com.skypro.coursework2.model.service.Impl.ExaminerServiceImpl;
import com.skypro.coursework2.model.service.Impl.JavaQuestionService;
import com.skypro.coursework2.model.service.QuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    private JavaQuestionService questionService;
    @InjectMocks
    private ExaminerServiceImpl examinerService;
    @Test
    public void shouldCollectRandomQuestions(){
        int amount = 3;
        Set<Question> questions = new HashSet<>();
        questions.add(new Question("Массив - это ссылочный тип данных или примитивный?","Ссылочный"));
        questions.add(new Question("Как называется тип данных для хранения символов?","char/Character"));
        questions.add(new Question("Сколько возможных значений у boolean?","Два - true/false"));
        questions.add(new Question("Какая асимптотическая сложность у алгоритма бинарного поиска?", "O(log2N)"));
        questions.add(new Question("Какие типы исключений бывают?","Проверяемые/непроверяемые"));
        List<Question> questionList= new ArrayList<>(questions);
        given(questionService.getAll()).willReturn(questions);
        given(questionService.getRandomQuestion()).willReturn(questionList.get(0),questionList.get(1),questionList.get(2));
        Collection<Question>actualRandomQuestions=examinerService.getQuestions(amount);
        Assertions.assertEquals(new HashSet<>(List.of(questionList.get(0),questionList.get(1),questionList.get(2))),actualRandomQuestions);
    }
}
