package com.example.myimagedownloadingalbum.com.example.myimagedownloadingalbum.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myimagedownloadingalbum.R;
import com.example.myimagedownloadingalbum.com.example.myimagedownloadingalbum.model.ImageService;
import com.example.myimagedownloadingalbum.com.example.myimagedownloadingalbum.di.MyApp;

import javax.inject.Inject;

public class SecondActivity extends AppCompatActivity {

    @Inject
    ImageService imageService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ((MyApp) getApplication()).getAppComponent().inject(this);

    }
}
