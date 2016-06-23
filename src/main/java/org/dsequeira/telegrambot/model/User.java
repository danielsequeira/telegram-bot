package org.dsequeira.telegrambot.model;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author daniel.sequeira
 */
public class User {

    private Integer id;
    @SerializedName(value = "first_name")
    private String firstName;
    @SerializedName(value = "last_name")
    private String lastName;
    private String username;

    public User() { }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName
                + ", username=" + username + "]";
    }
}
