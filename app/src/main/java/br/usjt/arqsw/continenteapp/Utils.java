package br.usjt.arqsw.continenteapp;

import java.util.ArrayList;

/**
 * Author: Otávio Augusto Soares Costa
 * RA: 816118924
 */
public class Utils {

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
        paisesAfrica.add(new Pais("Africa do Sul"));
        paisesAfrica.add(new Pais("Egito"));
        paisesAfrica.add(new Pais("Madagascar"));
        paisesAfrica.add(new Pais("Congo"));
        paisesAfrica.add(new Pais("Nigeria"));
        return paisesAfrica;
    }

    /**
     * Gera Lista de paises dos continentes das Americas
     * @return
     */
    private static ArrayList<Pais> listarPaisesAmericas(){
        ArrayList<Pais> paisesAmericas = new ArrayList<>();
        paisesAmericas.add(new Pais("Brasil"));
        paisesAmericas.add(new Pais("Estados Unidos"));
        paisesAmericas.add(new Pais("Chile"));
        paisesAmericas.add(new Pais("Argentina"));
        paisesAmericas.add(new Pais("Uruguai"));
        return paisesAmericas;
    }

    /**
     * Gera Lista de paises do continente da Asia
     * @return
     */
    private static ArrayList<Pais> listarPaisesAsia(){
        ArrayList<Pais> paisesAsia = new ArrayList<>();
        paisesAsia.add(new Pais("Japão"));
        paisesAsia.add(new Pais("China"));
        paisesAsia.add(new Pais("Coreia do Sul"));
        paisesAsia.add(new Pais("Tailândia"));
        paisesAsia.add(new Pais("India"));
        return paisesAsia;
    }

    /**
     * Gera Lista de paises do continente da Europe
     * @return
     */
    private static ArrayList<Pais> listarPaisesEurope(){
        ArrayList<Pais> paisesEurope = new ArrayList<>();
        paisesEurope.add(new Pais("Alemanha"));
        paisesEurope.add(new Pais("Inglaterra"));
        paisesEurope.add(new Pais("Finlândia"));
        paisesEurope.add(new Pais("Dinamarca"));
        paisesEurope.add(new Pais("França"));
        return paisesEurope;
    }

    /**
     * Gera Lista de paises do continente da Oceania
     * @return
     */
    private static ArrayList<Pais> listarPaisesOceania(){
        ArrayList<Pais> paisesOceania = new ArrayList<>();
        paisesOceania.add(new Pais("Austrália"));
        paisesOceania.add(new Pais("Nova Zelândia"));
        paisesOceania.add(new Pais("Nova Guiné"));
        paisesOceania.add(new Pais("Samoa"));
        paisesOceania.add(new Pais("Fiji"));
        return paisesOceania;
    }

}