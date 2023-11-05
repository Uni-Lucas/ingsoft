package es.unizar.eina.notepad.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import es.unizar.eina.notepad.R;

public class NewPlato extends AppCompatActivity {

    private int currentProgress = 0;
    private ProgressBar progressBar;
    private Button acceptButton;
    private Button cancelButton;
    private TextView viewField;
    private EditText editText;

    private String platoNombre, platoDescripcion, platoCategoria;
    private boolean platoVisible;
    private double platoPrecio;

    public NewPlato() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_plato);
        progressBar = findViewById(R.id.progressBar);
        acceptButton = findViewById(R.id.acceptButton);
        cancelButton = findViewById(R.id.cancelButton);
        viewField = findViewById(R.id.viewField);
        editText = findViewById(R.id.editText);
        viewField.setText("@string/platoNombre");
        progressBar.setMax(4);
        Activity parentActivity = this;

        acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(currentProgress) {
                    case 0:
                        platoNombre = editText.getText().toString();
                        viewField.setText("@string/platoDescripcion");
                    case 1:
                        platoDescripcion = editText.getText().toString();
                        viewField.setText("@string/platoCateogria");
                    case 2:
                        platoCategoria = editText.getText().toString();
                        viewField.setText("@string/platoPrecio");
                    case 3:
                        platoPrecio = Double.parseDouble(editText.getText().toString());
                        viewField.setText("@string/platoVisible");
                    case 4:
                        platoVisible = editText.getText().toString().equals("Visible");
                        // guardar en la bd
                        Intent i = new Intent(parentActivity, ListarPlatos.class);
                        startActivity(i);
                }
                currentProgress++;
                progressBar.setProgress(currentProgress);
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
