package com.liceolapaz.des.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_framelayout);
        //setContentView(R.layout.activity_main_linearlayout);
        //setContentView(R.layout.activity_main_tablelayout);
        //setContentView(R.layout.activity_main_gridlayout);
        //setContentView(R.layout.activity_main_relativelayout);
    }
}