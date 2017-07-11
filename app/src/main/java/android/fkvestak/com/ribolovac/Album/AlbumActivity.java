package android.fkvestak.com.ribolovac.Album;

import android.content.Context;
import android.content.Intent;
import android.fkvestak.com.ribolovac.R;
import android.fkvestak.com.ribolovac.SingleFragmentActivity;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import java.util.UUID;

/**
 * Created by Kvec on 9.11.2016..
 */

public class AlbumActivity extends SingleFragmentActivity {

    private static final String EXTRA_ALBUM_ID = "com.fkvestak.android.ribolovac.album_id";

    public static Intent newIntent(Context packageContext, UUID albumId) {
        Intent intent = new Intent(packageContext, AlbumActivity.class);
        intent.putExtra(EXTRA_ALBUM_ID, albumId);
        return intent;
    }

    @Override
    protected Fragment createFragment(){
        UUID albumId = (UUID)getIntent().getSerializableExtra(EXTRA_ALBUM_ID);
        return AlbumFragment.newInstance(albumId);
    }

}
