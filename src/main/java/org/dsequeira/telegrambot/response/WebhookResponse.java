package org.dsequeira.telegrambot.response;

/**
 *
 * @author daniel.sequeira
 */
public class WebhookResponse {

    private boolean ok;
    private boolean result;
    private String description;

    public WebhookResponse() { }

    public boolean isOk() {
        return ok;
    }

    public boolean getResult() {
        return result;
    }

    public String getDescription() {
        return description;
    }
}
