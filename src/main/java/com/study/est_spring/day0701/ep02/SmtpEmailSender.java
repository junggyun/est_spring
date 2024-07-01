package com.study.est_spring.day0701.ep02;

public class SmtpEmailSender implements EmailSender {
    @Override
    public void sendEmail(String to, String subject, String body) {
        // SMTP를 사용하여 이메일 발송
        // ...
    }
}
