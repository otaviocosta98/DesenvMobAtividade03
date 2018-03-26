package br.usjt.arqsw.continenteapp.model;

/**
 * Created by Auguston on 25/03/2018.
 */

public enum PaisId {
    AFRICA_DO_SUL("África do Sul", "", "", ""),
    EGITO("Egito", "", "", ""),
    MADAGASCAR("Madagascar", "", "", ""),
    CONGO("Congo", "", "", ""),
    NIGERIA("Nigeria", "", "", ""),
    BRASIL("Brasil", "", "Brasília", ""),
    ESTADOS_UNIDOS("Estados Unidos", "", "Washington D.C.", ""),
    CHILE("Chile", "", "", ""),
    AUSTRALIA("Austrália", "", "Sidney", ""),
    URUGUAI("Uruguai", "", "", ""),
    JAPAO("Japão", "", "Tokyo", ""),
    COREIA_DO_SUL("Coréia do Sul", "", "", ""),
    TAILANDIA("Tailândia", "", "", ""),
    INDIA("Índia", "", "", ""),
    CHINA("China", "", "", ""),
    ALEMANHA("Alemanha", "", "", ""),
    INGLATERRA("Inglatrra", "", "Londres", ""),
    FINLANDIA("Finlândia", "", "", ""),
    DINAMARCA("Dinamarca", "", "", ""),
    FRANCA("França", "", "Paris", ""),
    ARGENTINA("Argentina", "", "Buenos Aires", ""),
    NOVA_ZELANDIA("Nova Zelândia", "", "" ,""),
    NOVA_GUINE("Nova Guiné", "" , "", ""),
    SAMOA("Samoa", "", "", ""),
    FIJI("Fuji", "", "", "");

    private final String nome, regiao, capital, bandeira;

    PaisId(String n, String r, String c, String b){
        nome = n;
        regiao = r;
        capital = c;
        bandeira = b;
    }

    public String nome() {
        return nome;
    }

    public String rregiao() {
        return regiao;
    }

    public String capital() {
        return capital;
    }

    public String bandeira() {
        return bandeira;
    }

}
