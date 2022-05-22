package com.example.ultrababyshop;

import androidx.annotation.NonNull;

public class Brain {

    private String title;
    private String info;
    private int imageResourceId;

    public String getTitle() {
        return title;
    }

    public String getInfo() {
        return info;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public Brain(String title, String info, int imageResourceId) {
        this.title = title;
        this.info = info;
        this.imageResourceId = imageResourceId;
    }

    @NonNull
    @Override
    public String toString() {
        return title;
    }
}
