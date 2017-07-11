package android.fkvestak.com.ribolovac.Prognoza;

import android.content.Intent;
import android.fkvestak.com.ribolovac.R;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Kvec on 30.11.2016..
 */

public class VrijemeListActivity extends AppCompatActivity {

    public static final String EXTRA_LINK = "com.fkvestak.android.ribolovac.vrijeme_link";

    String[] popisGradova = {"Bakar", "Benkovac", "Biograd",
            "Bjelovar", "Čakovec", "Čazma",
            "Đakovo", "Daruvar", "Donja Stubica",
            "Drniš", "Dubrovnik", "Dugo Selo",
            "Gospić", "Imotski", "Ivanić Grad",
            "Jastrebarsko", "Karlovac", "Kaštela",
            "Knin", "Koprivnica", "Kraljevica",
            "Krapina", "Križevci", "Krk",
            "Kutina", "Makarska", "Marija Bistrica",
            "Metković", "Nin", "Nova Gradiška",
            "Novalja", "Omiš", "Opatija",
            "Oroslavje", "Osijek", "Pag",
            "Petrinja", "Podstrana", "Poreč",
            "Požega", "Pula", "Rijeka",
            "Rovinj", "Samobor", "Šibenik",
            "Sinj", "Sisak", "Skradin",
            "Slatina", "Slavonski Brod", "Solin",
            "Split", "Sukošan", "Trogir",
            "Varaždin", "Velika Gorica", "Vinkovci",
            "Virovitica", "Vodice", "Vrbovec",
            "Vukovar", "Zabok", "Zadar",
            "Zagreb", "Zaprešić", "Županja"
    };
    String[] popisLinkova = {"http://www.mojkvart.hr/Bakar/vremenska-prognoza", "http://www.mojkvart.hr/Benkovac/vremenska-prognoza", "http://www.mojkvart.hr/Biograd/vremenska-prognoza",
            "http://www.mojkvart.hr/Bjelovar/vremenska-prognoza", "http://www.mojkvart.hr/Cakovec/vremenska-prognoza", "http://www.mojkvart.hr/Cazma/vremenska-prognoza",
            "http://www.mojkvart.hr/dakovo/vremenska-prognoza", "http://www.mojkvart.hr/Daruvar/vremenska-prognoza", "http://www.mojkvart.hr/Donja-Stubica/vremenska-prognoza",
            "http://www.mojkvart.hr/Drnis/vremenska-prognoza", "http://www.mojkvart.hr/Dubrovnik/vremenska-prognoza", "http://www.mojkvart.hr/Dugo-Selo/vremenska-prognoza",
            "http://www.mojkvart.hr/Gospic/vremenska-prognoza", "http://www.mojkvart.hr/Imotski/vremenska-prognoza", "http://www.mojkvart.hr/Ivanic-Grad/vremenska-prognoza",
            "http://www.mojkvart.hr/Jastrebarsko/vremenska-prognoza", "http://www.mojkvart.hr/Karlovac/vremenska-prognoza", "http://www.mojkvart.hr/Kastela/vremenska-prognoza",
            "http://www.mojkvart.hr/Knin/vremenska-prognoza", "http://www.mojkvart.hr/Koprivnica/vremenska-prognoza", "http://www.mojkvart.hr/Kraljevica/vremenska-prognoza",
            "http://www.mojkvart.hr/Krapina/vremenska-prognoza", "http://www.mojkvart.hr/Krizevci/vremenska-prognoza", "http://www.mojkvart.hr/Krk/vremenska-prognoza",
            "http://www.mojkvart.hr/Kutina/vremenska-prognoza", "http://www.mojkvart.hr/Makarska/vremenska-prognoza", "http://www.mojkvart.hr/Marija-Bistrica/vremenska-prognoza",
            "http://www.mojkvart.hr/Metkovic/vremenska-prognoza", "http://www.mojkvart.hr/Nin/vremenska-prognoza", "http://www.mojkvart.hr/Nova-Gradiska/vremenska-prognoza",
            "http://www.mojkvart.hr/Novalja/vremenska-prognoza", "http://www.mojkvart.hr/Omis/vremenska-prognoza", "http://www.mojkvart.hr/Opatija/vremenska-prognoza",
            "http://www.mojkvart.hr/Oroslavje/vremenska-prognoza", "http://www.mojkvart.hr/Osijek/vremenska-prognoza", "http://www.mojkvart.hr/Pag/vremenska-prognoza",
            "http://www.mojkvart.hr/Petrinja/vremenska-prognoza", "http://www.mojkvart.hr/Podstrana/vremenska-prognoza", "http://www.mojkvart.hr/Porec/vremenska-prognoza",
            "http://www.mojkvart.hr/Pozega/vremenska-prognoza", "http://www.mojkvart.hr/Pula/vremenska-prognoza", "http://www.mojkvart.hr/Rijeka/vremenska-prognoza",
            "http://www.mojkvart.hr/Rovinj/vremenska-prognoza", "http://www.mojkvart.hr/Samobor/vremenska-prognoza", "http://www.mojkvart.hr/sibenik/vremenska-prognoza",
            "http://www.mojkvart.hr/Sinj/vremenska-prognoza", "http://www.mojkvart.hr/Sisak/vremenska-prognoza", "http://www.mojkvart.hr/Skradin/vremenska-prognoza",
            "http://www.mojkvart.hr/Slatina/vremenska-prognoza", "http://www.mojkvart.hr/Slavonski-Brod/vremenska-prognoza", "http://www.mojkvart.hr/Solin/vremenska-prognoza",
            "http://www.mojkvart.hr/Split/vremenska-prognoza", "http://www.mojkvart.hr/Sukosan/vremenska-prognoza", "http://www.mojkvart.hr/Trogir/vremenska-prognoza",
            "http://www.mojkvart.hr/Varazdin/vremenska-prognoza", "http://www.mojkvart.hr/Velika-Gorica/vremenska-prognoza", "http://www.mojkvart.hr/Vinkovci/vremenska-prognoza",
            "http://www.mojkvart.hr/Virovitica/vremenska-prognoza", "http://www.mojkvart.hr/Vodice/vremenska-prognoza", "http://www.mojkvart.hr/Vrbovec/vremenska-prognoza",
            "http://www.mojkvart.hr/Vukovar/vremenska-prognoza", "http://www.mojkvart.hr/Zabok/vremenska-prognoza", "http://www.mojkvart.hr/Zadar/vremenska-prognoza",
            "http://www.mojkvart.hr/Zagreb/vremenska-prognoza", "http://www.mojkvart.hr/Zapresic/vremenska-prognoza", "http://www.mojkvart.hr/zupanja/vremenska-prognoza"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vrijeme_list);

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_vrijeme_list_item, popisGradova);

        ListView listView = (ListView) findViewById(R.id.vrijeme_lista_gradova);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int id_klik = (int)id;
                String x = popisLinkova[id_klik];
                Toast.makeText(VrijemeListActivity.this, "Dohvaćanje podataka za: " + popisGradova[id_klik], Toast.LENGTH_SHORT).show();
                Intent intent = VrijemeActivity.newIntent(getApplicationContext(), x);
                startActivity(intent);
            }
        });
    }

}
