package org.dsequeira.telegrambot.response;

import org.dsequeira.telegrambot.model.Message;

/**
 *
 * @author daniel.sequeira
 */
public class MessageResponse {

    private boolean ok;
    private Message result;

    public MessageResponse() { }

    public boolean isOk() {
        return ok;
    }

    public Message getMessage() {
        return result;
    }
}
