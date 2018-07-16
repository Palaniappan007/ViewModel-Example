package com.example.yogeshwaraass.viewmodel;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    public static RecyclerView recyclerView;
    static CustomAdapter adapter;
    static List<RetroPhoto> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.customRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MoviesViewModel model = ViewModelProviders.of(this).get(MoviesViewModel.class);
        model.getAllPhotos().observe(this, new Observer<List<RetroPhoto>>() {
            @Override
            public void onChanged(@Nullable List<RetroPhoto> retroPhotos) {
                adapter = new CustomAdapter(MainActivity.this,retroPhotos);
                recyclerView.setAdapter(adapter);
            }
        });
    }
}
