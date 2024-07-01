package com.study.est_spring.day0701.ep04;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        Quiz quiz = new Quiz("MVC 패턴의 M은 무엇의 약자인가요?", "Model");
        QuizView quizView = new QuizView();
        QuizController quizController = new QuizController(quiz, quizView);

        quizController.startQuiz();
    }
}
