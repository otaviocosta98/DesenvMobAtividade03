package br.usjt.arqsw.continenteapp.controller;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import br.usjt.arqsw.continenteapp.R;
import br.usjt.arqsw.continenteapp.model.Pais;
import br.usjt.arqsw.continenteapp.model.Util;

/**
 * Author: Otávio Augusto Soares Costa
 * RA: 816118924
 */
public class DetalhePaisActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_pais);
        Intent intent = getIntent();
        Pais pais = (Pais)intent.getSerializableExtra(ListarPaisesContinenteActivity.PAIS);
        ImageView foto = (ImageView) findViewById(R.id.foto_pais_detalhe);
        try {
            foto.setImageBitmap(MainActivity._paises.get(Pais.getPais(MainActivity._paises,
                    pais.getNome())).getImagem());
        } catch (Exception e){
            foto.setImageDrawable(getDrawable(R.drawable.ic_not_found));
        }
        TextView nome = (TextView)findViewById(R.id.valor_nome_pais);
        nome.setText(pais.getNome());
        TextView regiao = (TextView)findViewById(R.id.valor_regiao_pais);
        regiao.setText(""+pais.getRegiao());
        TextView capital = (TextView)findViewById(R.id.valor_capital_pais);
        capital.setText(""+pais.getCapital());
    }
}
