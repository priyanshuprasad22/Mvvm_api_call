package com.example.displayimage.ImageModel;

import com.example.displayimage.Model.Image;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {

    @GET("photos")
    Call<ArrayList<Image>> getImages();
}
