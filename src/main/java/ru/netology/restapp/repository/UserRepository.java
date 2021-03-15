package ru.netology.restapp.repository;

import org.springframework.stereotype.Repository;
import ru.netology.restapp.model.Authorities;
import ru.netology.restapp.model.User;

import java.util.*;

@Repository
public class UserRepository {

    Set<User> users;

    public UserRepository() {
        this.users = new HashSet<>();
        List<Authorities> authorities = new ArrayList<>();
        authorities.add(Authorities.DELETE);
        authorities.add(Authorities.WRITE);
        User user = new User(0L, "test", "test", authorities);
        users.add(user);
    }

    public List<Authorities> getUserAuthorities(String userName, String password) {

        for (User user : users) {
            if (user.getUser().equals(userName) && (user.getPassword().equals(password))) {
                return user.getAuthorities();
            }
        }
        return new ArrayList<>();
    }
}
