package ru.akhramova.task_9_2.service;

import org.springframework.stereotype.Service;
import ru.akhramova.task_9_2.enums.Authorities;
import ru.akhramova.task_9_2.exception.InvalidCredentials;
import ru.akhramova.task_9_2.exception.UnauthorizedUser;
import ru.akhramova.task_9_2.model.User;
import ru.akhramova.task_9_2.repository.UserRepository;

import java.util.List;

@Service
public class AuthorizationService {
    UserRepository userRepository = new UserRepository();

    public List<Authorities> getAuthorities(User user) {
        if (user == null) {
            throw new InvalidCredentials("User is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
