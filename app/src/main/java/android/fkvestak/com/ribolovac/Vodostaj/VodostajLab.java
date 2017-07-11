package android.fkvestak.com.ribolovac.Vodostaj;

import android.content.Context;
import android.fkvestak.com.ribolovac.Lovostaj.Lovostaj;
import android.util.Log;
import android.view.LayoutInflater;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kvec on 18.11.2016..
 */

public class VodostajLab {

    private static VodostajLab sVodostajLab;
    private List<Vodostaj> mVodostaj;

    private List<String> popis_postaja;
    private List<String> popis_vodotok;
    private List<String> popis_datum;
    private List<String> popis_razina;

    public static VodostajLab get(Context context){
        if (sVodostajLab == null){
            sVodostajLab = new VodostajLab(context);
        }
        return sVodostajLab;
    }

    private VodostajLab(Context context){
        mVodostaj = new ArrayList<>();
    }

    public VodostajLab(List<String> l1, List<String> l2, List<String> l3, List<String> l4){
        mVodostaj = new ArrayList<>();
        popis_postaja = new ArrayList<>();
        popis_postaja = l1;
        popis_vodotok = new ArrayList<>();
        popis_vodotok = l2;
        popis_datum = new ArrayList<>();
        popis_datum = l3;
        popis_razina = new ArrayList<>();
        popis_razina = l4;
        for (int i=0; i<popis_postaja.size(); i++){
            Vodostaj vodostaj = new Vodostaj();
            vodostaj.setPostaja(popis_postaja.get(i));
            vodostaj.setVodotok(popis_vodotok.get(i));
            vodostaj.setDatum(popis_datum.get(i));
            vodostaj.setRazina(popis_razina.get(i));
            if (!vodostaj.getPostaja().equals("Postaja")) {
                mVodostaj.add(vodostaj);
            }
        }
    }

    public List<Vodostaj> getVodostaj(){
        return mVodostaj;
    }

}
