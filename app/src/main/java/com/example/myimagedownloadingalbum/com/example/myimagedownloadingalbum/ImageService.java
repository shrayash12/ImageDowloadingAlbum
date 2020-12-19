package com.example.myimagedownloadingalbum.com.example.myimagedownloadingalbum;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ImageService {
    @Headers("Authorization: 563492ad6f91700001000001849e07e0baba43e7853bacd9c0eb1a54")
    @GET("v1/search")
    Observable<ImageResponse> getImage(@Query("query") String query,@Query("per_page") String perPage);
}
