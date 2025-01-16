package io.github.flea777.sboot_security.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.flea777.sboot_security.api.dto.UserRegisterDTO;
import io.github.flea777.sboot_security.domain.entity.User;
import io.github.flea777.sboot_security.domain.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping
    public ResponseEntity<User> save(@RequestBody UserRegisterDTO dto) {
        User result = service.save(dto.getUser(), dto.getPermissions());
        
        return ResponseEntity.ok(result);
    }
    

}
