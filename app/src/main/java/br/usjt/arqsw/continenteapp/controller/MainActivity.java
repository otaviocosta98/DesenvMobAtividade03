package br.usjt.arqsw.continenteapp.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import java.io.IOException;
import java.util.ArrayList;

import br.usjt.arqsw.continenteapp.R;
import br.usjt.arqsw.continenteapp.model.Pais;
import br.usjt.arqsw.continenteapp.model.PaisNetwork;

/**
 * Author: Otávio Augusto Soares Costa
 * RA: 816118924
 */
public class MainActivity extends Activity {
    public static final String LISTAR_PAISES_CONTINENTE = "br.usjt.arqsw.continenteapp.txtContinente";
    Spinner spinner;
    String continente;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner_continentes);
        context = this;
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

    /**
     * Metodo de chamada da classe ListarPaisesContinenteActivity
     * @return
     */
    public void listarPaises(View view) {
        String pais = continente;
        new DownloadJSONPais().execute("http:/192.168.6.214:8080/desenvmob_pais/rest/paises");
//        Intent intent = new Intent(this, ListarPaisesContinenteActivity.class);
//        intent.putExtra(LISTAR_PAISES_CONTINENTE, continente);
//        startActivity(intent);
    }

    private class DownloadJSONPais extends AsyncTask<String, Void, ArrayList<Pais>> {

        @Override
        protected ArrayList<Pais> doInBackground(String... strings) {
            ArrayList<Pais> paises = new ArrayList<>();

            try {
                paises = PaisNetwork.buscarPaises("http://192.168.6.214:8080/desenvmob_pais/rest/paises");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return paises;
        }

        protected void onPostExecute(ArrayList<Pais> paises){
            Intent i = new Intent(context, ListarPaisesContinenteActivity.class);
            i.putExtra(LISTAR_PAISES_CONTINENTE, paises);
            startActivity(i);
        }
    }
}
