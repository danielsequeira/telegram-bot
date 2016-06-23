package org.dsequeira.telegrambot.model;

/**
 *
 * @author daniel.sequeira
 */
public class MessageEntity {

    private String type;
    private Integer offset;
    private Integer length;
    private String url;

    public MessageEntity() { }

    public String getType() {
        return type;
    }

    public Integer getOffset() {
        return offset;
    }

    public Integer getLength() {
        return length;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "MessageEntity [type=" + type + ", offset=" + offset + ", length=" + length
                + ", url=" + url + "]";
    }
}
