package com.example.displayimage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.displayimage.Adapter.ImageAdapter;
import com.example.displayimage.ImageModel.ImageViewModel;
import com.example.displayimage.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    ActivitySecondBinding activitySecondBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySecondBinding=ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(activitySecondBinding.getRoot());

        activitySecondBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ImageAdapter imageAdapter=new ImageAdapter();
        activitySecondBinding.recyclerView.setAdapter(imageAdapter);

        ImageViewModel imageViewModel=new ViewModelProvider(this).get(ImageViewModel.class);
        imageViewModel.getImagesLiveData().observe(this, images->{
            imageAdapter.putImage(images,this);
        });

        imageViewModel.fetchImages();


    }
}