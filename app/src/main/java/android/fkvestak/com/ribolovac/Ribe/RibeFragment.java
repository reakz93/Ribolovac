package android.fkvestak.com.ribolovac.Ribe;

import android.fkvestak.com.ribolovac.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.UUID;

/**
 * Created by Kvec on 26.10.2016..
 */

public class RibeFragment extends Fragment {

    private static final String ARG_RIBA_ID = "riba_id";

    private Riba mRiba;
    private TextView mOpisField;
    private ImageView mSlika;

    public static RibeFragment newInstance(UUID ribaId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_RIBA_ID, ribaId);

        RibeFragment fragment = new RibeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        UUID ribaId = (UUID) getArguments().getSerializable(ARG_RIBA_ID);
        mRiba = RibeLab.get(getActivity()).getRibe(ribaId);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_ribe, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menu_item_info:
                Toast.makeText(getActivity(), "Povuci desno/lijevo za pregledavanje", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstaceState) {
        View v = inflater.inflate(R.layout.fragment_ribe, container, false);

        mOpisField = (TextView) v.findViewById(R.id.textView_riba_opis);
        mSlika = (ImageView) v.findViewById(R.id.imageView_riba_slika);

        String riba = mRiba.getNaziv();
        switch (riba){
            case "Amur - Ctenopharyngodon idella (Valenciennes)":
                mOpisField.setText(R.string.riba_amur);
                mSlika.setImageResource(R.drawable.amur);
                break;
            case "Babuška - Carassius auratus gibelio (Bloch)" :
                mOpisField.setText(R.string.riba_babuska);
                mSlika.setImageResource(R.drawable.babuska);
                break;
            case "Balavac - Gymnocephalus cernua (Linnaeus)":
                mOpisField.setText(R.string.riba_balavac);
                mSlika.setImageResource(R.drawable.balavac);
                break;
            case "Bjelica - Leucaspius delineatus (Heckel)":
                mOpisField.setText(R.string.riba_bjelica);
                mSlika.setImageResource(R.drawable.bjelica);
                break;
            case "Bolen - Aspius aspius (Linnaeus)":
                mOpisField.setText(R.string.riba_bolen);
                mSlika.setImageResource(R.drawable.bolen);
                break;
            case "Crvenperka - Scardinius erythrophthalamus (Linnaeus)":
                mOpisField.setText(R.string.riba_crvenperka);
                mSlika.setImageResource(R.drawable.crvenperka);
                break;
            case "Cvergl - Ameiurus (Ictalurus) nebulosus (Le Sueur)":
                mOpisField.setText(R.string.riba_cvergl);
                mSlika.setImageResource(R.drawable.cvergl);
                break;
            case "Deverika - Abramis brama danubii (Linnaeus)":
                mOpisField.setText(R.string.riba_deverika);
                mSlika.setImageResource(R.drawable.deverika);
                break;
            case "Gavčica - Rhodeus sericeus amarus (Bloch)":
                mOpisField.setText(R.string.riba_gavcica);
                mSlika.setImageResource(R.drawable.gavcica);
                break;
            case "Glavatica - Salmo marmoratus (Cuvier)":
                mOpisField.setText(R.string.glavatica);
                mSlika.setImageResource(R.drawable.glavatica);
                break;
            case "Grgeč - Perca fluviatilis (Linneaus)":
                mOpisField.setText(R.string.riba_grgeč);
                mSlika.setImageResource(R.drawable.grge);
                break;
            case "Jegulja - Anguilla anguilla (Linnaeus)":
                mOpisField.setText(R.string.riba_jegulja);
                mSlika.setImageResource(R.drawable.jegulja);
                break;
            case "Jez - Leuciscuc idus (Linnaeus)":
                mOpisField.setText(R.string.riba_jez);
                mSlika.setImageResource(R.drawable.jez);
                break;
            case "Karas - Carassius carassius (Linnaeus)":
                mOpisField.setText(R.string.riba_karas);
                mSlika.setImageResource(R.drawable.karas);
                break;
            case "Karas zlatni - Carassius auratus auratus (Linnaeus)":
                mOpisField.setText(R.string.riba_karas_zlatni);
                mSlika.setImageResource(R.drawable.karas_zlatni);
                break;
            case "Kečiga - Acipenser ruthenus (Linnaeus)":
                mOpisField.setText(R.string.riba_keciga);
                mSlika.setImageResource(R.drawable.keciga);
                break;
            case "Kesega, kosalj - Abramis ballerus (Linnaeus)":
                mOpisField.setText(R.string.riba_kesega);
                mSlika.setImageResource(R.drawable.kesega);
                break;
            case "Klen - Leuciuscus cephalus (Linnaeus)":
                mOpisField.setText(R.string.riba_klen);
                mSlika.setImageResource(R.drawable.klen);
                break;
            case "Klenić - Leuciscus leuciscus (Linneaus)":
                mOpisField.setText(R.string.riba_klenić);
                mSlika.setImageResource(R.drawable.klenic);
                break;
            case "Krkuša - Gobio gobio (Linnaeus)":
                mOpisField.setText(R.string.riba_krkusa);
                mSlika.setImageResource(R.drawable.krkusa);
                break;
            case "Koljuška - Gasterosteus aculeatus (Linnaeus)":
                mOpisField.setText(R.string.riba_koljuska);
                mSlika.setImageResource(R.drawable.koljuska);
                break;
            case "Krupatica - Blicca bjoerkna (Linnaeus)":
                mOpisField.setText(R.string.riba_krupatica);
                mSlika.setImageResource(R.drawable.krupatica);
                break;
            case "Linjak - Tinca tinca (Linnaeus)":
                mOpisField.setText(R.string.riba_linjak);
                mSlika.setImageResource(R.drawable.linjak);
                break;
            case "Lipljen - Thymallus thymallus (Linnaeus)":
                mOpisField.setText(R.string.riba_lipljen);
                mSlika.setImageResource(R.drawable.lipljen);
                break;
            case "Menjka, Manjić - Lota lota (Linneaus)":
                mOpisField.setText(R.string.riba_menjka);
                mSlika.setImageResource(R.drawable.menjka);
                break;
            case "Mladica - Hucho hucho (Linnaeus)":
                mOpisField.setText(R.string.riba_mladica);
                mSlika.setImageResource(R.drawable.mladica);
                break;
            case "Mrena - Barbus barbus (Linnaeus)":
                mOpisField.setText(R.string.riba_mrena);
                mSlika.setImageResource(R.drawable.mrena);
                break;
            case "Mrena potočna - Barbus meridionalis petenyi (Risso)":
                mOpisField.setText(R.string.riba_potocna_mrena);
                mSlika.setImageResource(R.drawable.potocna_mrena);
                break;
            case "Paklara dunavska - Eudontomyzon danfordi (Regan)":
                mOpisField.setText(R.string.riba_paklara);
                mSlika.setImageResource(R.drawable.paklara_dunavska);
                break;
            case "Paklara riječna - Lampetra fluviatilis (Linnaeus)":
                mOpisField.setText(R.string.riba_paklara);
                mSlika.setImageResource(R.drawable.paklara_rijecna);
                break;
            case "Grgeč pastrvski - Micropterus salmoides (Lacepede)":
                mOpisField.setText(R.string.riba_pastrvskigrgec);
                mSlika.setImageResource(R.drawable.pastrvski_grgec);
                break;
            case "Pastrva kalifornijska - Salmo gairdneri irideus (Richardson)":
                mOpisField.setText(R.string.riba_pastrvakalifornijska);
                mSlika.setImageResource(R.drawable.pastrva_kalifornijska);
                break;
            case "Pastrva jezerska - Salmo trutta lacustris (Linnaeus)":
                mOpisField.setText(R.string.riba_pastrvajezerska);
                mSlika.setImageResource(R.drawable.pastrva_jezerska);
                break;
            case "Pastrva potočna - Salmo trutta morpha fario (Linnaeus)":
                mOpisField.setText(R.string.riba_pastrvapotocna);
                mSlika.setImageResource(R.drawable.pastrva_potocna);
                break;
            case "Peš - Cottus gobio (Linnaeus)":
                mOpisField.setText(R.string.riba_pes);
                mSlika.setImageResource(R.drawable.pes);
                break;
            case "Pior - Phoxinus phoxinus (Linnaeus)":
                mOpisField.setText(R.string.riba_pior);
                mSlika.setImageResource(R.drawable.pior);
                break;
            case "Plotica - Rutilus pigus virgo (Heckel)":
                mOpisField.setText(R.string.riba_plotica);
                mSlika.setImageResource(R.drawable.plotica);
                break;
            case "Podust - Chondrostoma nasus (Linnaeus)":
                mOpisField.setText(R.string.riba_podust);
                mSlika.setImageResource(R.drawable.podust);
                break;
            case "Riječna babica - Blennius fluviatilis (Asso)":
                mOpisField.setText(R.string.riba_rijecna_babica);
                mSlika.setImageResource(R.drawable.rijecna_babica);
                break;
            case "Sabljarka - Pelecus cultratus (Linnaeus)":
                mOpisField.setText(R.string.riba_sabljarka);
                mSlika.setImageResource(R.drawable.sabljarka);
                break;
            case "Smuđ - Stizostedion lucioperca (Linnaeus)":
                mOpisField.setText(R.string.riba_smudj);
                mSlika.setImageResource(R.drawable.smudj);
                break;
            case "Sunčanica - Lepomis gibbosus (Linneaus)":
                mOpisField.setText(R.string.riba_suncanica);
                mSlika.setImageResource(R.drawable.suncanica);
                break;
            case "Šaran divlji - Cyprinus carpio (Linnaeus)":
                mOpisField.setText(R.string.riba_saran);
                mSlika.setImageResource(R.drawable.saran_divlji);
                break;
            case "Šaran ljuskavi - Cyprinus carpio domesticus (Linnaeus)":
                mOpisField.setText(R.string.riba_saran);
                mSlika.setImageResource(R.drawable.saran_ljuskavi);
                break;
            case "Šaran ribnjačarski - Cyprinus carpio (Linnaeus)":
                mOpisField.setText(R.string.riba_saran);
                mSlika.setImageResource(R.drawable.saran_ribnjacarski);
                break;
            case "Šaran veleljuskavi - Cyprinus carpio - mirror (Linnaeus)":
                mOpisField.setText(R.string.riba_saran);
                mSlika.setImageResource(R.drawable.saran_veleljuskavi);
                break;
            case "Šaran dvorednoljuskavi - Cyprinus carpio - forma":
                mOpisField.setText(R.string.riba_saran);
                mSlika.setImageResource(R.drawable.saran_dvorednoljuskavi);
                break;
            case "Štuka - Esox lucius (Linnaeus)":
                mOpisField.setText(R.string.riba_stuka);
                mSlika.setImageResource(R.drawable.stuka);
                break;
            case "Som - Silurus glanis (Linnaeus)":
                mOpisField.setText(R.string.riba_som);
                mSlika.setImageResource(R.drawable.som);
                break;
            case "Tolstolobik sivi - Aristichthys nobilis (Richardson)":
                mOpisField.setText(R.string.riba_tolstolobiksivi);
                mSlika.setImageResource(R.drawable.tolstolobik_sivi);
                break;
            case "Tolstolobik bijeli - Hypophthalmichthys molitrix (Valenciennes)":
                mOpisField.setText(R.string.riba_tolstolobikbijeli);
                mSlika.setImageResource(R.drawable.tolstolobik_bijeli);
                break;
            case "Zlatovčica jezerska - Salvelinus aplinus (Linnaeus)":
                mOpisField.setText(R.string.riba_zlatovcica_jezerska);
                mSlika.setImageResource(R.drawable.zlatovcica_jezerska);
                break;
            case "Zlatovčica potočna - Salvelinus fontinalis (Mitchell)":
                mOpisField.setText(R.string.riba_zlatovcica_potocna);
                mSlika.setImageResource(R.drawable.zlatovcica_potocna);
                break;
            case "Žutooka, Bodorka - Rutilus rutilus (Linnaeus)":
                mOpisField.setText(R.string.riba_zutooka);
                mSlika.setImageResource(R.drawable.zutooka);
                break;
            default:
                break;
        }

        return v;
    }

}
