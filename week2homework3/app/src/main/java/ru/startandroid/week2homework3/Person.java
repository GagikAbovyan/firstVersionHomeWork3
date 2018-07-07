package ru.startandroid.week2homework3;

import java.util.List;

public class Person {
    private final int photoId;
    private final String name;
    private final String status;
    public Person(final int photoId, final String name, final String status) {
        this.photoId = photoId;
        this.name = name;
        this.status = status;
    }

    public int getPhotoId() {
        return photoId;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

}
