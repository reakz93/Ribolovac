package android.fkvestak.com.ribolovac.Ribe;

import android.fkvestak.com.ribolovac.SingleFragmentActivity;
import android.support.v4.app.Fragment;

/**
 * Created by Kvec on 26.10.2016..
 */

public class RibeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment(){
        return new RibeListFragment();
    }

}
