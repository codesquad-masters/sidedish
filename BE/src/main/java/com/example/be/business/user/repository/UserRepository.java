package com.example.be.business.user.repository;

import com.example.be.business.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByGithubId(String email);
}
