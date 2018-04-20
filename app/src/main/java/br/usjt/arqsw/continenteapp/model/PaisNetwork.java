package br.usjt.arqsw.continenteapp.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Auguston on 20/04/2018.
 */

public class PaisNetwork {

    public static ArrayList<Pais> buscarPaises(String urlRest, String urlImg) throws IOException{
        ArrayList<Pais> paises = getPaises(urlRest);
        for(Pais pais : paises){
            pais.setImagem(getBandeira(urlImg+pais.getBandeira()+".png"));
        }
        return paises;
    }

    public static ArrayList<Pais> getPaises(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        ArrayList<Pais> paises = new ArrayList<>();
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        String json = response.body().string();
        try {
            JSONArray lista = new JSONArray(json);
            for (int i = 0; i < lista.length(); i++){
                JSONObject item = (JSONObject)  lista.get(i);
                Pais pais = new Pais();
                pais.setNome(item.getString("nome"));
                pais.setCapital(item.getString("capital"));
                pais.setRegiao(item.getString("regiao"));
                pais.setBandeira(item.getString("bandeira"));
                paises.add(pais);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            throw new IOException(e);
        }
        return paises;
    }

    public static Bitmap getBandeira(String url) throws IOException {
        Bitmap img = null;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        InputStream is = response.body().byteStream();
        img = BitmapFactory.decodeStream(is);
        is.close();
        return img;
    }
}
