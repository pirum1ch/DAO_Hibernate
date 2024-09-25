package ru.netology.dao_hibernate.controllers;


import jakarta.annotation.security.RolesAllowed;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.dao_hibernate.services.DAOService;

@RestController("/secured")

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
    public String read(@RequestParam("city") String city) {
        return daoService.getPersonByCity(city).toString();
    }

    /*
    один из методов возвращает значения только для пользователей с ролью "WRITE" (используйте @RolesAllowed);
     */
    @GetMapping("/WRITE")
    @RolesAllowed("ROLE_WRITE")
    public String write(@RequestParam("age") int age) {
        return daoService.getPersonByAge(age).toString();
    }

    /*
    один из методов возвращает значения, если у пользователя есть хотя бы одна из ролей из "WRITE", "DELETE" (используйте pre/post аннотации);
     */
    @GetMapping("/rd")
    @PreAuthorize("hasRole('ROLE_WRITE') or hasRole('ROLE_DELETE')")
    public String readDelete(@RequestParam("age") int age) {
        return daoService.getPersonByAge(age).toString();
    }

    /*
    один из методов, который принимает в качестве query-параметра имя пользователя (username),
    должен возвращает значения, только если у пользователя username совпадает с именем пользователя в вашем объекте Authentication,
    который Spring security сохраняет в SecurityContextHolder после успешной аутентификации.
     */
    @GetMapping("/equals")
    @PreAuthorize("#surname == authentication.principal.surname")
    public String equalsUsername(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return daoService.getPersonByNameAndSurname(name, surname).toString();
    }

}
