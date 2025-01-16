package io.github.flea777.sboot_security.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.flea777.sboot_security.domain.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

}
