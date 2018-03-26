package br.usjt.arqsw.continenteapp.model;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Auguston on 25/03/2018.
 */

public class ViewHolder {
    private TextView nome, regiao, capital;
    private ImageView imagem;

    public TextView getNome() {
        return nome;
    }

    public void setNome(TextView nome) {
        this.nome = nome;
    }

    public TextView getRegiao() {
        return regiao;
    }

    public void setRegiao(TextView regiao) {
        this.regiao = regiao;
    }

    public TextView getCapital() {
        return capital;
    }

    public void setCapital(TextView capitaql) {
        this.capital = capitaql;
    }

    public ImageView getImagem() {
        return imagem;
    }

    public void setImagem(ImageView imagem) {
        this.imagem = imagem;
    }
}
