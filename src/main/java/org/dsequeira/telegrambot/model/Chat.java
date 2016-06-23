package org.dsequeira.telegrambot.model;

/**
 *
 * @author daniel.sequeira
 */
public class Chat {

    private Integer id;
    private String type;

    public Chat() { }

    public Integer getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Chat [id=" + id + ", type=" + type + "]";
    }
}
