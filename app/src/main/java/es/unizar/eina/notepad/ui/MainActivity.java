package es.unizar.eina.notepad.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import es.unizar.eina.notepad.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {

        Intent i = new Intent();
        if (view.getId() == R.id.platos_button) {
            i = new Intent(this, ListarPlatos.class);
        }
        else if (view.getId() == R.id.pedidos_button) {
            i = new Intent(this, ListarPedidos.class);
        }
        startActivity(i);
    }
}
