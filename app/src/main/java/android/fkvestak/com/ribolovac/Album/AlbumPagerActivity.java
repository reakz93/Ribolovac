package android.fkvestak.com.ribolovac.Album;

import android.content.Context;
import android.content.Intent;
import android.fkvestak.com.ribolovac.R;
import android.fkvestak.com.ribolovac.SingleFragmentActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.List;
import java.util.UUID;

/**
 * Created by Kvec on 9.11.2016..
 */

public class AlbumPagerActivity extends AppCompatActivity {

    private static final String EXTRA_ALBUM_ID = "com.fkvestak.android.ribolovac.album_id";

    private ViewPager mViewPager;
    private List<Album> mAlbums;

    public static Intent newIntent(Context packageContext, UUID albumId) {
        Intent intent = new Intent(packageContext, AlbumPagerActivity.class);
        intent.putExtra(EXTRA_ALBUM_ID, albumId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_pager);

        UUID albumId = (UUID) getIntent().getSerializableExtra(EXTRA_ALBUM_ID);

        mViewPager = (ViewPager)findViewById(R.id.acrivity_album_pager_view_pager);

        mAlbums = AlbumLab.get(this).getAlbums();
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Album album = mAlbums.get(position);
                return AlbumFragment.newInstance(album.getId());
            }

            @Override
            public int getCount() {
                return mAlbums.size();
            }
        });

        for (int i=0; i<mAlbums.size(); i++) {
            if (mAlbums.get(i).getId().equals(albumId)) {
                mViewPager.setCurrentItem(i);
                break;
            }
        }

    }

}
