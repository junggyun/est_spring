package com.study.est_spring.day0701.ep04;

import java.util.Scanner;

public class QuizView {
    public void displayQuestion(String question) {
        System.out.println("Question: " + question);
    }

    public String getUserAnswer() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Answer: ");
        String answer = sc.nextLine();

        sc.close();

        return answer;
    }

    public void displayResult(boolean isCorrect) {
        System.out.println(isCorrect ? "정답입니다." : "오답입니다.");
    }
}
