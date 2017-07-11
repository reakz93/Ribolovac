package android.fkvestak.com.ribolovac.Vodostaj;

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
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.dom.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kvec on 18.11.2016..
 */

public class VodostajFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private VodostajAdapter mVodostajAdapter;

    private List<String> popisPostaja = null;
    private List<String> popisVodotok = null;
    private List<String> popisDatum = null;
    private List<String> popisRazina = null;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_vodostaj, container, false);
        mRecyclerView = (RecyclerView)v.findViewById(R.id.vodostaj_recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        new ParsePage().execute();
        return v;
    }

    private void updateUI(){

        VodostajLab vodostajLab = new VodostajLab(popisPostaja, popisVodotok, popisDatum, popisRazina);
        List<Vodostaj> vodostaj = vodostajLab.getVodostaj();

        if (mVodostajAdapter == null) {
            mVodostajAdapter = new VodostajAdapter(vodostaj);
            mRecyclerView.setAdapter(mVodostajAdapter);
        }
        else {
            mVodostajAdapter.notifyDataSetChanged();
        }
    }

    class ParsePage extends AsyncTask<String, Void, String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            popisPostaja = new ArrayList<>();
            popisVodotok = new ArrayList<>();
            popisDatum = new ArrayList<>();
            popisRazina = new ArrayList<>();
        }

        @Override
        protected String doInBackground(String... params) {
            org.jsoup.nodes.Document doc;

            try {
                doc = Jsoup.connect("http://vodniputovi.hr/servisi/vodostaji.html").get();
                Elements tablica = doc.getElementsByClass("tableData waterLevel");
                for (Element row : tablica.select("tr")){
                    Elements tds = row.select("td");
                    popisPostaja.add(tds.get(0).text());
                    popisVodotok.add(tds.get(1).text());
                    popisDatum.add(tds.get(2).text());
                    popisRazina.add(tds.get(3).text());
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

    private class VodostajHolder extends RecyclerView.ViewHolder {
        private Vodostaj mVodostaj;

        private TextView mPostaja;
        private TextView mVodotok;
        private TextView mDatum;
        private TextView mRazina;

        public VodostajHolder(View itemView){
            super(itemView);
            mPostaja = (TextView)itemView.findViewById(R.id.vodostaj_postaja);
            mVodotok = (TextView)itemView.findViewById(R.id.vodostaj_vodotok);
            mDatum = (TextView)itemView.findViewById(R.id.vodostaj_datum);
            mRazina = (TextView)itemView.findViewById(R.id.vodostaj_razina);
        }

        public void bindVodostaj(Vodostaj vodostaj){
            mVodostaj = vodostaj;
            mPostaja.setText(mVodostaj.getPostaja());
            mVodotok.setText(mVodostaj.getVodotok());
            mDatum.setText(mVodostaj.getDatum());
            mRazina.setText(mVodostaj.getRazina());
        }
    }

    private class VodostajAdapter extends RecyclerView.Adapter<VodostajHolder>{
        private List<Vodostaj> mVodostaj;

        public VodostajAdapter(List<Vodostaj> vodostaj) {
            mVodostaj = vodostaj;
        }

        @Override
        public VodostajHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View view = inflater.inflate(R.layout.fragment_vodostaj_item, parent, false);
            return new VodostajFragment.VodostajHolder(view);
        }

        @Override
        public void onBindViewHolder(VodostajHolder holder, int position) {
            Vodostaj vodostaj = mVodostaj.get(position);
            holder.bindVodostaj(vodostaj);
        }

        @Override
        public int getItemCount() {
            return mVodostaj.size();
        }
    }

}
