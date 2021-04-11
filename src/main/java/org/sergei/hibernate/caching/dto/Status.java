package org.sergei.hibernate.caching.dto;

/**
 * @author Sergei Visotsky
 * @since 1.0
 */
public enum Status {

    SUCCESS("success"),
    FAILED("failed");

    private final String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
