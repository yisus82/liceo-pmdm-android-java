package com.liceolapaz.des.botones;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView lblMensaje;
    private Button btnBotonSimple;
    private Button btnBotonMasImagen;
    private ToggleButton btnToggle;
    private Switch btnSwitch;
    private ImageButton btnImagen;
    private ToggleButton btnPersonalizado;
    private ImageButton btnSinBorde;
    private Button btnAceptar;
    private Button btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lblMensaje = (TextView) findViewById(R.id.LblMensaje);

        btnBotonSimple = (Button) findViewById(R.id.BtnBotonSimple);

        btnBotonSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lblMensaje.setText("Botón Simple pulsado!");
            }
        });

        btnBotonMasImagen = (Button) findViewById(R.id.BtnBotonMasImagen);

        btnBotonMasImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lblMensaje.setText("Botón texto+imagen pulsado!");
            }
        });

        btnToggle = (ToggleButton) findViewById(R.id.BtnToggle);

        btnToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnToggle.isChecked())
                    lblMensaje.setText("Botón Toggle: ON");
                else
                    lblMensaje.setText("Botón Toggle: OFF");
            }
        });

        btnSwitch = (Switch) findViewById(R.id.BtnSwitch);

        btnSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    lblMensaje.setText("Botón Switch: ON");
                } else {
                    lblMensaje.setText("Botón Switch: OFF");
                }
            }
        });

        btnImagen = (ImageButton) findViewById(R.id.BtnImagen);

        btnImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lblMensaje.setText("Botón Imagen pulsado!");
            }
        });

        btnPersonalizado = (ToggleButton) findViewById(R.id.BtnPersonalizado);

        btnPersonalizado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnPersonalizado.isChecked())
                    lblMensaje.setText("Botón Personalizado: ON");
                else
                    lblMensaje.setText("Botón Personalizado: OFF");
            }
        });

        btnSinBorde = (ImageButton) findViewById(R.id.BtnSinBorde);

        btnSinBorde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lblMensaje.setText("Botón Sin Borde pulsado!");
            }
        });

        btnAceptar = (Button) findViewById(R.id.BtnAceptar);

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lblMensaje.setText("Botón Aceptar pulsado!");
            }
        });

        btnCancelar = (Button) findViewById(R.id.BtnCancelar);

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lblMensaje.setText("Botón Cancelar pulsado!");
            }
        });
    }
}
