package ru.netology.dao_hibernate.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.netology.dao_hibernate.models.Person;
import ru.netology.dao_hibernate.repository.DaoRepo;

import java.util.List;
import java.util.Optional;

@Service
public class DAOService {

    private DaoRepo daoRepo;

    public DAOService(DaoRepo daoRepo) {
        this.daoRepo = daoRepo;
    }

    public List<Person> getAll() {
        return daoRepo.findAll();
    }

    public List<Person> getPersonByCity(String city) {
        return daoRepo.findAllByCity(city);
    }

    public List<Person> getPersonByAge(int age) {
        return daoRepo.findAllByAgeIsLessThanOrderByAgeDesc(age);
    }

    public Person getPersonByNameAndSurname(String name, String surname) {
        return daoRepo.findAllByNameAndSurname(name, surname).orElseThrow();
    }


}
