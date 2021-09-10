package com.liceolapaz.des.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recView;
    private Button btnInsertar;
    private Button btnEliminar;
    private Button btnMover;
    private ArrayList<Titular> datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datos = new ArrayList<Titular>();
        for (int i = 0; i < 50; i++)
            datos.add(new Titular("Título " + i, "Subtítulo item " + i));

        recView = (RecyclerView) findViewById(R.id.recView);
        recView.setHasFixedSize(true);

        final AdaptadorTitulares adaptador = new AdaptadorTitulares(datos);

        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("RecyclerView", "Pulsado el elemento " + recView.getChildAdapterPosition(v));
            }
        });

        recView.setAdapter(adaptador);

        recView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        //recView.setLayoutManager(new GridLayoutManager(this, 3));

        recView.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        recView.setItemAnimator(new DefaultItemAnimator());

        btnInsertar = (Button) findViewById(R.id.btnInsertar);

        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datos.add(1, new Titular("Nuevo titular", "Subtitulo nuevo titular"));
                adaptador.notifyItemInserted(1);
            }
        });

        btnEliminar = (Button) findViewById(R.id.btnEliminar);

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datos.remove(1);
                adaptador.notifyItemRemoved(1);
            }
        });

        btnMover = (Button) findViewById(R.id.btnMover);

        btnMover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Titular aux = datos.get(1);
                datos.set(1, datos.get(2));
                datos.set(2, aux);
                adaptador.notifyItemMoved(1, 2);
            }
        });
    }
}