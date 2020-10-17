package com.example.basicinformationapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import java.lang.reflect.Array;

public class CountryFragment extends ListFragment implements AdapterView.OnItemClickListener {

    private ArrayAdapter adapter;
    static public int  COUNTRY_SELECTION=1;
    public static int STATE_SELECTION=2;
    public static int DONE_SELECTION=3;
    public static int selection_status;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view=inflater.inflate(R.layout.listlayout,container,false);
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getActivity(),"Item: "+adapter.getItem(position),Toast.LENGTH_SHORT).show();
        if(selection_status==COUNTRY_SELECTION){
            CountryActivity.countrySelected=adapter.getItem(position).toString();
            selection_status=STATE_SELECTION;
            //adapter.clear();
            if(position==0){
                adapter= ArrayAdapter.createFromResource(getActivity(),R.array.StatesChina,android.R.layout.simple_list_item_1);

            }
            else if(position==1){
                adapter= ArrayAdapter.createFromResource(getActivity(),R.array.StatesIndia,android.R.layout.simple_list_item_1);

            }
            else if(position==2){
                adapter= ArrayAdapter.createFromResource(getActivity(),R.array.StatesMexico,android.R.layout.simple_list_item_1);

            }
            else if(position==3){
                adapter= ArrayAdapter.createFromResource(getActivity(),R.array.StatesUSA,android.R.layout.simple_list_item_1);

            }
            setListAdapter(adapter);



        }
        else if(selection_status==STATE_SELECTION){
            CountryActivity.stateSelected=adapter.getItem(position).toString();
            selection_status=DONE_SELECTION;
        }


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        selection_status=COUNTRY_SELECTION;
        adapter= ArrayAdapter.createFromResource(getActivity(),R.array.Countries,android.R.layout.simple_list_item_1);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);

    }

}
