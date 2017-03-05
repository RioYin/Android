package com.model;

/**
 * Created by hpl on 2015/12/12.
 */
public class DM {
    private String name;
    private int imageId;

    public DM(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}
