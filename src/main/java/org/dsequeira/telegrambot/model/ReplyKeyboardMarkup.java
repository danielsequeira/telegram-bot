package org.dsequeira.telegrambot.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author daniel.sequeira
 */
public class ReplyKeyboardMarkup {

    private List<List<KeyboardButton>> keyboard;
    @SerializedName("one_time_keyboard")
    private Boolean oneTimeKeyboard;

    public ReplyKeyboardMarkup() { }

    public ReplyKeyboardMarkup(final List<List<KeyboardButton>> keyboard, final Boolean oneTimeKeyboard) {
        this.keyboard = keyboard;
        this.oneTimeKeyboard = oneTimeKeyboard;
    }

    public List<List<KeyboardButton>> getKeyboard() {
        return keyboard;
    }

    public Boolean getOneTimeKeyboard() {
        return oneTimeKeyboard;
    }
}
