package br.usjt.arqsw.continenteapp.model;

import java.util.ArrayList;

/**
 * Author: Otávio Augusto Soares Costa
 * RA: 816118924
 */
public class Data {

    /**
     * Retorna lista de paises de acordo com o continente
     * @param continente
     * @return
     */
    public static ArrayList<Pais> listarPaisesByContinente(String continente){
        ArrayList<Pais> paises = new ArrayList<>();
        if(continente.equals("Africa")){
            paises.addAll(listarPaisesAfrica());
        } else if(continente.equals("Americas")){
            paises.addAll(listarPaisesAmericas());
        } else if(continente.equals("Asia")) {
            paises.addAll(listarPaisesAsia());
        } else if(continente.equals("Europe")) {
            paises.addAll(listarPaisesEurope());
        } else if(continente.equals("Oceania")) {
            paises.addAll(listarPaisesOceania());
        } else {
            paises.addAll(listarPaisesAfrica());
            paises.addAll(listarPaisesAmericas());
            paises.addAll(listarPaisesEurope());
            paises.addAll(listarPaisesOceania());
        }
        return paises;
    }

    /**
     * Retorna uma lista de nomes do paises
     * @param paises
     * @return
     */
    public static ArrayList<String> listarNomePaises(ArrayList<Pais> paises){
        ArrayList<String> nomePaises = new ArrayList<>();
        for (Pais pais : paises) {
            nomePaises.add(pais.getNome());
        }
        return nomePaises;
    }

    /**
     * Gera Lista de paises do continente da Africa
     * @return
     */
    private static ArrayList<Pais> listarPaisesAfrica(){
        ArrayList<Pais> paisesAfrica = new ArrayList<>();
        paisesAfrica.add(new Pais(PaisId.AFRICA_DO_SUL.nome(), PaisId.AFRICA_DO_SUL.rregiao(), PaisId.AFRICA_DO_SUL.capital(), PaisId.AFRICA_DO_SUL.bandeira()));
        paisesAfrica.add(new Pais(PaisId.EGITO.nome(), PaisId.EGITO.rregiao(), PaisId.EGITO.capital(), PaisId.EGITO.bandeira()));
        paisesAfrica.add(new Pais(PaisId.MADAGASCAR.nome(), PaisId.MADAGASCAR.rregiao(), PaisId.MADAGASCAR.capital(), PaisId.MADAGASCAR.bandeira()));
        paisesAfrica.add(new Pais(PaisId.CONGO.nome(), PaisId.CONGO.rregiao(), PaisId.CONGO.capital(), PaisId.CONGO.bandeira()));
        paisesAfrica.add(new Pais(PaisId.NIGERIA.nome(), PaisId.NIGERIA.rregiao(), PaisId.NIGERIA.capital(), PaisId.NIGERIA.bandeira()));
        return paisesAfrica;
    }

    /**
     * Gera Lista de paises dos continentes das Americas
     * @return
     */
    private static ArrayList<Pais> listarPaisesAmericas(){
        ArrayList<Pais> paisesAmericas = new ArrayList<>();
        paisesAmericas.add(new Pais(PaisId.BRASIL.nome(), PaisId.BRASIL.rregiao(), PaisId.BRASIL.capital(), PaisId.BRASIL.bandeira()));
        paisesAmericas.add(new Pais(PaisId.ESTADOS_UNIDOS.nome(), PaisId.ESTADOS_UNIDOS.rregiao(), PaisId.ESTADOS_UNIDOS.capital(), PaisId.ESTADOS_UNIDOS.bandeira()));
        paisesAmericas.add(new Pais(PaisId.CHILE.nome(), PaisId.CHILE.rregiao(), PaisId.CHILE.capital(), PaisId.CHILE.bandeira()));
        paisesAmericas.add(new Pais(PaisId.ARGENTINA.nome(), PaisId.ARGENTINA.rregiao(), PaisId.ARGENTINA.capital(), PaisId.ARGENTINA.bandeira()));
        paisesAmericas.add(new Pais(PaisId.URUGUAI.nome(), PaisId.URUGUAI.rregiao(), PaisId.URUGUAI.capital(), PaisId.URUGUAI.bandeira()));
        return paisesAmericas;
    }

