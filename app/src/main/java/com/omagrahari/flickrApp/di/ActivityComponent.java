package com.omagrahari.flickrApp.di;


import com.omagrahari.flickrApp.repository.FlickrRepository;
import com.omagrahari.flickrApp.ui.home.MainActivity;
import com.omagrahari.flickrApp.di.module.ApplicationModule;
import com.omagrahari.flickrApp.di.module.RepositoryModule;
import com.omagrahari.flickrApp.di.module.RetrofitModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by omprakash on 28,January,2019
 */
@Singleton
@Component(modules = {ApplicationModule.class, RetrofitModule.class, RepositoryModule.class})
public interface ActivityComponent {

    public void inject(MainActivity mainActivity);

    public void inject(FlickrRepository flickrRepository);
}
