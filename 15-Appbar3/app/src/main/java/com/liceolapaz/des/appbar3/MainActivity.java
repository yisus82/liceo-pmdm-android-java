package com.liceolapaz.des.appbar3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Appbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //Appbar page filter
        Spinner cmbToolbar = (Spinner) findViewById(R.id.cmbToolbar);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                getSupportActionBar().getThemedContext(),
                R.layout.appbar_filter_title,
                new String[]{"Opción 1 ", "Opción 2 ", "Opción 3 "});
        adapter.setDropDownViewResource(R.layout.appbar_filter_list);
        cmbToolbar.setAdapter(adapter);
        cmbToolbar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("Appbar3", "Seleccionada opción " + i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Log.i("Appbar3", "Ninguna opción seleccionada");
            }
        });

        //Tabs + ViewPager
        ViewPager2 viewPager = (ViewPager2) findViewById(R.id.viewpager);
        MiFragmentPagerAdapter miFragmentPagerAdapter = new MiFragmentPagerAdapter(this);
        viewPager.setAdapter(miFragmentPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.appbartabs);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText(miFragmentPagerAdapter.getTabTitles()[position])
        ).attach();
    }
}