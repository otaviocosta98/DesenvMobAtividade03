package br.usjt.arqsw.continenteapp.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

import br.usjt.arqsw.continenteapp.R;
import br.usjt.arqsw.continenteapp.controller.MainActivity;

/**
 * Created by Auguston on 25/03/2018.
 */

public class PaisAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Pais> paises;
    private ImageView imagem;

    public PaisAdapter(Context context, ArrayList<Pais> paises) {
        this.context = context;
        this.paises = MainActivity._paises;
    }

    @Override
    public int getCount() {
        return paises.size();
    }

    @Override
    public Object getItem(int i) {
        return paises.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.linha_pais, parent, false);
            ImageView imageView  = (ImageView) view.findViewById(R.id.imagem_pais);
            TextView nome = (TextView) view.findViewById(R.id.nome_pais);
            TextView regiao = (TextView) view.findViewById(R.id.regiao_pais);
            TextView capital = (TextView) view.findViewById(R.id.capital_pais);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.setNome(nome);
            viewHolder.setRegiao(regiao);
            viewHolder.setCapital(capital);
            viewHolder.setImagem(imageView);
            view.setTag(viewHolder);
        }

        Pais pais = paises.get(position);
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        try {
            viewHolder.getImagem().setImageBitmap(paises.get(Pais.getPais(paises, pais.getNome())).getImagem());
        } catch(Exception e){
            viewHolder.getImagem().setImageDrawable(context.getDrawable(R.drawable.ic_not_found));
        }
        viewHolder.getNome().setText(pais.getNome());
        viewHolder.getRegiao().setText(pais.getRegiao());
        viewHolder.getCapital().setText(pais.getCapital());

        return view;
    }
}
