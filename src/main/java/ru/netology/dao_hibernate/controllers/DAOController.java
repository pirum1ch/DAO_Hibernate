package ru.netology.dao_hibernate.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.dao_hibernate.models.Person;
import ru.netology.dao_hibernate.services.DAOService;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class DAOController {

    private final DAOService daoService;

    public DAOController(DAOService daoService) {
        this.daoService = daoService;
    }

    @GetMapping("/by-city")
    public List<Person> personByCity(@RequestParam("city") String city) {
        return daoService.getPersonByCity(city);
    }


}
