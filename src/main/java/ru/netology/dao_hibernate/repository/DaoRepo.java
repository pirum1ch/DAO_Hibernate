package ru.netology.dao_hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.netology.dao_hibernate.models.Person;

import java.util.List;
import java.util.Optional;

public interface DaoRepo extends JpaRepository<Person, Long> {

    List<Person> findAllByCity(String city);

//    @Query(value = "select Person from Person where city = :city")
//    List<Person> findAllByCity(String city);

    List<Person> findAllByAgeIsLessThanOrderByAgeDesc(int age);

    Optional<Person> findAllByNameAndSurname(String name, String surname);
}
