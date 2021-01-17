package com.example.myimagedownloadingalbum.com.example.myimagedownloadingalbum.presenter;

import com.example.myimagedownloadingalbum.com.example.myimagedownloadingalbum.model.ImageService;
import com.example.myimagedownloadingalbum.com.example.myimagedownloadingalbum.model.Photo;
import com.example.myimagedownloadingalbum.com.example.myimagedownloadingalbum.view.ImageAlbumView;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class PresenterImpl implements Presenter {

    final ImageAlbumView imageAlbumView;
    final ImageService imageService;

    @Inject
    public PresenterImpl(final ImageService imageService,
                  final ImageAlbumView imageAlbumView) {
        this.imageService = imageService;
        this.imageAlbumView = imageAlbumView;
    }


    @Override
    public void searchImages(String query) {
        imageService.getImage(query, "10")
                .subscribeOn(Schedulers.io())
                .map(photos -> photos.getPhotos())
                .observeOn(AndroidSchedulers.mainThread())
                .sorted()
                .subscribe(new Observer<List<Photo>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<Photo> photos) {
                        imageAlbumView.downloadedImages(photos);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
