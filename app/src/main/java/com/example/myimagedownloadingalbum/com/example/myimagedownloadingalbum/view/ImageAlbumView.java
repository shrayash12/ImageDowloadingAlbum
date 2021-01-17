package com.example.myimagedownloadingalbum.com.example.myimagedownloadingalbum.view;

import com.example.myimagedownloadingalbum.com.example.myimagedownloadingalbum.model.Photo;

import java.util.List;

public interface ImageAlbumView {
    void downloadedImages(List<Photo> photos);
}
