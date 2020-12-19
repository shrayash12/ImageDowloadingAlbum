package com.example.myimagedownloadingalbum.com.example.myimagedownloadingalbum;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ImageDownloadingModule.class, AppModule.class})
public interface ImageDownloadingComponent {

    void inject(MainActivity activity);

    void inject(SecondActivity activity);

}
