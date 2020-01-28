package com.omagrahari.flickrApp.repository;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.omagrahari.flickrApp.BuildConfig;
import com.omagrahari.flickrApp.R;
import com.omagrahari.flickrApp.entiry.ResponsePhotos;
import com.omagrahari.flickrApp.network.ApiReference;
import com.omagrahari.flickrApp.util.Utils;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.omagrahari.flickrApp.FlickrApplication.getFlickrApplication;

/**
 * Created by omprakash on 28,January,2020
 */
public class FlickrRepository {
    Application application;

    @Inject
    ApiReference apiReference;

    MutableLiveData<ResponsePhotos> photosMutableLiveData = new MutableLiveData<>();

    public FlickrRepository(Application application) {
        this.application = application;

        getFlickrApplication().getComponent().inject(this);
    }

    public void requestPhotos(String searchTxt, int page) {
        if (!Utils.isNetworkConnected(application.getApplicationContext())) {
            Toast.makeText(application.getApplicationContext(), application.getApplicationContext().getString(R.string.error_no_internet), Toast.LENGTH_LONG).show();
            return;
        }

        apiReference.searchPhoto(BuildConfig.FLICKR_KEY, page, searchTxt).enqueue(new Callback<ResponsePhotos>() {
            @Override
            public void onResponse(Call<ResponsePhotos> call, Response<ResponsePhotos> response) {
                Log.d("CHECKPOINT", "CHECK RESP::" + response.toString());
                if (response.code() == 200) {
                    ResponsePhotos responsePhotos = response.body();
                    photosMutableLiveData.postValue(responsePhotos);
                }
            }

            @Override
            public void onFailure(Call<ResponsePhotos> call, Throwable t) {
                Log.d("CHECKPOINT", "CHECK ERROR::" + t.getLocalizedMessage());
            }
        });
    }

    public MutableLiveData<ResponsePhotos> getPhotos() {
        return photosMutableLiveData;
    }

}
