package com.example.gradle_groovy_http_client_authorization.models;

public class StylesResponse {

    private int total_count;

    private StyleModel[] styles;

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    public StyleModel[] getStyles() {
        return styles;
    }

    public void setStyles(StyleModel[] styles) {
        this.styles = styles;
    }
}
