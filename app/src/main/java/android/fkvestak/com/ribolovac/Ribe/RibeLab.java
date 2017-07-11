package android.fkvestak.com.ribolovac.Ribe;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Kvec on 26.10.2016..
 */

public class RibeLab {

    private static RibeLab sRibeLab;

    private List<Riba> mRibe;
    String[] ribePopis = {"Amur - Ctenopharyngodon idella (Valenciennes)", "Babuška - Carassius auratus gibelio (Bloch)", "Balavac - Gymnocephalus cernua (Linnaeus)",
            "Bjelica - Leucaspius delineatus (Heckel)", "Bolen - Aspius aspius (Linnaeus)", "Crvenperka - Scardinius erythrophthalamus (Linnaeus)", "Cvergl - Ameiurus (Ictalurus) nebulosus (Le Sueur)",
            "Deverika - Abramis brama danubii (Linnaeus)", "Gavčica - Rhodeus sericeus amarus (Bloch)", "Glavatica - Salmo marmoratus (Cuvier)", "Grgeč - Perca fluviatilis (Linneaus)",
            "Grgeč pastrvski - Micropterus salmoides (Lacepede)", "Jegulja - Anguilla anguilla (Linnaeus)", "Jez - Leuciscuc idus (Linnaeus)",
            "Karas - Carassius carassius (Linnaeus)", "Karas zlatni - Carassius auratus auratus (Linnaeus)", "Kečiga - Acipenser ruthenus (Linnaeus)", "Kesega, kosalj - Abramis ballerus (Linnaeus)",
            "Klen - Leuciuscus cephalus (Linnaeus)", "Klenić - Leuciscus leuciscus (Linneaus)", "Krkuša - Gobio gobio (Linnaeus)", "Koljuška - Gasterosteus aculeatus (Linnaeus)",
            "Krupatica - Blicca bjoerkna (Linnaeus)", "Linjak - Tinca tinca (Linnaeus)", "Lipljen - Thymallus thymallus (Linnaeus)", "Menjka, Manjić - Lota lota (Linneaus)",
            "Paklara dunavska - Eudontomyzon danfordi (Regan)", "Paklara riječna - Lampetra fluviatilis (Linnaeus)",
            "Mladica - Hucho hucho (Linnaeus)", "Mrena - Barbus barbus (Linnaeus)", "Mrena potočna - Barbus meridionalis petenyi (Risso)", "Pastrva kalifornijska - Salmo gairdneri irideus (Richardson)",
            "Pastrva jezerska - Salmo trutta lacustris (Linnaeus)", "Pastrva potočna - Salmo trutta morpha fario (Linnaeus)", "Peš - Cottus gobio (Linnaeus)", "Pior - Phoxinus phoxinus (Linnaeus)",
            "Plotica - Rutilus pigus virgo (Heckel)","Podust - Chondrostoma nasus (Linnaeus)", "Riječna babica - Blennius fluviatilis (Asso)",
            "Sabljarka - Pelecus cultratus (Linnaeus)", "Smuđ - Stizostedion lucioperca (Linnaeus)", "Som - Silurus glanis (Linnaeus)", "Sunčanica - Lepomis gibbosus (Linneaus)",
            "Šaran divlji - Cyprinus carpio (Linnaeus)", "Šaran ljuskavi - Cyprinus carpio domesticus (Linnaeus)", "Šaran ribnjačarski - Cyprinus carpio (Linnaeus)",
            "Šaran veleljuskavi - Cyprinus carpio - mirror (Linnaeus)", "Šaran dvorednoljuskavi - Cyprinus carpio - forma", "Štuka - Esox lucius (Linnaeus)",
            "Tolstolobik sivi - Aristichthys nobilis (Richardson)", "Tolstolobik bijeli - Hypophthalmichthys molitrix (Valenciennes)", "Zlatovčica jezerska - Salvelinus aplinus (Linnaeus)",
            "Zlatovčica potočna - Salvelinus fontinalis (Mitchell)","Žutooka, Bodorka - Rutilus rutilus (Linnaeus)"};

    public static RibeLab get(Context context){
        if (sRibeLab == null){
            sRibeLab = new RibeLab(context);
        }
        return sRibeLab;
    }

    private RibeLab(Context context){
        mRibe = new ArrayList<>();
        for (int i=0; i<ribePopis.length; i++) {
            Riba riba = new Riba();
            riba.setNaziv(ribePopis[i]);
            mRibe.add(riba);
        }
    }

    public List<Riba> getRibe(){
        return mRibe;
    }

    public Riba getRibe(UUID id) {
        for (Riba riba : mRibe) {
            if (riba.getId().equals(id)){
                return riba;
            }
        }
        return null;
    }

}
