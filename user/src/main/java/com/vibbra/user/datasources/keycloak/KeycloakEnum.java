package com.vibbra.user.datasources.keycloak;

public enum KeycloakEnum {

    ADMIN_USERNAME("admin"),
    ADMIN_PASSWORD("admin"),
    GRANT_TYPE("password"),
    CLIENT_ID_ADMIN("admin-cli"),
    CLIENT_ID_CLIENTES("teste"),
    TOKEN_BEARER("Bearer ");

    String value;

    KeycloakEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
