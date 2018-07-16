package com.example.yogeshwaraass.viewmodel;

import android.app.ProgressDialog;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Yogeshwaraa.ss on 7/16/2018.
 */

public class MoviesViewModel extends ViewModel {
  private MutableLiveData<List<RetroPhoto>> list;
  public LiveData<List<RetroPhoto>> getAllPhotos(){
      if(list == null){
          list = new MutableLiveData<List<RetroPhoto>>();
          loadAllPhotos();
      }
      return list;
  }

    private void loadAllPhotos() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GetDataService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GetDataService getDataService = retrofit.create(GetDataService.class);
        Call<List<RetroPhoto>> call = getDataService.getAllPhotos();
        call.enqueue(new Callback<List<RetroPhoto>>() {
            @Override
            public void onResponse(Call<List<RetroPhoto>> call, Response<List<RetroPhoto>> response) {
                list.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<RetroPhoto>> call, Throwable t) {
            }
        });
    }
}
