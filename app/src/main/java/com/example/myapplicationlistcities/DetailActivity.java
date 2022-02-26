package com.example.myapplicationlistcities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.myapplicationlistcities.model.City;

public class DetailActivity extends AppCompatActivity {


    public static final String SELECTED_ITEM = "SELECTED_ITEM";
    City selectedItem = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            finish();
            return;
        }
        setContentView(R.layout.activity_detail);


        selectedItem = (City) getIntent().getSerializableExtra(SELECTED_ITEM);


    }

    @Override
    protected  void onResume(){
        super.onResume();
        DetailFragment fragment = (DetailFragment) getSupportFragmentManager()
                .findFragmentById(R.id.detailFragment);
            if(fragment != null){
                    fragment.setSelectedItem(selectedItem);
            }
    }
}