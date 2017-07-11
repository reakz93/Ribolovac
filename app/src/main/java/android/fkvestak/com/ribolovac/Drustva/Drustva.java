package android.fkvestak.com.ribolovac.Drustva;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.fkvestak.com.ribolovac.R;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static android.support.design.widget.Snackbar.make;

/**
 * Created by Kvec on 27.10.2016..
 */

public class Drustva extends ListActivity {

    String[] drustvaPopis = {"ŠRD 'Toplica' Daruvar", "ZŠRU Garešnica", "ZŠRD Grubišno Polje", "ZŠRD Čazma", "ZŠRDU Bjelovar",
            "ŠRS Brodsko-posavske županije",
            "ŠRD 'Piškor' Zagreb", "ŠRD 'Pešćenica' Zagreb", "Zagrebački holding d.o.o", "ŠRŠD 'Špansko Susedgrad'", "ŠRU 'Bukovac-Maksimir'", "ŠRK 'Sesvete'", "UŠRIDRRH", "ŠRU 'Udica Sesvete'", "Ivan Pandža", "ŠRU 'Alfa' Zagreb", "ŠRD 'Grgeč'",
            "ŠRD 'Pazinčica'", "ŠRD 'Istra'", "ŠRD 'Mrena' Buzet",
            "ŠRU 'Štuka'", "ŠRD 'Slunjčica'", "ŠRD 'Draganić'", "KŠR 'Mrežnica'", "ŠRD 'Ozalj'", "ŠRD Ogulin", "KŠR 'Korana'", "Obrt 'Tonković'", "Braniteljska zadruga Klek",
            "ŠRK Križevci", "ZŠRK Đurđevac +", "ZŠRK Koprivnica +", "Hrvatske šume d.o.o. Šumarija Đurđevac +", "Polj. Udruga Kalinovac +", "DEM TRADE - proizvodnja", "VIROVKA - zadruga za proizvod. posredovanje i usluge +",
            "ŠRS Krapinsko-zagorske županije", "ŠRD 'Sutla'",
            "Gacka d.o.o.", "SRD 'Lipen'", "ŠRU 'Lika'", "ŠRD 'Šaran'", "ŠRU 'Pijor'", "ŠRU 'Jaruga'", "BEPO promet d.o.o.",
            "ŠRD 'Linjak' Palovec", "ŠRD 'Mura'", "SŠRD Međimurske županije", "P.P.U. 'Goričanec' d.o.o.",
            "ZŠRD Osijek", "ŠUD 'Šaran' Našice", "ZŠRU Donji Miholjac", "ZŠRU Valpovo", "ZŠRU Đakovo", "ZŠRD Baranje", "Javna ustanova 'Park prirode Kopački Rit'",
            "ŠRS Požeško - slavonske županije",
            "ŠRU 'Čabranka'", "ŠRK 'Lokvarka'", "ŠRU 'Goran'", "ŠRD 'Šaran'", "ŠRK 'Rječina'", "ŠRU 'Bajer'", "ŠRD 'Kamačnik'", "Javna ustanova 'Nacionalni park Risnjak'",
            "ŠRD 'Som'", "ŠRK 'Amur' Petrokemija", "ŠRD 'Šaran'", "ŠRU 'Jez'", "ZŠRU Sisak", "UŠR 'Štuka'", "ŠRD 'Karas'", "RU Petrinja", "ŠRU 'Šaran'", "Lupus Silvestris d.o.o", "ŠRD 'Štuka' - Osekovo", "ŠRD Linjak - Banova Jaruga",
            "ŠRD 'Žrnovnica'", "ŠRD 'Gubavica'", "ŠRD 'Jadro'", "ŠRD 'Cetina'", "ŠRU 'Šaran'", "ŠRD 'Šaran' Općine Proložac",
            "ŠRU 'Krka'",
            "ŠRK 'Keder' Beletinec", "ŠRK 'Varaždin'", "ŠRD 'Ivanec'", "ŠRD 'Novi Marof'", "ŠRK 'AZZURRO'", "ŠRD 'Vidovec'", "ŠRD 'Ludbreg'", "ŠRK 'Linjak' Veliki Bukovec", "ŠRK 'Trakoščan'", "ŠRK 'Općine Cestica 1995'", "ŠRK Vinica", "ŠRU Općine Petrijanec",
            "ZŠRU Orahovica, Čačinci, Zdenci", "ZŠRU Virovitica +", "ZŠRK općine Pitomača +", "ŠRU 'Šaran' - Bakić",
            "ŠRS Vukovarsko - srijemske županije", "ZŠRU Vukovar", "ŠRU Bajer - Vinkovci", "ŠRD 'Šaran' Cerna - Šiškovci",
            "Javna ustanova 'Park prirode Vransko jezero'", "ŠRU Pastrva - Zrmanja",
            "Zagrebačko ribolovno društvo", "ŠRD 'Sloga' Orešje", "ŠRD Jastrebarsko", "SŠRU Pisarovina", "ŠRD 'Šaran'", "ŠRU 'Odra'", "ŠRD 'Som' Kerestinec", "ŠRU 'Štuka' Brdovec", "SRD 'Štuka'",
                "ŠRD 'Štuka' Poljanski Lug", "ŠRU 'Klen' Brckovljani", "ŠRD 'Dugo Selo'", "ŠRK 'Šilj'", "ŠRU 'Lonja' Ivanić Grad +", "ŠRD 'Vukšinac'", "ŠRU 'Šaran' - Križ", "ŠRD Samobor",
                "ŠRD 'Črnec' Vrbovec", "ŠRU 'Rak' Rakitje", "ŠRD 'Amur' Vrbovec", "UŠRIIVDR 'Veteran 91' Zagreb", "ŠRD 'Šaran' Fuka", "ŠRD 'Zelina' - Zelina", "ŠRU Stupnik", "ŠRD 'Dogs'",
            "ZUŠRIVDRH +"
    };
    String[] zupanije = {"Bjelovarsko-bilogorska županija", "Brodsko-posavska županija", "Grad Zagreb", "Istarska županija", "Karlovačka županija", "Koprivničko-križevačka županija",
            "Krapinsko-zagorska županija", "Ličko-senjska županija", "Međimurska županija", "Osječko-baranjska županija", "Požeško-slavonska županija", "Primorsko-goranska županija",
            "Sisačko-moslavačka županija", "Splitsko-dalmatinska županija", "Šibensko-kninska županija", "Varaždinska županija", "Virovitičko-podravska županija", "Vukovarsko-srijemska županija",
            "Zadarska županija", "Zagrebačka županija", "Preostale vode"
    };

