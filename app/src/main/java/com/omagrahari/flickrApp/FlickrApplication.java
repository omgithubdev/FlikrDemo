package com.omagrahari.flickrApp;

import android.app.Application;

import com.omagrahari.flickrApp.di.ActivityComponent;
import com.omagrahari.flickrApp.di.DaggerActivityComponent;
import com.omagrahari.flickrApp.di.module.ApplicationModule;

/**
 * Created by omprakash on 28,January,2020
 */
public class FlickrApplication extends Application {
    ActivityComponent activityComponent;
    public static FlickrApplication flickrApplication;

    @Override
    public void onCreate() {
        super.onCreate();

        flickrApplication = this;

        activityComponent = DaggerActivityComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public static FlickrApplication getFlickrApplication() {
        return flickrApplication;
    }

    public ActivityComponent getComponent() {
        return activityComponent;
    }
}
