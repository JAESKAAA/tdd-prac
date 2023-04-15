package com.example.junit.util.mail;

import org.springframework.stereotype.Component;

@Component
public class MailSenderAdapter implements MailSender{

    private final Mail mail;

    public MailSenderAdapter(Mail mail) {
        this.mail = mail;
    }

    @Override
    public boolean send(String email) {
        return this.mail.sendMail(email);
    }
}
