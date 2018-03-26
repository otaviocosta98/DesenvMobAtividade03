package br.usjt.arqsw.continenteapp.model;

/**
 * Created by Auguston on 25/03/2018.
 */

public enum PaisId {
    AFRICA_DO_SUL("África do Sul", "Sul", "Cidade do Cabo", "zaf"),
    EGITO("Egito", "Nordeste", "Cairo", "egy"),
    MADAGASCAR("Madagascar", "Sudeste", "Antananarivo", "mdg"),
    CONGO("Congo", "Centro", "Brazavile", "cog"),
    NIGERIA("Nigeria", "Oeste", "Abuja", "nga"),
    BRASIL("Brasil", "Leste", "Brasília", "bra"),
    ESTADOS_UNIDOS("Estados Unidos", "Central", "Washington D.C.", "usa"),
    CHILE("Chile", "Oeste", "Santiago", "chl"),
    AUSTRALIA("Austrália", "Sul", "Camberra", "aus"),
    URUGUAI("Uruguai", "Sudeste", "Montevidéu", "ury"),
    JAPAO("Japão", "leste", "Tokyo", "jpn"),
    COREIA_DO_SUL("Coréia do Sul", "Sul", "Seul", "kor"),
    TAILANDIA("Tailândia", "Leste", "Bangkok", "tha"),
    INDIA("Índia", "Sul", "Nova Deli", "ind"),
    CHINA("China", "Sudeste", "Pequim", "chn"),
    ALEMANHA("Alemanha", "Centro", "Berlim", "deu"),
    INGLATERRA("Inglatrra", "Norte", "Londres", "gbr"),
    FINLANDIA("Finlândia", "Norte", "Helsínquia", "fin"),
    DINAMARCA("Dinamarca", "Norte", "Copenhague", "dnk"),
    FRANCA("França", "Sul", "Paris", "fra"),
    ARGENTINA("Argentina", "Sul", "Buenos Aires", "arg"),
    NOVA_ZELANDIA("Nova Zelândia", "Sudeste", "Wellington" ,"nzl"),
    INDONESIA("Indonésia", "Norte" , "Jacarta", "idn"),
    SAMOA("Samoa", "Centro-Sul", "Apia", "wsm"),
    FIJI("Fuji", "Leste", "Suva", "fji");

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
