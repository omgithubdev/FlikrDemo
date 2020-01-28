package com.omagrahari.flickrApp.network;

import com.omagrahari.flickrApp.entiry.ResponsePhotos;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by omprakash on 28,January,2020
 */
public interface ApiReference {
    @GET("services/rest/?method=flickr.photos.search&nojsoncallback=1&format=json&safe_search=1")
    Call<ResponsePhotos> searchPhoto(@Query("api_key") String apiKey, @Query("page") int page, @Query("text") String text);
}
