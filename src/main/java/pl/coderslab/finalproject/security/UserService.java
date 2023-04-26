package pl.coderslab.finalproject.security;

import pl.coderslab.finalproject.security.user.User;

import java.util.Arrays;
import java.util.HashSet;

public interface UserService {

    User findByUserName(String name);

    void saveUser(User user);


}