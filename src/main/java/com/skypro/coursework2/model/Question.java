package com.skypro.coursework2.model;

import java.util.Objects;

public class Question {
    private final String questionText;
    private final String answer;

    public Question(String questionText, String answer) {
        this.questionText = questionText;
        this.answer = answer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question question1)) return false;
        return Objects.equals(questionText, question1.questionText) && Objects.equals(answer, question1.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionText, answer);
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + questionText + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }

    public void add(Question question) {
    }

    public void remove(Question question) {
    }
}
