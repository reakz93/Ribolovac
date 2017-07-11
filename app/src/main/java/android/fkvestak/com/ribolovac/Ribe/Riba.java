package android.fkvestak.com.ribolovac.Ribe;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Kvec on 26.10.2016..
 */

public class Riba {

    private UUID mId;
    private String mNaziv;

    public Riba() {
        mId = UUID.randomUUID();
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

}
