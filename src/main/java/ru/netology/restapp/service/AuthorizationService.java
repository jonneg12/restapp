package ru.netology.restapp.service;


import org.springframework.stereotype.Service;
import ru.netology.restapp.excetions.InvalidCredentials;
import ru.netology.restapp.excetions.UnauthorizedUser;
import ru.netology.restapp.model.Authorities;
import ru.netology.restapp.repository.UserRepository;

import java.util.List;

@Service
public class AuthorizationService {
    private UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(String user, String password) {

        if(isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty!");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if(isEmpty(userAuthorities)) {
            System.out.println("UnauthorizedUser");
            throw new UnauthorizedUser("Unknown user " + user + " or wrong password!");
        }
        return userAuthorities;
    }

    private boolean isEmpty(String string) {
        return string == null || string.isEmpty();
    }

    private boolean isEmpty(List<?> list) {
        return list == null || list.isEmpty();
    }

}
