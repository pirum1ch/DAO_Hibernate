package ru.netology.dao_hibernate.controllers;


import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.netology.dao_hibernate.models.Person;
import ru.netology.dao_hibernate.services.DAOService;

import java.util.List;

@RestController
@RequestMapping("/secured")
public class SecuredController {

    DAOService daoService;

    public SecuredController(DAOService daoService) {
        this.daoService = daoService;
    }

    /*
    один из методов возвращает значения только для пользователей с ролью "READ" (используйте @Secured);
     */
    @GetMapping("/read")
    @Secured("ROLE_READ")
    public List<Person> read(@RequestParam("city") String city) {
        return daoService.getPersonByCity(city);
    }

    /*
    один из методов возвращает значения только для пользователей с ролью "WRITE" (используйте @RolesAllowed);
     */
    @GetMapping("/write")
    @RolesAllowed("ROLE_WRITE")
    public List<Person> write(@RequestParam("age") int age) {
        return daoService.getPersonByAge(age);
    }

    /*
    один из методов возвращает значения, если у пользователя есть хотя бы одна из ролей из "WRITE", "DELETE" (используйте pre/post аннотации);
     */
    @GetMapping("/rd")
    @PreAuthorize("hasRole('ROLE_WRITE') or hasRole('ROLE_DELETE')")
    public List<Person> readDelete(@RequestParam("age") int age) {
        return daoService.getPersonByAge(age);
    }

    /*
    один из методов, который принимает в качестве query-параметра имя пользователя (username),
    должен возвращает значения, только если у пользователя username совпадает с именем пользователя в вашем объекте Authentication,
    который Spring security сохраняет в SecurityContextHolder после успешной аутентификации.
     */
    @GetMapping("/equals")
    @PreAuthorize("#surname == authentication.principal.surname")
    public Person equalsUsername(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return daoService.getPersonByNameAndSurname(name, surname);
    }
}
