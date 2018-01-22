package pl.wrryy.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.wrryy.entity.User;
import pl.wrryy.repository.UserRepository;

public class UserConverter implements Converter<String, User> {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User convert(String source) {
        User user = userRepository.findOne(Integer.parseInt(source));
        return user;
    }
}

