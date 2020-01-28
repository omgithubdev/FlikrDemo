package com.omagrahari.flickrApp.di.module;

import android.app.Application;

import com.omagrahari.flickrApp.FlickrApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by omprakash on 28,January,2020
 */
@Module
public class ApplicationModule {
    FlickrApplication flickrApplication;

    public ApplicationModule(FlickrApplication flickrApplication) {
        this.flickrApplication = flickrApplication;
    }

    @Singleton
    @Provides
    public Application providesApplication() {
        return flickrApplication;
    }
}
