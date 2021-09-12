package com.liceolapaz.des.appbar2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar Actividad (App bar)
        Toolbar toolbar = (Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //Toolbar Tarjeta
        Toolbar tbCard = (Toolbar) findViewById(R.id.tbCard);
        tbCard.setTitle("Mi tarjeta");
        tbCard.setOnMenuItemClickListener(
                new Toolbar.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_1:
                                Log.i("Appbar2", "Acción Tarjeta 1");
                                break;
                            case R.id.action_2:
                                Log.i("Appbar2", "Acción Tarjeta 2");
                                break;
                        }

                        return true;
                    }
                });
        tbCard.inflateMenu(R.menu.menu_tarjeta);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_nuevo:
                Log.i("Appbar2", "Nuevo!");
                return true;
            case R.id.action_buscar:
                Log.i("Appbar2", "Buscar!");
                return true;
            case R.id.action_opciones:
                Log.i("Appbar2", "Opciones!");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}