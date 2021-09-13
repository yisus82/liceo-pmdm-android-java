package com.liceolapaz.des.bbdd3;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText txtCodigo;
    private EditText txtNombre;
    private TextView txtResultado;
    private Button btnInsertar;
    private Button btnActualizar;
    private Button btnEliminar;
    private Button btnConsultar;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Obtenemos las referencias a los controles
        txtCodigo = (EditText) findViewById(R.id.txtReg);
        txtNombre = (EditText) findViewById(R.id.txtVal);
        txtResultado = (TextView)findViewById(R.id.txtResultado);
        btnInsertar = (Button) findViewById(R.id.btnInsertar);
        btnActualizar = (Button) findViewById(R.id.btnActualizar);
        btnEliminar = (Button) findViewById(R.id.btnEliminar);
        btnConsultar = (Button) findViewById(R.id.btnConsultar);

        //Abrimos la base de datos 'DBUsuarios' en modo escritura
        UsuariosSQLiteHelper usdbh =
                new UsuariosSQLiteHelper(this, "DBUsuarios", null, 1);
        db = usdbh.getWritableDatabase();

        btnInsertar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Recuperamos los valores de los campos de texto
                String cod = txtCodigo.getText().toString();
                String nom = txtNombre.getText().toString();

                //Alternativa 1: método sqlExec()
                String sql = "INSERT INTO Usuarios (codigo,nombre) VALUES ('" + cod + "','" + nom + "') ";
                db.execSQL(sql);

                //Alternativa 2: método insert()
                //ContentValues nuevoRegistro = new ContentValues();
                //nuevoRegistro.put("codigo", cod);
                //nuevoRegistro.put("nombre", nom);
                //db.insert("Usuarios", null, nuevoRegistro);
            }
        });

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Recuperamos los valores de los campos de texto
                String cod = txtCodigo.getText().toString();
                String nom = txtNombre.getText().toString();

                //Alternativa 1: método sqlExec()
                String sql = "UPDATE Usuarios SET nombre='" + nom + "' WHERE codigo=" + cod;
                db.execSQL(sql);

                //Alternativa 2: método update()
                //ContentValues valores = new ContentValues();
                //valores.put("nombre", nom);
                //db.update("Usuarios", valores, "codigo=" + cod, null);
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Recuperamos los valores de los campos de texto
                String cod = txtCodigo.getText().toString();

                //Alternativa 1: método sqlExec()
                String sql = "DELETE FROM Usuarios WHERE codigo=" + cod;
                db.execSQL(sql);

                //Alternativa 2: método delete()
                //db.delete("Usuarios", "codigo=" + cod, null);
            }
        });

        btnConsultar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //Alternativa 1: método rawQuery()
                Cursor c = db.rawQuery("SELECT codigo, nombre FROM Usuarios", null);

                //Alternativa 2: método delete()
                //String[] campos = new String[] {"codigo", "nombre"};
                //Cursor c = db.query("Usuarios", campos, null, null, null, null, null);

                //Recorremos los resultados para mostrarlos en pantalla
                txtResultado.setText("");
                if (c.moveToFirst()) {
                    //Recorremos el cursor hasta que no haya más registros
                    do {
                        String cod = c.getString(0);
                        String nom = c.getString(1);

                        txtResultado.append(" " + cod + " - " + nom + "\n");
                    } while (c.moveToNext());
                }
            }
        });
    }
}