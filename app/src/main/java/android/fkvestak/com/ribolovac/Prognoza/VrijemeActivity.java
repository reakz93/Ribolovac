package android.fkvestak.com.ribolovac.Prognoza;

import android.content.Context;
import android.content.Intent;
import android.fkvestak.com.ribolovac.R;
import android.fkvestak.com.ribolovac.SingleFragmentActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Kvec on 30.11.2016..
 */

public class VrijemeActivity extends SingleFragmentActivity {

    public static final String EXTRA_LINK = "com.fkvestak.android.ribolovac.vrijeme_link";

    public static Intent newIntent(Context packageContext, String link){
        Intent intent = new Intent(packageContext, VrijemeActivity.class);
        intent.putExtra(EXTRA_LINK, link);
        return intent;
    }

    @Override
    protected Fragment createFragment(){
        String x = (String)getIntent().getSerializableExtra(EXTRA_LINK);
        return VrijemeFragment.newInstance(x);
    }

}
