package org.dsequeira.telegrambot.model;

import java.util.UUID;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author daniel.sequeira
 */
public class InlineQueryResultPhoto {

    private String type;
    private String id;
    @SerializedName(value = "photo_url")
    private String photoUrl;
    @SerializedName(value = "thumb_url")
    private String thumbUrl;
    private String title;
    private String caption;

    public InlineQueryResultPhoto() { }

    public InlineQueryResultPhoto(final String photoUrl, final String thumbUrl, final String title, final String caption) {
        this.type = "photo";
        this.id = UUID.randomUUID().toString();
        this.photoUrl = photoUrl;
        this.thumbUrl = thumbUrl;
        this.title = title;
        this.caption = caption;
    }



    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getCaption() {
        return caption;
    }

    @Override
    public String toString() {
        return "InlineQueryResultPhoto [type=" + type + ", id=" + id + ", photoUrl=" + photoUrl
                + ", thumbUrl=" + thumbUrl + ", title" + title + "]";
    }
}
