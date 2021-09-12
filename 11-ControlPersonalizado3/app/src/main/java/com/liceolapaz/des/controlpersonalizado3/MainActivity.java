package com.liceolapaz.des.controlpersonalizado3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btnFicha;
    private TresEnRaya terTablero;
    private TextView txtCasilla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        terTablero = (TresEnRaya) findViewById(R.id.tablero);
        btnFicha = (Button) findViewById(R.id.btnFicha);
        txtCasilla = (TextView) findViewById(R.id.txtCasilla);

        btnFicha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                terTablero.alternarFichaActiva();
            }
        });

        terTablero.setOnCasillaSeleccionadaListener(new OnCasillaSeleccionadaListener() {
            @Override
            public void onCasillaSeleccionada(int fila, int columna) {
                txtCasilla.setText("Última casilla seleccionada: " + fila + "." + columna);
            }
        });
    }
}