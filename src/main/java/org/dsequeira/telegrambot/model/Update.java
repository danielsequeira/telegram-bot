package org.dsequeira.telegrambot.model;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author daniel.sequeira
 */
public class Update {

    @SerializedName(value = "update_id")
    private Integer updateId;
    private Message message;

    public Update() { }

    public Integer getUpdateId() {
        return updateId;
    }

    public Message getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Update [updateId=" + updateId + ", message=" + message.toString() + "]";
    }
}
