package io.github.flea777.sboot_security.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import io.github.flea777.sboot_security.domain.entity.Group;
import io.github.flea777.sboot_security.domain.entity.User;
import io.github.flea777.sboot_security.domain.entity.UserGroup;
import io.github.flea777.sboot_security.domain.repository.GroupRepository;
import io.github.flea777.sboot_security.domain.repository.UserRepository;
import io.github.flea777.sboot_security.domain.repository.UserGroupRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final GroupRepository groupRepository;
    private final UserGroupRepository userGroupRepository;
    
    public User save(User user, List<String> groups) {
        repository.save(user);

        List<UserGroup> list = groups.stream().map(groupName -> {
            Optional<Group> possibleGroup =  groupRepository.findByName(groupName);
            if(possibleGroup.isPresent()) {
                Group group = possibleGroup.get();
                return new UserGroup(user, group);
            }
            return null;
        })
        .filter(group -> group != null)
        .collect(Collectors.toList());
        userGroupRepository.saveAll(list);

        return user;
    }
}