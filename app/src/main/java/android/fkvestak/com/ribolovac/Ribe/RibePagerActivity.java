package android.fkvestak.com.ribolovac.Ribe;

import android.content.Context;
import android.content.Intent;
import android.fkvestak.com.ribolovac.R;
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
 * Created by Kvec on 26.10.2016..
 */

public class RibePagerActivity extends AppCompatActivity {

    private static final String EXTRA_RIBA_ID = "com.fkvestak.android.ribolovac.riba_id";

    private ViewPager mViewPager;
    private List<Riba> mRibe;

    public static Intent newIntent(Context packageContext, UUID ribaId) {
        Intent intent = new Intent(packageContext, RibePagerActivity.class);
        intent.putExtra(EXTRA_RIBA_ID, ribaId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ribe_pager);

        UUID ribaId = (UUID) getIntent().getSerializableExtra(EXTRA_RIBA_ID);

        mViewPager = (ViewPager)findViewById(R.id.activity_ribe_pager_view_pager);

        mRibe = RibeLab.get(this).getRibe();
        FragmentManager fm = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
            @Override
            public Fragment getItem(int position) {
                Riba riba = mRibe.get(position);
                return RibeFragment.newInstance(riba.getId());
            }

            @Override
            public int getCount() {
                return mRibe.size();
            }
        });

        for (int i = 0; i<mRibe.size(); i++) {
            if (mRibe.get(i).getId().equals(ribaId)) {
                mViewPager.setCurrentItem(i);
                break;
            }
        }

    }

}
