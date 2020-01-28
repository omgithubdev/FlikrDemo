package com.omagrahari.flickrApp.entiry;

import com.google.gson.annotations.SerializedName;

/**
 * Created by omprakash on 28,January,2020
 */
public class ResponsePhotos {
    @SerializedName("photos")
    FlickrPhoto photos;

    public FlickrPhoto getPhotos() {
        return photos;
    }

    public void setPhotos(FlickrPhoto photos) {
        this.photos = photos;
    }
}
