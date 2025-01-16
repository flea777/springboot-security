package io.github.flea777.sboot_security.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.flea777.sboot_security.domain.entity.UserGroup;;

public interface UserGroupRepository extends JpaRepository<UserGroup, String> {

}
