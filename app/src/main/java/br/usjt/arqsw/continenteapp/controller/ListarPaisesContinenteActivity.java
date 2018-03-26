package br.usjt.arqsw.continenteapp.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import br.usjt.arqsw.continenteapp.R;
import br.usjt.arqsw.continenteapp.model.Pais;
import br.usjt.arqsw.continenteapp.model.Data;
import br.usjt.arqsw.continenteapp.model.PaisAdapter;

/**
 * Author: Otávio Augusto Soares Costa
 * RA: 816118924
 */
public class ListarPaisesContinenteActivity extends Activity {

    public static final String PAIS = "br.usjt.desmob.geodata.pais";
    ArrayList<Pais> paises;
    ListView listView;
    Activity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_paises_continente);
        Intent intent = getIntent();
        String continente = intent.getStringExtra(MainActivity.LISTAR_PAISES_CONTINENTE);
        paises = Data.listarPaisesByContinente(continente);
        listView = findViewById(R.id.listar_paises);
        PaisAdapter adapter = new PaisAdapter(this, paises);
        listView.setAdapter(adapter);
        context = this;
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Pais pais = paises.get(i);
                Intent intent = new Intent(context, DetalhePaisActivity.class);
                intent.putExtra(PAIS, pais);
                startActivity(intent);
            }
        });

    }
}
