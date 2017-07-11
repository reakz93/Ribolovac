package android.fkvestak.com.ribolovac.Lovostaj;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Kvec on 26.10.2016..
 */

public class LovostajLab {

    private static LovostajLab sLovostajLab;
    private List<Lovostaj> mLovostaj;

    String[] ribePopis = {"Bolen", "Deverika", "Glavatica", "Kečiga", "Klen", "Linjak", "Lipljan", "", "Mladica", "Mrena",
        "Pastrva jezerska", "Pastrva mekousna zlousna", "Pastrva mekousna solinka", "Pastrva potočna", "", "",
        "Smuđ", "Som", "Šaran pitomi", "Šaran divlji", "Štuka"};

    String[] ribePodrucje = {"-", "-", "-", "-", "-", "-", "rijeka Kupa i Kupica", "ostale vode", "-", "-",
        "-", "rijeka Krka", "-", "Kupa, Kupica, Čabranka, Park prirode Žumberak", "ostale vode", "Gacka",
        "-", "Ne odnosi se na rijeku Dunav", "-", "-", "-"};

    String[] ribeVrijeme = {"01.04. - 31.05.", "15.04. - 31.05.", "16.2. - 30.09.", "01.03. - 31.05.", "15.04. - 31.05.", "Trajni lovostaj!", "16.10. - 15.05.", "01.01. - 15.05.", "16.02. - 30.09.", "Ne postoji",
        "01.10. - 28.02.", "01.10. - 31.05.", "01.10. - 31.05.", "01.10. - 31.03.", "01.10. - 28/29.02.", "/",
        "01.03. - 31.05.", "16.04. - 15.06.", "Ne postoji", "01.04. - 31.05.", "01.02. - 31.03."};

    String[] ribeVelicina = {"25 cm", "-", "-", "40 cm", "-", "20 cm", "32 cm", "30 cm", "-", "28 cm",
        "40 cm", "30 cm", "30 cm", "30 cm", "30 cm", "50 cm",
        "40 cm", "60 cm", "40 cm", "40 cm", "40cm"};

    public static LovostajLab get(Context context){
        if (sLovostajLab == null){
            sLovostajLab = new LovostajLab(context);
        }
        return sLovostajLab;
    }

    private LovostajLab(Context context){
        mLovostaj = new ArrayList<>();
        for (int i=0; i<ribePopis.length; i++) {
            Lovostaj lovostaj = new Lovostaj();
            lovostaj.setNaziv(ribePopis[i]);
            lovostaj.setPodrucje(ribePodrucje[i]);
            lovostaj.setVrijeme(ribeVrijeme[i]);
            lovostaj.setVelicina(ribeVelicina[i]);
            mLovostaj.add(lovostaj);
        }
    }

    public List<Lovostaj> getLovostaj(){
        return mLovostaj;
    }

    public Lovostaj getLovostaj(UUID id) {
        for (Lovostaj lovostaj : mLovostaj) {
            if (lovostaj.getId().equals(id)){
                return lovostaj;
            }
        }
        return null;
    }

}
