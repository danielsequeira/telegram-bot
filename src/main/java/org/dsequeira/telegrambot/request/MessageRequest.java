package org.dsequeira.telegrambot.request;

import org.dsequeira.telegrambot.model.Message;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author daniel.sequeira
 */
public class MessageRequest {

    @SerializedName(value = "update_id")
    private Integer updateId;
    private Message message;

    public Integer getUpdateId() {
        return updateId;
    }
    public Message getMessage() {
        return message;
    }
}
