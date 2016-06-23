package org.dsequeira.telegrambot.model;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

/**
 *
 * @author daniel.sequeira
 */
public class MediaAsset implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String description;
    private String copyright;
    private Integer archive;
    private String datePublished;
    private String type;
    private List<String> propertyOptions;
    private Map<String, String> thumbnails;

    public MediaAsset() { }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCopyright() {
        return copyright;
    }

    public Integer getArchive() {
        return archive;
    }

    public String getPublicationDate() {
        return datePublished;
    }

    public String getType() {
        return type;
    }

    public List<String> getPropertyOptions() {
        return propertyOptions;
    }

    public Map<String, String> getThumbnails() {
        return thumbnails;
    }

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder("MediaAsset [");

        Field[] fields = this.getClass().getDeclaredFields();

        boolean isFirstField = true;

        for (Field field : fields) {
            try {
                if (!isFirstField) {
                    result.append(",");
                    result.append(" ");
                } else {
                    isFirstField = false;
                }

                result.append(field.getName());
                result.append("=");
                result.append(field.get(this));
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        result.append("]");

        return result.toString();
    }
}
