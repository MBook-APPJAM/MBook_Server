package com.example.mbook.global.mail.repository;

import com.example.mbook.global.mail.entity.Mail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MailRepository extends JpaRepository<Mail, Long> {
    Optional<Mail> findMailByCode(String code);
    Optional<Mail> findMailByEmail(String email);
}
