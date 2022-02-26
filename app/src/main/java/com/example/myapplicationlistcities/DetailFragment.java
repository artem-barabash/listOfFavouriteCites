package com.example.myapplicationlistcities;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.myapplicationlistcities.model.City;

public class DetailFragment extends Fragment {
    ImageView imageView;

    Context context;

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstanceState){
        return layoutInflater.inflate(R.layout.fragment_detail, container, false);
    }

    public void setSelectedItem(City selectedItem){

        TextView view = getView().findViewById(R.id.detailsText);
        view.setText(selectedItem.getNameCity());

        ImageView imageView = getView().findViewById(R.id.imageView);
        imageView.setImageResource(selectedItem.getImagecity());
    }
}
