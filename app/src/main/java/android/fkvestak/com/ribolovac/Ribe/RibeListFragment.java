package android.fkvestak.com.ribolovac.Ribe;

import android.content.Intent;
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

public class RibeListFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RibeAdapter mRibeAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_ribe_list, container, false);

        mRecyclerView = (RecyclerView)v.findViewById(R.id.ribe_recycler_view);
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
        RibeLab ribeLab = RibeLab.get(getActivity());
        List<Riba> ribe = ribeLab.getRibe();

        if (mRibeAdapter == null) {
            mRibeAdapter = new RibeAdapter(ribe);
            mRecyclerView.setAdapter(mRibeAdapter);
        }
        else {
            mRibeAdapter.notifyDataSetChanged();
        }
    }

    private class RibeHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private Riba mRibe;

        private TextView mNazivTextView;

        public RibeHolder(View itemView){
            super(itemView);
            itemView.setOnClickListener(this);

            mNazivTextView = (TextView) itemView.findViewById(R.id.textView_naziv);
        }

        public void bindRiba(Riba riba) {
            mRibe = riba;
            mNazivTextView.setText(mRibe.getNaziv());
        }

        @Override
        public void onClick(View v){
            Intent intent = RibePagerActivity.newIntent(getActivity(), mRibe.getId());
            startActivity(intent);
        }

    }

    private class RibeAdapter extends RecyclerView.Adapter<RibeHolder> {

        private List<Riba> mRibe;

        public RibeAdapter(List<Riba> ribe){
            mRibe = ribe;
        }

        @Override
        public RibeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View view = inflater.inflate(R.layout.fragment_ribe_list_item, parent, false);
            return new RibeHolder(view);
        }

        @Override
        public void onBindViewHolder(RibeHolder holder, int position) {
            Riba riba = mRibe.get(position);
            holder.bindRiba(riba);
        }

        @Override
        public int getItemCount() {
            return mRibe.size();
        }
    }

}
