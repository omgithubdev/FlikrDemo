package com.omagrahari.flickrApp.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.omagrahari.flickrApp.entiry.ResponsePhotos;
import com.omagrahari.flickrApp.repository.FlickrRepository;

/**
 * Created by omprakash on 28,January,2020
 */
public class MainViewModel extends ViewModel {
    FlickrRepository flickrRepository;

    public int page = 0;
    public boolean lastPage = false;
    public String searchTxt = "";

    public MainViewModel(FlickrRepository flickrRepository) {
        this.flickrRepository = flickrRepository;
    }

    public LiveData<ResponsePhotos> getPhotos() {
        return flickrRepository.getPhotos();
    }

    public boolean requestPhotos() {
        if (!lastPage) {
            page = page + 1;
            flickrRepository.requestPhotos(searchTxt, page);

            return true;
        } else
            return false;
    }

}
