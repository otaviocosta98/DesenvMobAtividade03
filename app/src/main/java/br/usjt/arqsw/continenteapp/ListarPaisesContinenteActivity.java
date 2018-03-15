package br.usjt.arqsw.continenteapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListarPaisesContinenteActivity extends Activity {

    public static final String PAIS = "br.usjt.desmob.geodata.pais";
    ArrayList<Pais> paises;
    String continente;
    Activity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_paises_continente);
        Intent intent = getIntent();
        continente = intent.getStringExtra(MainActivity.LISTAR_PAISES_CONTINENTE);
        ListView listView = findViewById(R.id.listar_paises);
        paises = Utils.listarPaisesByContinente(continente);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Utils.listarNomePaises(paises));
        listView.setAdapter(adapter);
        context = this;
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(context, DetalhePaisActivity.class);
                intent.putExtra(PAIS, paises.get(i));
                startActivity(intent);
            }
        });

    }
}
