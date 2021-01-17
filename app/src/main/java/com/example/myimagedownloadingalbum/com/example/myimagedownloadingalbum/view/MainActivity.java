package com.example.myimagedownloadingalbum.com.example.myimagedownloadingalbum.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myimagedownloadingalbum.R;
import com.example.myimagedownloadingalbum.com.example.myimagedownloadingalbum.di.MyApp;
import com.example.myimagedownloadingalbum.com.example.myimagedownloadingalbum.model.Photo;
import com.example.myimagedownloadingalbum.com.example.myimagedownloadingalbum.presenter.Presenter;
import com.example.myimagedownloadingalbum.com.example.myimagedownloadingalbum.utility.Utility;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements ImageAlbumView {

    @Inject
    ImageAdapter imageAdapter;
    @Inject
    Presenter presenter;

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
                presenter.searchImages(editText.getText().toString());
            }
        });
    }


    @Override
    public void downloadedImages(List<Photo> photos) {
        imageAdapter.setPhotoList(photos);

    }
}
