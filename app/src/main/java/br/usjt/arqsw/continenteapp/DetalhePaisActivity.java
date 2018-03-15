package br.usjt.arqsw.continenteapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Author: Otávio Augusto Soares Costa
 * RA: 816118924
 */
public class DetalhePaisActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_pais);
        TextView txtPais = findViewById(R.id.txtPais);
        Intent intent = getIntent();
        Pais pais = (Pais) intent.getSerializableExtra(ListarPaisesContinenteActivity.PAIS);
        txtPais.setText(pais.getNome());
    }
}