    /**
     * Gera Lista de paises do continente da Asia
     * @return
     */
    private static ArrayList<Pais> listarPaisesAsia(){
        ArrayList<Pais> paisesAsia = new ArrayList<>();
        paisesAsia.add(new Pais(PaisId.JAPAO.nome(),PaisId.JAPAO.rregiao(), PaisId.JAPAO.capital(), PaisId.JAPAO.bandeira()));
        paisesAsia.add(new Pais(PaisId.CHINA.nome(),PaisId.CHINA.rregiao(), PaisId.CHINA.capital(), PaisId.CHINA.bandeira()));
        paisesAsia.add(new Pais(PaisId.COREIA_DO_SUL.nome(),PaisId.COREIA_DO_SUL.rregiao(), PaisId.COREIA_DO_SUL.capital(), PaisId.COREIA_DO_SUL.bandeira()));
        paisesAsia.add(new Pais(PaisId.TAILANDIA.nome(),PaisId.TAILANDIA.rregiao(), PaisId.TAILANDIA.capital(), PaisId.TAILANDIA.bandeira()));
        paisesAsia.add(new Pais(PaisId.INDIA.nome(),PaisId.INDIA.rregiao(), PaisId.INDIA.capital(), PaisId.INDIA.bandeira()));
        return paisesAsia;
    }

    /**
     * Gera Lista de paises do continente da Europe
     * @return
     */
    private static ArrayList<Pais> listarPaisesEurope(){
        ArrayList<Pais> paisesEurope = new ArrayList<>();
        paisesEurope.add(new Pais(PaisId.ALEMANHA.nome(), PaisId.ALEMANHA.rregiao(), PaisId.ALEMANHA.capital(), PaisId.ALEMANHA.bandeira()));
        paisesEurope.add(new Pais(PaisId.INGLATERRA.nome(), PaisId.INGLATERRA.rregiao(), PaisId.INGLATERRA.capital(), PaisId.INGLATERRA.bandeira()));
        paisesEurope.add(new Pais(PaisId.FINLANDIA.nome(), PaisId.FINLANDIA.rregiao(), PaisId.FINLANDIA.capital(), PaisId.FINLANDIA.bandeira()));
        paisesEurope.add(new Pais(PaisId.DINAMARCA.nome(), PaisId.DINAMARCA.rregiao(), PaisId.DINAMARCA.capital(), PaisId.DINAMARCA.bandeira()));
        paisesEurope.add(new Pais(PaisId.FRANCA.nome(), PaisId.FRANCA.rregiao(), PaisId.FRANCA.capital(), PaisId.FRANCA.bandeira()));
        return paisesEurope;
    }

    /**
     * Gera Lista de paises do continente da Oceania
     * @return
     */
    private static ArrayList<Pais> listarPaisesOceania(){
        ArrayList<Pais> paisesOceania = new ArrayList<>();
        paisesOceania.add(new Pais(PaisId.AUSTRALIA.nome(), PaisId.AUSTRALIA.rregiao(), PaisId.AUSTRALIA.capital(), PaisId.AUSTRALIA.bandeira()));
        paisesOceania.add(new Pais(PaisId.NOVA_ZELANDIA.nome(), PaisId.NOVA_ZELANDIA.rregiao(), PaisId.NOVA_ZELANDIA.capital(), PaisId.NOVA_ZELANDIA.bandeira()));
        paisesOceania.add(new Pais(PaisId.INDONESIA.nome(), PaisId.INDONESIA.rregiao(), PaisId.INDONESIA.capital(), PaisId.INDONESIA.bandeira()));
        paisesOceania.add(new Pais(PaisId.SAMOA.nome(), PaisId.SAMOA.rregiao(), PaisId.SAMOA.capital(), PaisId.SAMOA.bandeira()));
        paisesOceania.add(new Pais(PaisId.FIJI.nome(), PaisId.FIJI.rregiao(), PaisId.FIJI.capital(), PaisId.FIJI.bandeira()));
        return paisesOceania;
    }

}