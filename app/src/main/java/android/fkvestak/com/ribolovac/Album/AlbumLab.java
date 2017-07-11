package android.fkvestak.com.ribolovac.Album;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.fkvestak.com.ribolovac.database.AlbumBaseHelper;
import android.fkvestak.com.ribolovac.database.AlbumCursorWrapper;
import android.fkvestak.com.ribolovac.database.AlbumDbSchema;
import android.os.Environment;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Kvec on 9.11.2016..
 */

public class AlbumLab {

    private static AlbumLab sAlbumLab;

    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static AlbumLab get(Context context){
        if (sAlbumLab == null) {
            sAlbumLab = new AlbumLab(context);
        }
        return sAlbumLab;
    }

    private AlbumLab(Context context){
        mContext = context.getApplicationContext();
        mDatabase = new AlbumBaseHelper(mContext).getWritableDatabase();

    }

    public void addAlbum(Album a) {
        ContentValues values = getContentValues(a);
        mDatabase.insert(AlbumDbSchema.AlbumTable.NAME, null, values);
    }

    public void deleteAlbum(UUID albumId) {
        String uuidString = albumId.toString();
        mDatabase.delete(AlbumDbSchema.AlbumTable.NAME, AlbumDbSchema.AlbumTable.Cols.UUID + " =?", new String[]{uuidString});
    }

    public List<Album> getAlbums() {
        List<Album> albums = new ArrayList<>();

        AlbumCursorWrapper cursor = queryAlbums(null, null);

        try{
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                albums.add(cursor.getAlbum());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }
        return albums;
    }

    public Album getAlbum(UUID id) {
        AlbumCursorWrapper cursor = queryAlbums(AlbumDbSchema.AlbumTable.Cols.UUID + " =?", new String[]{id.toString()});
        try{
            if (cursor.getCount() == 0) {
                return null;
            }
            cursor.moveToFirst();
            return cursor.getAlbum();
        }finally {
            cursor.close();
        }
    }

    public File getPhotoFile(Album album){
        File externalFilesDir = mContext.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        if (externalFilesDir == null) {
            return null;
        }
        return new File(externalFilesDir, album.getPhotoFilename());
    }

    public void updateAlbum(Album album) {
        String uuidString = album.getId().toString();
        ContentValues values = getContentValues(album);

        mDatabase.update(AlbumDbSchema.AlbumTable.NAME, values, AlbumDbSchema.AlbumTable.Cols.UUID + " =?", new String[]{uuidString});
    }

    private static ContentValues getContentValues(Album album){
        ContentValues values = new ContentValues();
        values.put(AlbumDbSchema.AlbumTable.Cols.UUID, album.getId().toString());
        values.put(AlbumDbSchema.AlbumTable.Cols.TITLE, album.getNaziv());
        values.put(AlbumDbSchema.AlbumTable.Cols.DATE, album.getDate().getTime());
        values.put(AlbumDbSchema.AlbumTable.Cols.LOKACIJA, album.getLokacija());
        values.put(AlbumDbSchema.AlbumTable.Cols.MAMAC, album.getMamac());
        values.put(AlbumDbSchema.AlbumTable.Cols.TEZINA, album.getTezina());
        values.put(AlbumDbSchema.AlbumTable.Cols.VELICINA, album.getVelicina());

        return values;
    }

    private AlbumCursorWrapper queryAlbums(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                AlbumDbSchema.AlbumTable.NAME,
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null
        );
        return new AlbumCursorWrapper(cursor);
    }

}
