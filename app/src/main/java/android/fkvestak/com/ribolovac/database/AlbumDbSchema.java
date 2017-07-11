package android.fkvestak.com.ribolovac.database;

/**
 * Created by Kvec on 10.11.2016..
 */

public class AlbumDbSchema {

    public static final class AlbumTable {
        public static final String NAME = "albums";

        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String TITLE = "title";
            public static final String DATE = "date";
            public static final String LOKACIJA = "lokacija";
            public static final String MAMAC = "mamac";
            public static final String TEZINA = "tezina";
            public static final String VELICINA = "velicina";
        }
    }

}
