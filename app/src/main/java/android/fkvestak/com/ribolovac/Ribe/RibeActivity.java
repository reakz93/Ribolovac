package android.fkvestak.com.ribolovac.Ribe;

import android.content.Context;
import android.content.Intent;
import android.fkvestak.com.ribolovac.SingleFragmentActivity;
import android.support.v4.app.Fragment;

import java.util.UUID;

/**
 * Created by Kvec on 26.10.2016..
 */

public class RibeActivity extends SingleFragmentActivity {

    private static final String EXTRA_RIBA_ID = "com.fkvestak.android.ribolovac.riba_id";

    public static Intent newIntent(Context packageContext, UUID ribaId) {
        Intent intent = new Intent(packageContext, RibeActivity.class);
        intent.putExtra(EXTRA_RIBA_ID, ribaId);
        return intent;
    }

    @Override
    protected Fragment createFragment(){
        UUID ribaId = (UUID) getIntent().getSerializableExtra(EXTRA_RIBA_ID);
        return RibeFragment.newInstance(ribaId);
    }

}
