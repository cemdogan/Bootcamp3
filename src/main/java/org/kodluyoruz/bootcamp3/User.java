package org.kodluyoruz.bootcamp3;

public class User {
    private boolean isAdmin;
    private String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
