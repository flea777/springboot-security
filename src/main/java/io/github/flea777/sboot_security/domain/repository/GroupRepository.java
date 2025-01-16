package io.github.flea777.sboot_security.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.flea777.sboot_security.domain.entity.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, String> {

    Optional<Group> findByName(String name);
}
