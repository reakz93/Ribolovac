package android.fkvestak.com.ribolovac;

import android.content.Intent;
import android.fkvestak.com.ribolovac.Album.AlbumListActivity;
import android.fkvestak.com.ribolovac.Drustva.Drustva;
import android.fkvestak.com.ribolovac.Lovostaj.LovostajActivity;
import android.fkvestak.com.ribolovac.Prognoza.VrijemeListActivity;
import android.fkvestak.com.ribolovac.Ribe.RibeListActivity;
import android.fkvestak.com.ribolovac.Sistemi.SistemActivity;
import android.fkvestak.com.ribolovac.Vezovi.VezoviActivity;
import android.fkvestak.com.ribolovac.Vodostaj.VodostajActivity;
import android.fkvestak.com.ribolovac.Zakon.ZakonActivity;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.io.InputStream;

public class MenuActivity extends AppCompatActivity {

    private ImageButton mImageButtonRibe;
    private ImageButton mImageButtonLovostaj;
    private ImageButton mImageButtonDrustva;
    private ImageButton mImageButtonAlbum;
    private ImageButton mImageButtonVodostaj;
    private ImageButton mImageButtonVrijeme;
    private ImageButton mImageButtonZakon;
    private ImageButton mImageButtonSistemi;
    private ImageButton mImageButtonVezovi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mImageButtonRibe = (ImageButton)findViewById(R.id.imageButton_ribe);
        mImageButtonRibe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, RibeListActivity.class);
                startActivity(intent);
            }
        });

        mImageButtonLovostaj = (ImageButton)findViewById(R.id.imageButton_lovostaj);
        mImageButtonLovostaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, LovostajActivity.class);
                startActivity(intent);
            }
        });

        mImageButtonDrustva = (ImageButton)findViewById(R.id.imageButton_drustva);
        mImageButtonDrustva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, Drustva.class);
                startActivity(intent);
            }
        });

        mImageButtonAlbum = (ImageButton)findViewById(R.id.imageButton_album);
        mImageButtonAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, AlbumListActivity.class);
                startActivity(intent);
            }
        });

        mImageButtonVodostaj = (ImageButton)findViewById(R.id.imageButton_vodostaj);
        mImageButtonVodostaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, VodostajActivity.class);
                startActivity(intent);
            }
        });

        mImageButtonVrijeme = (ImageButton)findViewById(R.id.imageButton_vrijeme);
        mImageButtonVrijeme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, VrijemeListActivity.class);
                startActivity(intent);
            }
        });

        mImageButtonZakon = (ImageButton)findViewById(R.id.imageButton_zakon);
        mImageButtonZakon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, ZakonActivity.class);
                startActivity(intent);
            }
        });

        mImageButtonSistemi = (ImageButton) findViewById(R.id.imageButton_sistemi);
        mImageButtonSistemi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, SistemActivity.class);
                startActivity(intent);
            }
        });

        mImageButtonVezovi = (ImageButton) findViewById(R.id.imageButton_vezovi);
        mImageButtonVezovi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, VezoviActivity.class);
                startActivity(intent);
            }
        });

    }
}
