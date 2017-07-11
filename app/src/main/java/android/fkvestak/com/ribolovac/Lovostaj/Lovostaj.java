package android.fkvestak.com.ribolovac.Lovostaj;

import java.util.UUID;

/**
 * Created by Kvec on 26.10.2016..
 */

public class Lovostaj {

    private UUID mId;
    private String mNaziv;
    private String mPodrucje;
    private String mVrijeme;
    private String mVelicina;

    public UUID getId() {
        return mId;
    }

    public String getNaziv() {
        return mNaziv;
    }

    public void setNaziv(String naziv) {
        mNaziv = naziv;
    }

    public String getPodrucje() {
        return mPodrucje;
    }

    public void setPodrucje(String podrucje) {
        mPodrucje = podrucje;
    }

    public String getVrijeme() {
        return mVrijeme;
    }

    public void setVrijeme(String vrijeme) {
        mVrijeme = vrijeme;
    }

    public String getVelicina() {
        return mVelicina;
    }

    public void setVelicina(String velicina) {
        mVelicina = velicina;
    }
}
