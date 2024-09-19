package ru.netology.dao_hibernate.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.netology.dao_hibernate.models.Person;

import java.util.List;


@Repository
public class Repo {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> getPersonByCity(String city) {
        return entityManager.createQuery("select id,age,city_of_living,name,phone_number,surname from Person where city_of_living ILIKE :city").setParameter("city", city).getResultList();
    }
}
