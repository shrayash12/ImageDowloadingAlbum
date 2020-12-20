package com.example.myimagedownloadingalbum.com.example.myimagedownloadingalbum.di;

import android.app.Application;

public class MyApp extends Application {

    private ImageDownloadingComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        // Dagger%COMPONENT_NAME%
        mAppComponent = DaggerImageDownloadingComponent.builder()
                // list of modules that are part of this component need to be created here too
                .appModule(new AppModule(this)) // This also corresponds to the name of your module: %component_name%Module
                .imageDownloadingModule(new ImageDownloadingModule())
                .build();

        // If a Dagger 2 component does not have any constructor arguments for any of its modules,
        // then we can use .create() as a shortcut instead:
        //  mAppComponent = com.codepath.dagger.components.DaggerAppComponent.create();
    }

    public ImageDownloadingComponent getAppComponent() {
        return mAppComponent;
    }
}
