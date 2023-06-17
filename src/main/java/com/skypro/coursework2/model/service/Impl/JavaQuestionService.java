package com.skypro.coursework2.model.service.Impl;

import com.skypro.coursework2.model.Question;
import com.skypro.coursework2.model.service.QuestionService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final Set<Question>questions=new HashSet<>();
    private final Random random = new Random();
    @PostConstruct
    public void initQuestions(){
        questions.add(new Question("Массив - это ссылочный тип данных или примитивный?","Ссылочный"));
        questions.add(new Question("Как называется тип данных для хранения символов?","char/Character"));
        questions.add(new Question("Сколько возможных значений у boolean?","Два - true/false"));
        questions.add(new Question("Какая асимптотическая сложность у алгоритма бинарного поиска?", "O(log2N)"));
        questions.add(new Question("Какие типы исключений бывают?","Проверяемые/непроверяемые"));
    }


    @Override
    public Question add(String questionText, String answer) {
        return add(new Question(questionText, answer));

    }

    @Override
    public Question add(Question question) {
        question.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        question.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return new HashSet<>(questions);
    }

    @Override
    public Question getRandomQuestion() {
        int randomIndex = random.nextInt(questions.size());
        return (new ArrayList<>(questions)).get(randomIndex);

    }
}
