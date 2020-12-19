package com.example.myimagedownloadingalbum.com.example.myimagedownloadingalbum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myimagedownloadingalbum.R;

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
