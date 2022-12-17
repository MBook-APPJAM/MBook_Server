package com.example.mbook.domain.user.entity;

import com.example.mbook.global.mail.entity.Mail;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nickName;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Mail> mails;

    @Builder
    public User(String nickName, String email, String password){
        this.nickName = nickName;
        this.email = email;
        this.password = password;
        this.role = Role.ROLE_USER;
    }

    public void setUser(String nickName){
        this.nickName = nickName;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
