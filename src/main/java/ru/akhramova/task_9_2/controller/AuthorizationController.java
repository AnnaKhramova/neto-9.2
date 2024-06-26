package ru.akhramova.task_9_2.controller;

import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.akhramova.task_9_2.enums.Authorities;
import ru.akhramova.task_9_2.model.User;
import ru.akhramova.task_9_2.service.AuthorizationService;

import java.util.List;

@Validated
@RestController
public class AuthorizationController {
    private final AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid User user) {
        return service.getAuthorities(user);
    }
}
