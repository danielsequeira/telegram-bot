package org.dsequeira.telegrambot.response;

import java.util.List;

import org.dsequeira.telegrambot.model.Update;

/**
 *
 * @author daniel.sequeira
 */
public class UpdatesResponse {

    private boolean ok;
    private List<Update> result;

    public UpdatesResponse() { }

    public boolean isOk() {
        return ok;
    }

    public List<Update> getUpdates() {
        return result;
    }
}
