package com.example.myimagedownloadingalbum.com.example.myimagedownloadingalbum.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myimagedownloadingalbum.R;
import com.example.myimagedownloadingalbum.com.example.myimagedownloadingalbum.model.ImageResponse;
import com.example.myimagedownloadingalbum.com.example.myimagedownloadingalbum.model.ImageService;
import com.example.myimagedownloadingalbum.com.example.myimagedownloadingalbum.model.Photo;
import com.example.myimagedownloadingalbum.com.example.myimagedownloadingalbum.di.MyApp;
import com.example.myimagedownloadingalbum.com.example.myimagedownloadingalbum.presenter.Presenter;
import com.example.myimagedownloadingalbum.com.example.myimagedownloadingalbum.utility.Utility;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity  {
    @Inject
    ImageService imageService;
    @Inject
    ImageAdapter imageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // assign singleton instances to fields
        // We need to cast to `MyApp` in order to get the right method
        ((MyApp) getApplication()).getAppComponent().inject(this);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        EditText editText = findViewById(R.id.editSearch);
        Button button = findViewById(R.id.buttonSearch);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        recyclerView.setAdapter(imageAdapter);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Utility.hideKeyboard(MainActivity.this);
                Observable<ImageResponse> output = callImageService(imageService, editText.getText().toString());

                output.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<ImageResponse>() {
                            @Override
                            public void onSubscribe(@NonNull Disposable d) {

                            }

                            @Override
                            public void onNext(@NonNull ImageResponse imageResponse) {
                                imageAdapter.setPhotoList(imageResponse.getPhotos());
                            }

                            @Override
                            public void onError(@NonNull Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        });
            }
        });
    }

    private Observable<ImageResponse> callImageService(ImageService imageService, String query) {
        return imageService.getImage(query, "10");
    }

}
