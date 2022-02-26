package com.example.myapplicationlistcities;



import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.myapplicationlistcities.model.City;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ListFragment extends Fragment {

    Context context;

    interface OnFragementSendDataListener{
        void onSendData(City data);
    }

    private OnFragementSendDataListener fragementSendDataListener;


    protected  static final ArrayList<City> cities = new ArrayList<City>(){
        {
            add(new City(R.string.city1, R.drawable.kyiv));
            add(new City(R.string.city2, R.drawable.kharkiv));
            add(new City(R.string.city3, R.drawable.dnipro));
            add(new City(R.string.city4, R.drawable.lviv));
            add(new City(R.string.city5, R.drawable.sevastopol));
        }
    };


    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        try {
            fragementSendDataListener = (OnFragementSendDataListener) context;
        } catch (ClassCastException e){
            throw new ClassCastException(context.toString() + " need do interface OnFragmentInteractionListener");
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInsatnceState){

        View view = inflater.inflate(R.layout.fragment_list, container, false);

        ArrayAdapter<City> adapter = new CityAdapter(this.getContext(), cities);

        ListView citiesList = view.findViewById(R.id.countriesList);

        citiesList.setAdapter( adapter );

        citiesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                City selectedItem = (City) adapterView.getItemAtPosition(i);

                fragementSendDataListener.onSendData(selectedItem);
            }
        });

        return view;
    }
}

 class CityAdapter extends ArrayAdapter<City> {
    private ArrayList<City> listCities;

     public CityAdapter(Context context, ArrayList<City> listCities) {
        super(context,0, listCities);
        this.listCities = listCities;
    }


     @Override
    public View getView(int position, View convertView, ViewGroup parent){


        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(android.R.layout.simple_list_item_1, parent, false);
        }
         City city = getItem(position);

        TextView titleCity = (TextView) convertView.findViewById(android.R.id.text1);
        titleCity.setText(city.getNameCity());

        return convertView;
    }

    @Override
    public int getCount(){
        return listCities.size();
    }
}
