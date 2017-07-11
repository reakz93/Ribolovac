package android.fkvestak.com.ribolovac.Vezovi;

import android.fkvestak.com.ribolovac.R;

/**
 * Created by Kvec on 1.12.2016..
 */

public enum CustomPagerEnumVezovi {

    vez_1_palomar(R.string.vezovi_1_palomar, R.layout.activity_vezovi_1_palomar),
    vez_2_improvedclinch(R.string.vezovi_2_improvedclinch, R.layout.activity_vezovi_2_improvedclinch),
    vez_3_trilene(R.string.vezovi_3_trileneknot, R.layout.activity_vezovi_3_trilene),
    vez_4_unislip(R.string.vezovi_4_unislip, R.layout.activity_vezovi_4_unislip),
    vez_5_sandiego(R.string.vezovi_5_sandiego, R.layout.activity_vezovi_5_sandiego),
    vez_6_snell(R.string.vezovi_6_snell, R.layout.activity_vezovi_6_snell),
    vez_7_rapala(R.string.vezovi_7_rapalaloop, R.layout.activity_vezovi_7_rapala),
    vez_8_eugene(R.string.vezovi_8_eugene, R.layout.activity_vezovi_8_eugene),
    vez_9_alberto(R.string.vezovi_9_alberto, R.layout.activity_vezovi_9_alberto),
    vez_10_twounijoin(R.string.vezovi_10_twounijoin, R.layout.activity_vezovi_10_twounijoin),
    vez_11_yucatan(R.string.vezovi_11_yucatan, R.layout.activity_vezovi_11_yucatan),
    vez_12_j(R.string.vezovi_12_j, R.layout.activity_vezovi_12_j),
    vez_13_doublelineuni(R.string.vezovi_13_doublelineuni, R.layout.activity_vezovi_13_doublelineuni),
    vez_14_doublesandiego(R.string.vezovi_14_doublesandiego, R.layout.activity_vezovi_14_doublesandiego),
    vez_15_arbor(R.string.vezovi_15_arbor, R.layout.activity_vezovi_15_arbor);

    private int mTitleResId;
    private int mLayoutResId;

    CustomPagerEnumVezovi(int titleResId, int layoutResId) {
        mTitleResId = titleResId;
        mLayoutResId = layoutResId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }

}
