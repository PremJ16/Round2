package com.example.basicinformationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CountryActivity extends AppCompatActivity {
public Button donebutton;
public Button cancelbutton;
public static String stateSelected;
public static String countrySelected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country2);
        donebutton=(Button) findViewById(R.id.c_donebutton);
        cancelbutton=(Button) findViewById(R.id.c_cancelbutton);

        donebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(CountryFragment.selection_status==CountryFragment.DONE_SELECTION){
                    Intent intent=new Intent();
                    intent.putExtra(MainActivity.COUNTRY_TAG,countrySelected);
                    intent.putExtra(MainActivity.STATE_TAG,stateSelected);
                    setResult(MainActivity.COUNTRY_RQ_CODE,intent);
                    finish();

                }


            }
        });
        cancelbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });

        };

    }
