package android.fkvestak.com.ribolovac.Zakon;

import android.fkvestak.com.ribolovac.R;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Kvec on 1.12.2016..
 */

public class ZakonActivity extends AppCompatActivity {

    private TextView mTextView_zakonNaslov;
    private TextView mTextView_zakonHeader;
    private TextView mTextView_zakonHeaderTekst;
    private TextView mTextView_z1;
    private TextView mTextView_z1s;
    private TextView mTextView_z2;
    private TextView mTextView_z2s;
    private TextView mTextView_z3;
    private TextView mTextView_z3s;
    private TextView mTextView_z4;
    private TextView mTextView_z4s;
    private TextView mTextView_z5;
    private TextView mTextView_z5s;
    private TextView mTextView_z6;
    private TextView mTextView_z6s;
    private TextView mTextView_z7;
    private TextView mTextView_z7s;
    private TextView mTextView_z8;
    private TextView mTextView_z8s;
    private TextView mTextView_z9;
    private TextView mTextView_z9s;
    private TextView mTextView_z10;
    private TextView mTextView_z10s;
    private TextView mTextView_z11;
    private TextView mTextView_z11s;
    private TextView mTextView_z12;
    private TextView mTextView_z12s;
    private TextView mTextView_z13;
    private TextView mTextView_z13s;
    private TextView mTextView_zakon_footer;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zakon);

        mTextView_zakonNaslov = (TextView) findViewById(R.id.textView_zakon_naslov);
        mTextView_zakonHeader = (TextView) findViewById(R.id.textView_zakon_header);
        mTextView_zakonHeaderTekst = (TextView) findViewById(R.id.textView_zakon_header_tekst);
        mTextView_z1 = (TextView) findViewById(R.id.textView_zakon1);
        mTextView_z1s = (TextView) findViewById(R.id.textView_zakon1s);
        mTextView_z2 = (TextView) findViewById(R.id.textView_zakon2);
        mTextView_z2s = (TextView) findViewById(R.id.textView_zakon2s);
        mTextView_z3 = (TextView) findViewById(R.id.textView_zakon3);
        mTextView_z3s = (TextView) findViewById(R.id.textView_zakon3s);
        mTextView_z4 = (TextView) findViewById(R.id.textView_zakon4);
        mTextView_z4s = (TextView) findViewById(R.id.textView_zakon4s);
        mTextView_z5 = (TextView) findViewById(R.id.textView_zakon5);
        mTextView_z5s = (TextView) findViewById(R.id.textView_zakon5s);
        mTextView_z6 = (TextView) findViewById(R.id.textView_zakon6);
        mTextView_z6s = (TextView) findViewById(R.id.textView_zakon6s);
        mTextView_z7 = (TextView) findViewById(R.id.textView_zakon7);
        mTextView_z7s = (TextView) findViewById(R.id.textView_zakon7s);
        mTextView_z8 = (TextView) findViewById(R.id.textView_zakon8);
        mTextView_z8s = (TextView) findViewById(R.id.textView_zakon8s);
        mTextView_z9 = (TextView) findViewById(R.id.textView_zakon9);
        mTextView_z9s = (TextView) findViewById(R.id.textView_zakon9s);
        mTextView_z10 = (TextView) findViewById(R.id.textView_zakon10);
        mTextView_z10s = (TextView) findViewById(R.id.textView_zakon10s);
        mTextView_z11 = (TextView) findViewById(R.id.textView_zakon11);
        mTextView_z11s = (TextView) findViewById(R.id.textView_zakon11s);
        mTextView_z12 = (TextView) findViewById(R.id.textView_zakon12);
        mTextView_z12s = (TextView) findViewById(R.id.textView_zakon12s);
        mTextView_z13 = (TextView) findViewById(R.id.textView_zakon13);
        mTextView_z13s = (TextView) findViewById(R.id.textView_zakon13s);
        mTextView_zakon_footer = (TextView) findViewById(R.id.textView_zakon_footer);

        mTextView_zakonNaslov.setText(R.string.zakon_naslov);
        mTextView_zakonHeader.setText(R.string.zakon_header);
        mTextView_zakonHeaderTekst.setText(R.string.zakon_header_tekst);
        mTextView_z1.setText(R.string.zakon_1);
        mTextView_z1s.setText(R.string.zakon_1s);
        mTextView_z2.setText(R.string.zakon_2);
        mTextView_z2s.setText(R.string.zakon_2s);
        mTextView_z3.setText(R.string.zakon_3);
        mTextView_z3s.setText(R.string.zakon_3s);
        mTextView_z4.setText(R.string.zakon_4);
        mTextView_z4s.setText(R.string.zakon_4s);
        mTextView_z5.setText(R.string.zakon_5);
        mTextView_z5s.setText(R.string.zakon_5s);
        mTextView_z6.setText(R.string.zakon_6);
        mTextView_z6s.setText(R.string.zakon_6s);
        mTextView_z7.setText(R.string.zakon_7);
        mTextView_z7s.setText(R.string.zakon_7s);
        mTextView_z8.setText(R.string.zakon_8);
        mTextView_z8s.setText(R.string.zakon_8s);
        mTextView_z9.setText(R.string.zakon_9);
        mTextView_z9s.setText(R.string.zakon_9s);
        mTextView_z10.setText(R.string.zakon_10);
        mTextView_z10s.setText(R.string.zakon_10s);
        mTextView_z11.setText(R.string.zakon_11);
        mTextView_z11s.setText(R.string.zakon_11s);
        mTextView_z12.setText(R.string.zakon_12);
        mTextView_z12s.setText(R.string.zakon_12s);
        mTextView_z13.setText(R.string.zakon_13);
        mTextView_z13s.setText(R.string.zakon_13s);
        mTextView_zakon_footer.setText(R.string.zakon_pripremio);
    }
}
