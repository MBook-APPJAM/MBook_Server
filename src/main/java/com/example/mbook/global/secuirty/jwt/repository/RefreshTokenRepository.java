package com.example.mbook.global.secuirty.jwt.repository;

import com.example.mbook.global.secuirty.jwt.entity.RefreshToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
    boolean existsByEmail(String email);
}
