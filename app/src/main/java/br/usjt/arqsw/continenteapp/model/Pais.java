package br.usjt.arqsw.continenteapp.model;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;

import java.io.Serializable;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Date;

/**
 * Author: Otávio Augusto Soares Costa
 * RA: 816118924
 */
public class Pais implements Serializable, Comparable{

    /**
     * Contrutor Padrão
     */
    public Pais(){

    }

    /**
     * Construtor com nome
     * @param nome
     */
    public Pais(String nome){
        this.nome = nome;
    }
    public Pais(String nome, String regiao, String capital, String bandeira){
        this.nome = nome; this.regiao = regiao; this.capital = capital; this.bandeira = bandeira;
    }

    public final static String DATE_PATTERN = "dd-MM-yyyy'T'HH:mm:ss'Z'Z";

    private String nome;
    private String codigo3;
    private String capital;
    private String regiao;
    private String subRegiao;
    private String demonimo;
    private int populacao;
    private int area;
    private String bandeira;
    private double gini;
    private ArrayList<String> idiomas;
    private ArrayList<String> moedas;
    private ArrayList<String> dominios;
    private ArrayList<String> fusos;
    private ArrayList<String> fronteiras;
    private double latitude;
    private double longitude;
    private Bitmap imagem;
    private Date dataAtualizacao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo3() {
        return codigo3;
    }

    public void setCodigo3(String codigo3) {
        this.codigo3 = codigo3;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public String getSubRegiao() {
        return subRegiao;
    }

    public void setSubRegiao(String subRegiao) {
        this.subRegiao = subRegiao;
    }

    public String getDemonimo() {
        return demonimo;
    }

    public void setDemonimo(String demonimo) {
        this.demonimo = demonimo;
    }

    public int getPopulacao() {
        return populacao;
    }

    public void setPopulacao(int populacao) {
        this.populacao = populacao;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public double getGini() {
        return gini;
    }

    public void setGini(double gini) {
        this.gini = gini;
    }

    public ArrayList<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(ArrayList<String> idiomas) {
        this.idiomas = idiomas;
    }

    public ArrayList<String> getMoedas() {
        return moedas;
    }

    public void setMoedas(ArrayList<String> moedas) {
        this.moedas = moedas;
    }

    public ArrayList<String> getDominios() {
        return dominios;
    }

    public void setDominios(ArrayList<String> dominios) {
        this.dominios = dominios;
    }

    public ArrayList<String> getFusos() {
        return fusos;
    }

    public void setFusos(ArrayList<String> fusos) {
        this.fusos = fusos;
    }

    public ArrayList<String> getFronteiras() {
        return fronteiras;
    }

    public void setFronteiras(ArrayList<String> fronteiras) {
        this.fronteiras = fronteiras;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Bitmap getImagem() {
        return imagem;
    }

    public void setImagem(Bitmap imagem) {
        this.imagem = imagem;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public static int getPais(ArrayList<Pais> paises, String nome){
        for(int i = 0; i <paises.size(); i++){
            if(paises.get(i).getNome() == nome){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int compareTo(@NonNull Object o) {
        if (o == null || o.getClass() != getClass()) {
            return 0;
        } else {
            Pais pais = (Pais) o;
            Collator c = Collator.getInstance();
            c.setStrength(Collator.PRIMARY);
            return c.compare(this.nome, pais.getNome());
        }
    }
}
