package android.fkvestak.com.ribolovac.Album;

import android.app.ActionBar;
import android.content.Context;
import android.fkvestak.com.ribolovac.R;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by Kvec on 7.12.2016..
 */

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(GridLayout.LayoutParams.WRAP_CONTENT, GridLayout.LayoutParams.WRAP_CONTENT));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        else
        {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    public Integer[] mThumbIds = {
            R.drawable.amur, R.drawable.babuska, R.drawable.balavac, R.drawable.bjelica, R.drawable.bolen, R.drawable.crvenperka, R.drawable.cvergl, R.drawable.deverika, R.drawable.gavcica,
            R.drawable.glavatica, R.drawable.grge, R.drawable.pastrvski_grgec, R.drawable.jegulja, R.drawable.jez, R.drawable.karas, R.drawable.karas_zlatni, R.drawable.keciga, R.drawable.kesega,
            R.drawable.klen, R.drawable.klenic, R.drawable.krkusa, R.drawable.koljuska, R.drawable.krupatica, R.drawable.linjak, R.drawable.lipljen, R.drawable.menjka, R.drawable.paklara_dunavska,
            R.drawable.paklara_rijecna, R.drawable.mladica, R.drawable.mrena, R.drawable.potocna_mrena, R.drawable.pastrva_kalifornijska, R.drawable.pastrva_jezerska, R.drawable.pastrva_potocna, R.drawable.pes,
            R.drawable.pior, R.drawable.plotica, R.drawable.podust, R.drawable.rijecna_babica, R.drawable.sabljarka, R.drawable.smudj, R.drawable.som, R.drawable.suncanica, R.drawable.saran_divlji,
            R.drawable.saran_ljuskavi, R.drawable.saran_ribnjacarski, R.drawable.saran_veleljuskavi, R.drawable.saran_dvorednoljuskavi, R.drawable.stuka, R.drawable.tolstolobik_sivi,
            R.drawable.tolstolobik_bijeli, R.drawable.zlatovcica_jezerska, R.drawable.zlatovcica_potocna, R.drawable.zutooka
    };
}
