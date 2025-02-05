package org.qa.automation.userCredentials;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TestUser {

    LOGIN_TEST_USER(new String[]{"standard_user", "secret_sauce"});
    private final String[] value;

    public String getUsername() {
        return this.value[0];
    }

    public String getPassword() {
        return this.value[1];
    }
}
