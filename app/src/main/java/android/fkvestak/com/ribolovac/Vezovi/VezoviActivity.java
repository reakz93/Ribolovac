package android.fkvestak.com.ribolovac.Vezovi;

import android.fkvestak.com.ribolovac.R;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * Created by Kvec on 1.12.2016..
 */

public class VezoviActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vezovi);

        ViewPager viewPager = (ViewPager) findViewById(R.id.vezovi_pager);
        viewPager.setAdapter(new CustomPagerAdapterVezovi(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater findMenuItems = getMenuInflater();
        findMenuItems.inflate(R.menu.activity_vezovi, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menu_item_info:
                Toast.makeText(this, "Povuci desno/lijevo za pregledavanje", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
