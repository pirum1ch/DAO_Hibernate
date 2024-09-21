package ru.netology.dao_hibernate.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.netology.dao_hibernate.models.User;
import ru.netology.dao_hibernate.repository.UserRepo;

@Service
public class CustomUserDetailService implements UserDetailsService {

    public CustomUserDetailService(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    private final UserRepo userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(login);
        if (user == null) {
            throw new UsernameNotFoundException("Такого пользователя нет");
        } else {
            return user;
        }
    }
}
