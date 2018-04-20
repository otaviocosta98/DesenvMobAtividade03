package br.usjt.arqsw.continenteapp.model;

import android.provider.BaseColumns;

/**
 * Created by Auguston on 20/04/2018.
 */

public class PaisDbContract {

    public PaisDbContract() {
    }

    public static abstract class PaisBanco implements BaseColumns {
        public static final String TABLE_NAME = "Pais";
        public static final String NM_PAIS = "nm_pais";
        public static final String NM_CAPITAL = "nm_capital";
        public static final String NM_REGIAO = "nm_regiao";
        public static final String NM_FIGURA = "nm_bandeira";
        public static final String DT_ATUAL = "dt_atual";
        public static final String IMG_FIGURA = "img_figura";
    }

}
