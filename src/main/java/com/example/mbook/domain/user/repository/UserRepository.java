package com.example.mbook.domain.user.repository;

import com.example.mbook.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);

    boolean existsByNickName(String nickName);

    Optional<User> findUserByNickName(String nickName);

    Optional<User> findUserByEmail(String email);
}
