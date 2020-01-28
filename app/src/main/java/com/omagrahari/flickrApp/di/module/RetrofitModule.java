package com.omagrahari.flickrApp.di.module;

import com.omagrahari.flickrApp.network.ApiReference;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.omagrahari.flickrApp.util.Constants.BASE_URL;

/**
 * Created by omprakash on 28,January,2020
 */
@Module
public class RetrofitModule {
    @Singleton
    @Provides
    public ApiReference providesApiReference(Retrofit retrofit) {
        return retrofit.create(ApiReference.class);
    }

    @Singleton
    @Provides
    public Retrofit providesRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
