package ru.netology.dao_hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.netology.dao_hibernate.models.User;

public interface UserRepo extends JpaRepository<User, Long> {

    User findByLogin(String login);

}
