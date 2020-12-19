package com.example.myimagedownloadingalbum.com.example.myimagedownloadingalbum;

import javax.inject.Singleton;

import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@dagger.Module
public class ImageDownloadingModule {

    @Provides
    @Singleton
    public static Retrofit provideRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.pexels.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();

        return retrofit;
    }

    @Provides
    @Singleton
    public static ImageService provideImageService(Retrofit retrofit) {
        return retrofit.create(ImageService.class);
    }

    @Provides
    @Singleton
    public static ImageAdapter imageAdapter() {
        return new ImageAdapter();
    }
}
