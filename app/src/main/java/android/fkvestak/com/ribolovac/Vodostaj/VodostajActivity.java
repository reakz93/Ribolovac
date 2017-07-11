package android.fkvestak.com.ribolovac.Vodostaj;

import android.fkvestak.com.ribolovac.SingleFragmentActivity;
import android.support.v4.app.Fragment;
import android.widget.Toast;

/**
 * Created by Kvec on 18.11.2016..
 */

public class VodostajActivity extends SingleFragmentActivity{
    @Override
    protected Fragment createFragment(){
        Toast.makeText(this, "Dohvaćanje podataka o vodostaju", Toast.LENGTH_SHORT).show();
        return new VodostajFragment();
    }
}
