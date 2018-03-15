package br.usjt.arqsw.continenteapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends Activity {
    public static final String LISTAR_PAISES_CONTINENTE = "br.usjt.arqsw.continenteapp.txtContinente";
    Spinner spinner;
    String continente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner_continentes);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                continente = (String) adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void listarPaises(View view) {
        Intent intent = new Intent(this, ListarPaisesContinenteActivity.class);
        intent.putExtra(LISTAR_PAISES_CONTINENTE, continente);
        startActivity(intent);
    }
}
