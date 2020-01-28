package com.omagrahari.flickrApp.entiry;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by omprakash on 28,January,2020
 */
public class FlickrPhoto {
    @SerializedName("page")
    int page;
    @SerializedName("pages")
    int pages;
    @SerializedName("perpage")
    int perpage;
    @SerializedName("total")
    int total;
    @SerializedName("photo")
    ArrayList<Photos> photoList = new ArrayList<>();

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPerpage() {
        return perpage;
    }

    public void setPerpage(int perpage) {
        this.perpage = perpage;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public ArrayList<Photos> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(ArrayList<Photos> photoList) {
        this.photoList = photoList;
    }
}
