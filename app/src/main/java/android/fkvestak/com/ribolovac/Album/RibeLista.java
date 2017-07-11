package android.fkvestak.com.ribolovac.Album;

import android.app.Activity;
import android.content.Intent;
import android.fkvestak.com.ribolovac.R;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

/**
 * Created by Kvec on 7.12.2016..
 */

public class RibeLista extends AppCompatActivity {

    public static final String EXTRA_RIBA_ODABRANA = "odabranaRiba";

    private int pozicija = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ribe_grid);

        GridView gridView = (GridView) findViewById(R.id.ribe_gridview);
        gridView.setAdapter(new ImageAdapter(this));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra(EXTRA_RIBA_ODABRANA, position);
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        });
    }
}
