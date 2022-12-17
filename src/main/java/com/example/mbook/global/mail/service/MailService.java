package com.example.mbook.global.mail.service;

import com.example.mbook.global.mail.dto.MailRequest;

public interface MailService {
    void mailSend(MailRequest request, String nickName)throws Exception;

    void signMailSend(MailRequest request)throws Exception;
}
