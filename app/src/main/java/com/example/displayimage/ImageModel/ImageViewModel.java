package com.example.displayimage.ImageModel;

import android.content.Context;
import android.database.Observable;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.displayimage.MainActivity;
import com.example.displayimage.Model.Image;

import org.json.JSONArray;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ImageViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Image>> imagesLiveData = new MutableLiveData<>();

    public LiveData<ArrayList<Image>> getImagesLiveData() {
        return imagesLiveData;
    }

    public void fetchImages() {
        String url = "https://jsonplaceholder.typicode.com/";

        Retrofit retrofit= new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();

        API api=retrofit.create(API.class);

        Call<ArrayList<Image>> call=api.getImages();

        call.enqueue(new Callback<ArrayList<Image>>() {
            @Override
            public void onResponse(Call<ArrayList<Image>> call, Response<ArrayList<Image>> response) {
                if(response.isSuccessful()) {
                    ArrayList<Image> images = response.body();
                    imagesLiveData.setValue(images);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Image>> call, Throwable t) {

                Log.d("Error","Error Occured");

            }

        });




    }
}
