package com.liceolapaz.des.imagentexto;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.Spannable;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private ImageView imgLogo;
    private TextView lblEtiqueta;
    private EditText txtBasico;
    private Button btnNegrita;
    private Button btnSetText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Establecer la imagen por código
        imgLogo = findViewById(R.id.imgLogo);
        imgLogo.setImageResource(R.drawable.logoandroid);

        //Estalecer propiedades de la etiqueta de texto por código:
        lblEtiqueta = findViewById(R.id.lblEtiqueta);
        String texto = lblEtiqueta.getText().toString();
        lblEtiqueta.setText("$texto (modificado)");
        lblEtiqueta.setBackgroundColor(Color.RED);

        //Establecer propiedades del cuadro de texto por código:
        txtBasico = findViewById(R.id.txtBasico);
        String mitexto = txtBasico.getText().toString();
        txtBasico.setText("Otro texto");

        //Convertir a HTML el contenido del control
        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            String aux2 = Html.toHtml(txtBasico.text, Html.TO_HTML_PARAGRAPH_LINES_INDIVIDUAL);
        }*/

        //Convertir HTML a Spannable
        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            txtBasico.setText(
                Html.fromHtml("<p>Esto es un <b>simulacro</b>.</p>", Html.FROM_HTML_MODE_LEGACY),
                TextView.BufferType.SPANNABLE);
        }*/

        btnNegrita = (Button) findViewById(R.id.btnNegrita);
        btnNegrita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spannable texto = txtBasico.getText();

                int ini = txtBasico.getSelectionStart();
                int fin = txtBasico.getSelectionEnd();

                if (texto != null) {
                    texto.setSpan(
                            new StyleSpan(Typeface.BOLD),
                            ini, fin,
                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                }
            }
        });

        btnSetText = (Button) findViewById(R.id.btnSetText);
        btnSetText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editable str = Editable.Factory.getInstance().newEditable("Esto es un simulacro.");
                str.setSpan(new StyleSpan(Typeface.BOLD), 11, 20, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                txtBasico.setText(str);

                //Nueva cadena de texto
                //String nuevoTexto = "<p>Otro <b>texto</b> de ejemplo.</p>";

                //Asigna texto sin formato (incluirá todas las etiquetas HTML)
                //txtBasico.setText(nuevoTexto);

                //Asigna texto con formato HTML
                //txtBasico.setText(Html.fromHtml(nuevoTexto),BufferType.SPANNABLE);

                //Obtiene el texto SIN etiquetas de formato HTML
                //String aux1 = txtBasico.getText().toString();

                //Obtiene el texto CON etiquetas de formato HTML
                //String aux2 = Html.toHtml(txtBasico.getText());
            }
        });
    }
}