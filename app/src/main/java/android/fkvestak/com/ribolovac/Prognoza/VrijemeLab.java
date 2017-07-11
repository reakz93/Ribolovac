package android.fkvestak.com.ribolovac.Prognoza;

import android.content.Context;
import android.fkvestak.com.ribolovac.Vodostaj.VodostajLab;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kvec on 30.11.2016..
 */

public class VrijemeLab {

    private static VrijemeLab sVrijemeLab;
    private List<Vrijeme> mVrijeme;

    private List<String> popis_datum;
    private List<String> popis_dan_temp;
    private List<String> popis_noc_temp;

    public static VrijemeLab get(Context context) {
        if (sVrijemeLab == null){
            sVrijemeLab = new VrijemeLab(context);
        }
        return sVrijemeLab;
    }

    private VrijemeLab (Context context) {
        mVrijeme = new ArrayList<>();
    }

    public VrijemeLab(List<String> l1, List<String> l2, List<String> l3){
        mVrijeme = new ArrayList<>();
        popis_datum = new ArrayList<>();
        popis_datum = l1;
        popis_dan_temp = new ArrayList<>();
        popis_dan_temp = l2;
        popis_noc_temp = new ArrayList<>();
        popis_noc_temp = l3;
        for (int i=0; i<popis_datum.size(); i++){
            Vrijeme vrijeme = new Vrijeme();
            vrijeme.setDatum(popis_datum.get(i));
            vrijeme.setDan_temp(popis_dan_temp.get(i));
            vrijeme.setNoc_temp(popis_noc_temp.get(i));
            mVrijeme.add(vrijeme);
        }
    }

    public List<Vrijeme> getVrijeme() {
        return mVrijeme;
    }
}
