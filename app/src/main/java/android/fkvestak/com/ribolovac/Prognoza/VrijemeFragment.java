package android.fkvestak.com.ribolovac.Prognoza;

import android.fkvestak.com.ribolovac.R;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by Kvec on 30.11.2016..
 */

public class VrijemeFragment extends Fragment {

    private static final String ARG_LINK = "link";
    private String link;

    private RecyclerView mRecyclerView;
    private VrijemeAdapter mVrijemeAdapter;

    private List<String> popisVrijemeDatum = null;
    private List<String> popisVrijemeDan = null;
    private List<String> popisVrijemeNoc = null;

    public static VrijemeFragment newInstance(String x){
        Bundle args = new Bundle();
        args.putSerializable(ARG_LINK, x);

        VrijemeFragment fragment = new VrijemeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        link = (String)getArguments().getSerializable(ARG_LINK);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_vrijeme, container, false);

        mRecyclerView = (RecyclerView)v.findViewById(R.id.vrijeme_recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        new ParsePage().execute();

        return v;
    }

    private void updateUI(){
        VrijemeLab vrijemeLab = new VrijemeLab(popisVrijemeDatum, popisVrijemeDan, popisVrijemeNoc);
        List<Vrijeme> vrijeme = vrijemeLab.getVrijeme();

        if (mVrijemeAdapter == null){
            mVrijemeAdapter = new VrijemeAdapter(vrijeme);
            mRecyclerView.setAdapter(mVrijemeAdapter);
        }
        else {
            mVrijemeAdapter.notifyDataSetChanged();
        }
    }

    class ParsePage extends AsyncTask<String, Void, String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            popisVrijemeDatum = new ArrayList<>();
            popisVrijemeDan = new ArrayList<>();
            popisVrijemeNoc = new ArrayList<>();
        }

        @Override
        protected String doInBackground(String... params) {
            Document doc;
            try{
                doc = Jsoup.connect(link).get();
                for (Element table : doc.getElementsByClass("weather_table vremenska_prognoza_po_danima")){
                    for (Element row : table.select("tr")){
                        Elements tds = row.select("td");
                        if (tds.size() > 2){
                            popisVrijemeDatum.add(tds.get(0).text());
                            popisVrijemeDan.add(tds.get(1).text());
                            popisVrijemeNoc.add(tds.get(2).text());
                        }
                    }
                }

            } catch (IOException e){
                e.printStackTrace();
            }
            return "Executed";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            updateUI();
        }
    }

    private class VrijemeHolder extends RecyclerView.ViewHolder {
        private Vrijeme mVrijeme;

        private TextView mDatum;
        private TextView mDan;
        private TextView mNoc;

        public VrijemeHolder(View itemView){
            super(itemView);
            mDatum = (TextView)itemView.findViewById(R.id.textView_vrijeme_datum);
            mDan = (TextView)itemView.findViewById(R.id.textView6_vrijeme_dan);
            mNoc = (TextView)itemView.findViewById(R.id.textView8_vrijeme_noc);
        }

        public void bindVrijeme(Vrijeme vrijeme){
            mVrijeme = vrijeme;
            mDatum.setText(mVrijeme.getDatum());
            mDan.setText(mVrijeme.getDan_temp());
            mNoc.setText(mVrijeme.getNoc_temp());
        }
    }

    private class VrijemeAdapter extends RecyclerView.Adapter<VrijemeHolder>{
        private List<Vrijeme> mVrijeme;

        public VrijemeAdapter(List<Vrijeme> vrijeme){
            mVrijeme = vrijeme;
        }

        @Override
        public VrijemeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View view = inflater.inflate(R.layout.fragment_vrijeme_item, parent, false);
            return new VrijemeFragment.VrijemeHolder(view);
        }

        @Override
        public void onBindViewHolder(VrijemeHolder holder, int position) {
            Vrijeme vrijeme = mVrijeme.get(position);
            holder.bindVrijeme(vrijeme);
        }

        @Override
        public int getItemCount() {
            return mVrijeme.size();
        }
    }

}
