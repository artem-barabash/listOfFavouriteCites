package com.example.myapplicationlistcities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.ScrollView;

import com.example.myapplicationlistcities.model.City;

public class MainActivity extends AppCompatActivity implements ListFragment.OnFragementSendDataListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onSendData(City data) {
        DetailFragment fragment = (DetailFragment) getSupportFragmentManager()
                .findFragmentById(R.id.detailFragment);

        //горизонале
        if(fragment != null && fragment.isVisible()){
            fragment.setSelectedItem(data);
        }else {
            //вертикаль
            Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
            intent.putExtra(DetailActivity.SELECTED_ITEM,  data);

            //ScrollView scrollView = findViewById(R.id.scroll_container);
            //scrollView.setMinimumHeight(300);

            startActivity(intent);
        }
    }
}