package com.study.est_spring.day0701.ep02;

public class EmailSenderApplication {
    public static void main(String[] args) {
        EmailService emailService1 = new EmailService(new SmtpEmailSender());
        EmailService emailService2 = new EmailService(new AwsSesEmailSender());
    }
}
