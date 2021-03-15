package ru.netology.restapp.controller;

import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.restapp.model.Authorities;
import ru.netology.restapp.service.AuthorizationService;

import java.util.List;

@RestController
@RequestMapping("/authorize")
public class AuthorizationController {
    private AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping()
    public List<Authorities> getAuthorities(@RequestParam("user") @Nullable String user,
                                            @RequestParam("password") @Nullable String password) {
        return service.getAuthorities(user, password);
    }
}
