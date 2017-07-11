package android.fkvestak.com.ribolovac.Sistemi;

import android.fkvestak.com.ribolovac.R;

/**
 * Created by Kvec on 1.12.2016..
 */

public enum CustomPagerEnum {

    ObicnaBalerina(R.string.sistemi_obicnabalerina, R.layout.activity_sistem_obicnabalerina),
    UsidrenaBalerina(R.string.sistemi_usidrenabalerina, R.layout.activity_sistem_usidrenabalerina),
    PovrsinskiKlizni(R.string.sistemi_povrsinskisakliznimplovkom, R.layout.activity_sistem_povrsinskiklizni),
    ObrnutiPovrsinski(R.string.sistemi_obrnutipovrsinski, R.layout.activity_sistem_obrnutipovrsinski),
    Dubinski(R.string.sistemi_dubinski, R.layout.activity_sistem_dubinski),
    Potopljeni(R.string.sistemi_potopljeniplovak, R.layout.activity_sistem_potopljeni);

    private int mTitleResId;
    private int mLayoutResId;

    CustomPagerEnum(int titleResId, int layoutResId) {
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
