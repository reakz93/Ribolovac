package android.fkvestak.com.ribolovac.Vezovi;

import android.content.Context;
import android.fkvestak.com.ribolovac.Sistemi.CustomPagerEnum;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Kvec on 1.12.2016..
 */

public class CustomPagerAdapterVezovi extends PagerAdapter {
    private Context mContext;

    public CustomPagerAdapterVezovi(Context context) {
        mContext = context;
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        CustomPagerEnumVezovi customPagerEnumVezovi = CustomPagerEnumVezovi.values()[position];
        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup layout = (ViewGroup) inflater.inflate(customPagerEnumVezovi.getLayoutResId(), collection, false);
        collection.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return CustomPagerEnumVezovi.values().length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        CustomPagerEnumVezovi customPagerEnumVezovi = CustomPagerEnumVezovi.values()[position];
        return mContext.getString(customPagerEnumVezovi.getTitleResId());
    }
}
