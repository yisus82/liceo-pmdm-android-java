package com.liceolapaz.des.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnDefecto = null;
    private Button btnGravity = null;
    private Button btnLayout = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDefecto = (Button) findViewById(R.id.btnPorDefecto);
        btnGravity = (Button) findViewById(R.id.btnGravity);
        btnLayout = (Button) findViewById(R.id.btnLayout);

        btnDefecto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Toast toast =
                        Toast.makeText(getApplicationContext(), "Toast por defecto", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        btnGravity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Toast toast =
                        Toast.makeText(getApplicationContext(), "Toast con gravity", Toast.LENGTH_SHORT);

                toast.setGravity(Gravity.CENTER | Gravity.LEFT, 0, 0);
                toast.show();
            }
        });

        btnLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Toast toast = new Toast(getApplicationContext());

                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.toast_layout,
                        (ViewGroup) findViewById(R.id.lytLayout));

                TextView txtMsg = (TextView) layout.findViewById(R.id.txtMensaje);
                txtMsg.setText("Toast Personalizado");

                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setView(layout);
                toast.show();
            }
        });
    }
}