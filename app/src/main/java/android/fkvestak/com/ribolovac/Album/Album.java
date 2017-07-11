package android.fkvestak.com.ribolovac.Album;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Kvec on 9.11.2016..
 */

public class Album {

    private UUID mId;
    private String mNaziv;
    private Date mDate;
    private String mLokacija;
    private String mMamac;
    private String mTezina;
    private String mVelicina;

    public Album(){
        this(UUID.randomUUID());
    }

    public Album(UUID id) {
        mId = id;
        mDate = new Date();
    }

    public UUID getId() {
        return mId;
    }

    public String getNaziv() {
        return mNaziv;
    }

    public void setNaziv(String naziv) {
        mNaziv = naziv;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public String getPhotoFilename(){
        return "IMG_" + getId().toString() + ".jpg";
    }

    public String getLokacija() {
        return mLokacija;
    }

    public void setLokacija(String lokacija) {
        mLokacija = lokacija;
    }

    public String getMamac() {
        return mMamac;
    }

    public void setMamac(String mamac) {
        mMamac = mamac;
    }

    public String getTezina() {
        return mTezina;
    }

    public void setTezina(String tezina) {
        mTezina = tezina;
    }

    public String getVelicina() {
        return mVelicina;
    }

    public void setVelicina(String velicina) {
        mVelicina = velicina;
    }
}
