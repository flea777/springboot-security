package io.github.flea777.sboot_security.api.dto;

import io.github.flea777.sboot_security.domain.entity.User;
import lombok.Data;
import java.util.List;

@Data
public class UserRegisterDTO {

    private User user;
    private List<String> permissions;

}
