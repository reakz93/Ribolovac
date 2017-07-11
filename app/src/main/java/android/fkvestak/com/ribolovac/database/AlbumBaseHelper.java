package android.fkvestak.com.ribolovac.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Kvec on 10.11.2016..
 */

public class AlbumBaseHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "albumBase.db";

    public AlbumBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + AlbumDbSchema.AlbumTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                AlbumDbSchema.AlbumTable.Cols.UUID + ", " +
                AlbumDbSchema.AlbumTable.Cols.TITLE + ", " +
                AlbumDbSchema.AlbumTable.Cols.DATE + ", " +
                AlbumDbSchema.AlbumTable.Cols.LOKACIJA + ", " +
                AlbumDbSchema.AlbumTable.Cols.MAMAC + ", " +
                AlbumDbSchema.AlbumTable.Cols.TEZINA + ", " +
                AlbumDbSchema.AlbumTable.Cols.VELICINA +
                ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
