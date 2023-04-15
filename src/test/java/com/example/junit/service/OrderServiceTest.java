package com.example.junit.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.example.junit.util.mail.MailSender;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * 만들어야하는 기능을 미리 목킹하여 테스트부터 미리 만들 수 있음
 *
 * 이 경우, 추후에 기능을 구현해 나갈때 stubbing된 부분을 실제 로직으로 치환하여 기능 구현할 수 있음
 */

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @InjectMocks
    OrderService orderService;

    @Mock
    MailSender mailSender;

    @Test
    void 주문시_메일전송에_성공하면_true_리턴한다() {

        //given
        String userEmail = "test@test.com";

        //stub
        when(mailSender.send(any())).thenReturn(true);

        //when
        boolean result = orderService.order(userEmail);

        //then
        assertThat(result).isEqualTo(true);
    }

    @Test
    void 주문시_메일전송에_실패하면_false_리턴한다() {

        //given
        String userEmail = "test@test.com";

        //stub
        when(mailSender.send(any())).thenReturn(false);

        //when
        boolean result = orderService.order(userEmail);

        //then
        assertThat(result).isEqualTo(false);
    }


}