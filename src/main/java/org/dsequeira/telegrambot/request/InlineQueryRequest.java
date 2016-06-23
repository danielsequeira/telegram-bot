package org.dsequeira.telegrambot.request;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author daniel.sequeira
 */
public class InlineQueryRequest {

    @SerializedName(value = "update_id")
    private Integer updateId;
    @SerializedName(value = "inline_query")
    private InlineQuery inlineQuery;

    public Integer getUpdateId() {
        return updateId;
    }
    public InlineQuery getInlineQuery() {
        return inlineQuery;
    }
}
