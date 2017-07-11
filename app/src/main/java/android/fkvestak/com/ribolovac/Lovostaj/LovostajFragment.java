package android.fkvestak.com.ribolovac.Lovostaj;

import android.fkvestak.com.ribolovac.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Kvec on 26.10.2016..
 */

public class LovostajFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private LovostajAdapter mLovostajAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_lovostaj, container, false);

        mRecyclerView = (RecyclerView)v.findViewById(R.id.lovostaj_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private void updateUI(){

        LovostajLab lovostajLab = LovostajLab.get(getActivity());
        List<Lovostaj> lovostaj = lovostajLab.getLovostaj();

        if (mLovostajAdapter == null) {
            mLovostajAdapter = new LovostajAdapter(lovostaj);
            mRecyclerView.setAdapter(mLovostajAdapter);
        }
        else {
            mLovostajAdapter.notifyDataSetChanged();
        }

    }

    private class LovostajHolder extends RecyclerView.ViewHolder {

        private Lovostaj mLovostaj;

        private TextView mNazivTextView;
        private TextView mPodrucjeTextView;
        private TextView mVrijemeTextView;
        private TextView mVelicinaTextView;

        public LovostajHolder(View itemView){
            super(itemView);

            mNazivTextView = (TextView) itemView.findViewById(R.id.textView_naziv);
            mPodrucjeTextView = (TextView) itemView.findViewById(R.id.textView_podrucje);
            mVrijemeTextView = (TextView) itemView.findViewById(R.id.textView_vrijeme);
            mVelicinaTextView = (TextView) itemView.findViewById(R.id.textView_velicina);
        }

        public void bindLovostaj(Lovostaj lovostaj) {
            mLovostaj = lovostaj;
            mNazivTextView.setText(mLovostaj.getNaziv());
            mPodrucjeTextView.setText(mLovostaj.getPodrucje());
            mVrijemeTextView.setText(mLovostaj.getVrijeme());
            mVelicinaTextView.setText(mLovostaj.getVelicina());
        }

    }

    private class LovostajAdapter extends RecyclerView.Adapter<LovostajHolder> {

        private List<Lovostaj> mLovostaj;

        public LovostajAdapter(List<Lovostaj> lovostaj){
            mLovostaj = lovostaj;
        }

        @Override
        public LovostajFragment.LovostajHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View view = inflater.inflate(R.layout.fragment_lovostaj_item, parent, false);
            return new LovostajFragment.LovostajHolder(view);
        }

        @Override
        public void onBindViewHolder(LovostajHolder holder, int position) {
            Lovostaj lovostaj = mLovostaj.get(position);
            holder.bindLovostaj(lovostaj);
        }

        @Override
        public int getItemCount() {
            return mLovostaj.size();
        }
    }

}