    private CustomAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new CustomAdapter(this);
        Toast.makeText(this, "Odaberi društvo za detaljan prikaz", Toast.LENGTH_SHORT).show();

        int brojac = 1;
        mAdapter.addSectionHeaderItem(zupanije[0]);
        for (int i = 0; i < drustvaPopis.length; i++) {
            mAdapter.addItem(drustvaPopis[i]);
            if (drustvaPopis[i] == "ZŠRDU Bjelovar") {mAdapter.addSectionHeaderItem(zupanije[brojac]); brojac++;}
            if (drustvaPopis[i] == "ŠRS Brodsko-posavske županije") {mAdapter.addSectionHeaderItem(zupanije[brojac]);brojac++;}
            if (drustvaPopis[i] == "ŠRD 'Grgeč'") {mAdapter.addSectionHeaderItem(zupanije[brojac]); brojac++;}
            if (drustvaPopis[i] == "ŠRD 'Mrena' Buzet") {mAdapter.addSectionHeaderItem(zupanije[brojac]); brojac++;}
            if (drustvaPopis[i] == "Braniteljska zadruga Klek") {mAdapter.addSectionHeaderItem(zupanije[brojac]); brojac++;}
            if (drustvaPopis[i] == "VIROVKA - zadruga za proizvod. posredovanje i usluge +") {mAdapter.addSectionHeaderItem(zupanije[brojac]); brojac++;}
            if (drustvaPopis[i] == "ŠRD 'Sutla'") {mAdapter.addSectionHeaderItem(zupanije[brojac]); brojac++;}
            if (drustvaPopis[i] == "BEPO promet d.o.o.") {mAdapter.addSectionHeaderItem(zupanije[brojac]); brojac++;}
            if (drustvaPopis[i] == "P.P.U. 'Goričanec' d.o.o.") {mAdapter.addSectionHeaderItem(zupanije[brojac]); brojac++;}
            if (drustvaPopis[i] == "Javna ustanova 'Park prirode Kopački Rit'") {mAdapter.addSectionHeaderItem(zupanije[brojac]); brojac++;}
            if (drustvaPopis[i] == "ŠRS Požeško - slavonske županije") {mAdapter.addSectionHeaderItem(zupanije[brojac]); brojac++;}
            if (drustvaPopis[i] == "Javna ustanova 'Nacionalni park Risnjak'") {mAdapter.addSectionHeaderItem(zupanije[brojac]); brojac++;}
            if (drustvaPopis[i] == "ŠRD Linjak - Banova Jaruga") {mAdapter.addSectionHeaderItem(zupanije[brojac]); brojac++;}
            if (drustvaPopis[i] == "ŠRD 'Šaran' Općine Proložac") {mAdapter.addSectionHeaderItem(zupanije[brojac]); brojac++;}
            if (drustvaPopis[i] == "ŠRU 'Krka'") {mAdapter.addSectionHeaderItem(zupanije[brojac]); brojac++;}
            if (drustvaPopis[i] == "ŠRU Općine Petrijanec") {mAdapter.addSectionHeaderItem(zupanije[brojac]); brojac++;}
            if (drustvaPopis[i] == "ŠRU 'Šaran' - Bakić") {mAdapter.addSectionHeaderItem(zupanije[brojac]); brojac++;}
            if (drustvaPopis[i] == "ŠRD 'Šaran' Cerna - Šiškovci") {mAdapter.addSectionHeaderItem(zupanije[brojac]); brojac++;}
            if (drustvaPopis[i] == "ŠRU Pastrva - Zrmanja") {mAdapter.addSectionHeaderItem(zupanije[brojac]); brojac++;}
            if (drustvaPopis[i] == "ŠRD 'Dogs'") {mAdapter.addSectionHeaderItem(zupanije[brojac]); brojac++;}
        }
        setListAdapter(mAdapter);

        Resources res = getResources();
        final String[] popisdrustva = res.getStringArray(R.array.drustva_popis);

        ListView lv = (ListView) findViewById(android.R.id.list);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {

                if (mAdapter.getItemViewType(position) == mAdapter.TYPE_ITEM){
                    int x = (int)id;
                    AlertDialog.Builder adb = new AlertDialog.Builder(Drustva.this);
                    adb.setTitle("" + parent.getItemAtPosition(position));
                    adb.setMessage(popisdrustva[x]);
                    adb.setPositiveButton("Ok", null);
                    adb.show();
                }
            }
        });

    }
}
