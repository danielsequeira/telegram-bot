package org.dsequeira.telegrambot.response;

import org.dsequeira.telegrambot.model.User;

/**
 *
 * @author daniel.sequeira
 */
public class UserResponse {

    private boolean ok;
    private User result;

    public UserResponse() { }

    public boolean isOk() {
        return ok;
    }

    public User getUser() {
        return result;
    }
}
