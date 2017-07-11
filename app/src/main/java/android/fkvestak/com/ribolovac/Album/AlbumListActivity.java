package android.fkvestak.com.ribolovac.Album;

import android.fkvestak.com.ribolovac.SingleFragmentActivity;
import android.support.v4.app.Fragment;

/**
 * Created by Kvec on 9.11.2016..
 */

public class AlbumListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment(){
        return new AlbumListFragment();
    }
}
