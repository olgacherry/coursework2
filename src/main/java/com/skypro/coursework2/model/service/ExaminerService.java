package com.skypro.coursework2.model.service;

import com.skypro.coursework2.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question>getQuestions(int amount);
}
