package com.liceolapaz.des.snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private Button btnSnackbarSimple;
    private Button btnSnackbarAccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSnackbarSimple = (Button)findViewById(R.id.BtnSimple);
        btnSnackbarAccion = (Button)findViewById(R.id.BtnAccion);

        btnSnackbarSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Esto es una prueba", Snackbar.LENGTH_LONG)
                        .show();
            }
        });

        btnSnackbarAccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Esto es otra prueba", Snackbar.LENGTH_LONG)
                        //.setActionTextColor(Color.CYAN)
                        .setActionTextColor(getResources().getColor(R.color.snackbar_action))
                        .setAction("Acción", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Log.i("Snackbar", "Pulsada acción snackbar!");
                            }
                        })
                        .show();
            }
        });
    }
}