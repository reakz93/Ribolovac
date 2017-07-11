package android.fkvestak.com.ribolovac.database;

import android.database.Cursor;
import android.database.CursorWrapper;
import android.fkvestak.com.ribolovac.Album.Album;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Kvec on 10.11.2016..
 */

public class AlbumCursorWrapper extends CursorWrapper {

    public AlbumCursorWrapper(Cursor cursor){
        super(cursor);
    }

    public Album getAlbum(){
        String uuidString = getString(getColumnIndex(AlbumDbSchema.AlbumTable.Cols.UUID));
        String title = getString(getColumnIndex(AlbumDbSchema.AlbumTable.Cols.TITLE));
        long date = getLong(getColumnIndex(AlbumDbSchema.AlbumTable.Cols.DATE));
        String lokacija = getString(getColumnIndex(AlbumDbSchema.AlbumTable.Cols.LOKACIJA));
        String mamac = getString(getColumnIndex(AlbumDbSchema.AlbumTable.Cols.MAMAC));
        String tezina = getString(getColumnIndex(AlbumDbSchema.AlbumTable.Cols.TEZINA));
        String velicina = getString(getColumnIndex(AlbumDbSchema.AlbumTable.Cols.VELICINA));

        Album album = new Album(UUID.fromString(uuidString));
        album.setNaziv(title);
        album.setDate(new Date(date));
        album.setLokacija(lokacija);
        album.setMamac(mamac);
        album.setTezina(tezina);
        album.setVelicina(velicina);

        return album;
    }

}
