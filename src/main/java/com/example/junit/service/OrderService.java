package com.example.junit.service;

import com.example.junit.util.mail.MailSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final MailSender mailSender;

    public boolean order(String email) {

        //기타 로직 수행

        if (!mailSender.send(email)) {
            log.error("### 메일전송 실패. 유저 이메일 주소 ={}", email);
            return false;
        }
        return true;
    }
}
