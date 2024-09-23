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
    public String personByCity(@RequestParam("city") String city) {
        return daoService.getPersonByCity(city).toString();
    }

    @GetMapping("/by-age")
    public String personByAge(@RequestParam("age") int age) {
        return daoService.getPersonByAge(age).toString();
    }

    @GetMapping("/by-name-surname")
    public String personByAge(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return daoService.getPersonByNameAndSurname(name, surname).toString();
    }
}
