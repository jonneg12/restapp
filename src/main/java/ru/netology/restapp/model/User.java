package ru.netology.restapp.model;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@Setter
@Getter
@RequiredArgsConstructor
public class User {

    private Long id;
    private String user;
    private String password;
    private List<Authorities> authorities;

    public User(Long id, String user, String password, List<Authorities> authorities) {
        this.id = id;
        this.user = user;
        this.password = password;
        this.authorities = authorities;
    }
}

