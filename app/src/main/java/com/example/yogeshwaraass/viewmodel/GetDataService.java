package com.example.yogeshwaraass.viewmodel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Yogeshwaraa.ss on 7/16/2018.
 */

public interface GetDataService {
    public static final String BASE_URL="https://jsonplaceholder.typicode.com";
    @GET("/photos")
    Call<List<RetroPhoto>> getAllPhotos();
}
