package android.fkvestak.com.ribolovac.Lovostaj;

import android.fkvestak.com.ribolovac.SingleFragmentActivity;
import android.support.v4.app.Fragment;

/**
 * Created by Kvec on 26.10.2016..
 */

public class LovostajActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment(){
        return new LovostajFragment();
    }
}
