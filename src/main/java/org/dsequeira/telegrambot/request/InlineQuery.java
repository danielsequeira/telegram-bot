package org.dsequeira.telegrambot.request;

import org.dsequeira.telegrambot.model.User;

/**
 *
 * @author daniel.sequeira
 */
public class InlineQuery {

    private String id;
    private User from;
    private String query;
    private String offset;

    public String getId() {
        return id;
    }
    public User getFrom() {
        return from;
    }
    public String getQuery() {
        return query;
    }
    public String getOffset() {
        return offset;
    }

    @Override
    public String toString() {
        return "InlineQuery [id=" + id + ", from=" + from + ", query=" + query + ", offset="
                + offset + "]";
    }
}
