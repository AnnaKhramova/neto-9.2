package ru.akhramova.task_9_2.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import ru.akhramova.task_9_2.enums.Authorities;
import ru.akhramova.task_9_2.model.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    @Value("${user.name}")
    private String name;
    @Value("${user.password}")
    private String password;

    private User authorized;

    public UserRepository() {
        authorized = new User(name, password);
    }

    public List<Authorities> getUserAuthorities(User user) {
        List<Authorities> authorities = new ArrayList<>();
        if (authorized.equals(user)) {
            authorities.add(Authorities.READ);
            authorities.add(Authorities.WRITE);
            authorities.add(Authorities.DELETE);
        }
        return authorities;
    }
}
