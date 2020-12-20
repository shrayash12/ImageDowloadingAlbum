package com.example.myimagedownloadingalbum.com.example.myimagedownloadingalbum.di;

import com.example.myimagedownloadingalbum.com.example.myimagedownloadingalbum.view.MainActivity;
import com.example.myimagedownloadingalbum.com.example.myimagedownloadingalbum.view.SecondActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ImageDownloadingModule.class, AppModule.class})
public interface ImageDownloadingComponent {

    void inject(MainActivity activity);

    void inject(SecondActivity activity);

}
