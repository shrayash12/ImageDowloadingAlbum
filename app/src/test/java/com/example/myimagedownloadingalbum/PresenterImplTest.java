package com.example.myimagedownloadingalbum;

import com.example.myimagedownloadingalbum.com.example.myimagedownloadingalbum.model.ImageResponse;
import com.example.myimagedownloadingalbum.com.example.myimagedownloadingalbum.model.ImageService;
import com.example.myimagedownloadingalbum.com.example.myimagedownloadingalbum.model.Photo;
import com.example.myimagedownloadingalbum.com.example.myimagedownloadingalbum.presenter.PresenterImpl;
import com.example.myimagedownloadingalbum.com.example.myimagedownloadingalbum.view.ImageAlbumView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.*;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PresenterImplTest {

    PresenterImpl presenter;
    @Mock
    public ImageService imageService;

    @Mock
    public ImageAlbumView imageAlbumView;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        presenter = new PresenterImpl(imageService, imageAlbumView);
    }

    @Test
    public void testSearchImage() {
        Photo photo = new Photo();
        photo.setPhotographer("Yash");

        List<Photo> list = new ArrayList<>();

        list.add(photo);
        list.add(photo);
        list.add(photo);
        list.add(photo);

        ImageResponse imageResponse = new ImageResponse();
        imageResponse.setPhotos(list);
        // whenever presenter want to acces getImage return this object
        when(imageService.getImage("plant", "10")).thenReturn(Observable.just(imageResponse));

        presenter.searchImages("plant");
        verify(imageAlbumView).downloadedImages(list);
    }
}
