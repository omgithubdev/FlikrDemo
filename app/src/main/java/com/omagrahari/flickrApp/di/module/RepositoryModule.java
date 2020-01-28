package com.omagrahari.flickrApp.di.module;

import android.app.Application;

import com.omagrahari.flickrApp.repository.FlickrRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by omprakash on 28,January,2020
 */
@Module
public class RepositoryModule {
    @Singleton
    @Provides
    public FlickrRepository providesFlickrRespository(Application application) {
        return new FlickrRepository(application);
    }
}
