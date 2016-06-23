package org.dsequeira.telegrambot.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author daniel.sequeira
 */
public class Message {

    @SerializedName(value = "message_id")
    private Integer messageId;
    private User from;
    private Integer date;
    private Chat chat;
    private String text;
    private List<MessageEntity> entities = new ArrayList<>();

    public Message() { }

    public Integer getMessageId() {
        return messageId;
    }

    public User getFrom() {
        return from;
    }

    public Integer getDate() {
        return date;
    }

    public Chat getChat() {
        return chat;
    }

    public String getText() {
        return text;
    }

    public List<MessageEntity> getEntities() {
        return entities;
    }

    @Override
    public String toString() {
        return "Message [messageId=" + messageId + ", from=" + from.toString() + ", date=" + date + ", chat="
                + chat.toString() + ", text=" + text + ", entity=" + entities.toString() + "]";
    }
}
