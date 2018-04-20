package br.usjt.arqsw.continenteapp.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static br.usjt.arqsw.continenteapp.model.PaisDbContract.PaisBanco;

/**
 * Created by Auguston on 20/04/2018.
 */

public class PaisDbHelper extends SQLiteOpenHelper {

    public static final String SQL_CREATE_FILA =
            "CREATE TABLE " + PaisBanco.TABLE_NAME + " ( " +
                    PaisBanco._ID + " INTEGER PRIMARY KEY, " +
                    PaisBanco.NM_PAIS + " TEXT, " +
                    PaisBanco.NM_CAPITAL + " TEXT, " +
                    PaisBanco.NM_REGIAO + " TEXT, " +
                    PaisBanco.NM_FIGURA + " TEXT, " +
                    PaisBanco.DT_ATUAL + " INTEGER," +
                    PaisBanco.IMG_FIGURA + " BLOB ) ";

    public static final String SQL_DROP_FILA = "DROP TABLE IF EXISTS " + PaisBanco.TABLE_NAME;

    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "Pais.db";


    public PaisDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_FILA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(SQL_DROP_FILA);
        db.execSQL(SQL_CREATE_FILA);
    }
}
