package com.study.est_spring.day0701.ep04;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class QuizController {
    private Quiz model;
    private QuizView view;

    public void startQuiz() {
        view.displayQuestion(model.getQuestion());
        String userAnswer = view.getUserAnswer();
        boolean isCorrect = checkAnswer(userAnswer);
        view.displayResult(isCorrect);
    }

    private boolean checkAnswer(String userAnswer) {
        return model.getAnswer().equalsIgnoreCase(userAnswer);
    }
}
