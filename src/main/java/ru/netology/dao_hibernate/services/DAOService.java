package ru.netology.dao_hibernate.services;

import org.springframework.stereotype.Service;
import ru.netology.dao_hibernate.models.Person;
import ru.netology.dao_hibernate.repository.Repo;

import java.util.List;

@Service
public class DAOService {

    private Repo repo;

    public DAOService(Repo repo) {
        this.repo = repo;
    }

    public List<Person> getPersonByCity(String city) {
        return repo.getPersonByCity(city);
    }
}
