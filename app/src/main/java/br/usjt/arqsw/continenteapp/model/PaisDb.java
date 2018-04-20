package br.usjt.arqsw.continenteapp.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Date;

import static br.usjt.arqsw.continenteapp.model.PaisDbContract.PaisBanco;

/**
 * Created by Auguston on 20/04/2018.
 */

public class PaisDb {

    private PaisDbHelper dbHelper;

    public PaisDb(Context context) {
        this.dbHelper = new PaisDbHelper(context);
    }

    public void inserirPais(ArrayList<Pais> paises) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        for (Pais pais : paises) {
            values.put(PaisBanco.NM_PAIS, pais.getNome());
            values.put(PaisBanco.NM_CAPITAL, pais.getCapital());
            values.put(PaisBanco.NM_REGIAO, pais.getRegiao());
            values.put(PaisBanco.NM_FIGURA, pais.getBandeira());
            long data;
            try{
                data = pais.getDataAtualizacao().getTime();
            } catch(Exception e){
                data = 1L;
            }
            values.put(PaisBanco.DT_ATUAL, data);
            values.put(PaisBanco.IMG_FIGURA, getPictureByteOfArray(pais.getImagem()));

            db.insert(PaisBanco.TABLE_NAME, null, values);
        }
        db.close();
    }

    public ArrayList<Pais> listarPaises() {
        ArrayList<Pais> paises = new ArrayList<>();

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] colunas = {PaisBanco.NM_PAIS, PaisBanco.NM_CAPITAL,
                PaisBanco.NM_REGIAO, PaisBanco.DT_ATUAL, PaisBanco.IMG_FIGURA};

        String orderBy = PaisBanco.DT_ATUAL;

        Cursor c;

        c = db.query(PaisBanco.TABLE_NAME, colunas, null,
                null, null, null, orderBy);

        while (c.moveToNext()){
            Pais pais = new Pais();
            pais.setNome(c.getString(c.getColumnIndex(PaisBanco.NM_PAIS)));
            pais.setCapital(c.getString(c.getColumnIndex(PaisBanco.NM_CAPITAL)));
            pais.setRegiao(c.getString(c.getColumnIndex(PaisBanco.NM_REGIAO)));
            pais.setBandeira((c.getString(c.getColumnIndex(PaisBanco.NM_FIGURA))));
            try {
                pais.setDataAtualizacao(new Date(c.getLong(c.getColumnIndex(PaisBanco.DT_ATUAL))));
            } catch(Exception e){
                pais.setDataAtualizacao(new Date(1L));
            }
            pais.setImagem(getBitmapFromByte(c.getBlob(c.getColumnIndex(PaisBanco.IMG_FIGURA))));

            paises.add(pais);
        }
        c.close();
        db.close();
        return paises;
    }

    public void atualizaPaises(ArrayList<Pais> paises) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        //deleta flas
        String selecao = PaisBanco.NM_PAIS +"= ?";
        String[] selectionArgs = new String[1];

        for (Pais pais: paises) {
            selectionArgs[0] = ""+pais.getNome();
            db.delete(PaisBanco.TABLE_NAME, selecao, selectionArgs);
        }


        //insere filas
        ContentValues values = new ContentValues();

        for (Pais fila : paises) {
            values.put(PaisBanco.NM_PAIS, fila.getNome());
            values.put(PaisBanco.NM_CAPITAL, fila.getCapital());
            values.put(PaisBanco.NM_REGIAO, fila.getRegiao());
            values.put(PaisBanco.NM_FIGURA, fila.getBandeira());
            values.put(PaisBanco.DT_ATUAL, fila.getDataAtualizacao().getTime());
            values.put(PaisBanco.IMG_FIGURA, getPictureByteOfArray(fila.getImagem()));

            db.insert(PaisBanco.TABLE_NAME, null, values);
        }
        db.close();
    }

    private byte[] getPictureByteOfArray(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    private Bitmap getBitmapFromByte(byte[] image) {
        return BitmapFactory.decodeByteArray(image, 0, image.length);
    }
}
