package org.dsequeira.telegrambot.model;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author daniel.sequeira
 */
public class KeyboardButton {

    private String text;
    @SerializedName("request_contact")
    private Boolean requestContact;
    @SerializedName("request_location")
    private Boolean requestLocation;

    public KeyboardButton() { }

    public KeyboardButton(final String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public Boolean getRequestContact() {
        return requestContact;
    }

    public Boolean getRequestLocation() {
        return requestLocation;
    }
}
