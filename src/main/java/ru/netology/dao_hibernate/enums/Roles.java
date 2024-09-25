package ru.netology.dao_hibernate.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Roles implements GrantedAuthority {
    ROLE_READ, ROLE_WRITE, ROLE_DELETE;

    @Override
    public String getAuthority() {
        return name();
    }

}
