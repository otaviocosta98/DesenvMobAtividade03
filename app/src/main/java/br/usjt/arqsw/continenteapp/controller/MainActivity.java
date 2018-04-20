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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import br.usjt.arqsw.continenteapp.R;
import br.usjt.arqsw.continenteapp.model.Pais;
import br.usjt.arqsw.continenteapp.model.PaisDb;
import br.usjt.arqsw.continenteapp.model.PaisNetwork;

/**
 * Author: Otávio Augusto Soares Costa
 * RA: 816118924
 */
public class MainActivity extends Activity {
    public static final String LISTAR_PAISES_CONTINENTE = "br.usjt.arqsw.continenteapp.txtContinente";
    public static final String HOST = "http:/192.168.6.214:8080/desenvmob_pais/";
    Spinner spinner;
    String continente;
    Context context;
    public static ArrayList<Pais> _paises = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner_continentes);
        context = this;
        new DownloadJSONPais().execute(HOST + "rest/paies", HOST + "img/");
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
        new DownloadJSONPais().execute(HOST + "rest/paises");
//        Intent intent = new Intent(this, ListarPaisesContinenteActivity.class);
//        intent.putExtra(LISTAR_PAISES_CONTINENTE, continente);
//        startActivity(intent);
    }

    private class DownloadJSONPais extends AsyncTask<String, Void, ArrayList<Pais>> {

        @Override
        protected ArrayList<Pais> doInBackground(String... strings) {
            PaisDb db = new PaisDb(context);
            ArrayList<Pais> paises = db.listarPaises();
            if (paises == null || paises.size() == 0) {
                try {
                    paises = PaisNetwork.buscarPaises(strings[0], strings[1]);
                    db.inserirPais(paises);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    DateFormat formatter = new SimpleDateFormat(Pais.DATE_PATTERN);
                    String sData = formatter.format(paises.get(paises.size()-1).getDataAtualizacao());
                    ArrayList<Pais> paisesNovos = PaisNetwork.buscarPaises(strings[0]+"/" +
                            sData, strings[1]);
                    if(paisesNovos == null){
                        paisesNovos = new ArrayList<>();
                    }
                    for(Pais pais: paisesNovos){
                        int posicao = Pais.getPais(paises, pais.getNome());
                        if (posicao >= 0) {
                            paises.remove(posicao);
                        }
                        paises.add(pais);
                    }
                    db.atualizaPaises(paisesNovos);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            return paises;
        }

        protected void onPostExecute(ArrayList<Pais> paises){
            Intent i = new Intent(context, ListarPaisesContinenteActivity.class);
            _paises = paises;
            i.putExtra(LISTAR_PAISES_CONTINENTE, paises);
            startActivity(i);
        }
    }
}
