package android.fkvestak.com.ribolovac.Album;

import android.content.Intent;
import android.content.IntentFilter;
import android.fkvestak.com.ribolovac.R;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Created by Kvec on 9.11.2016..
 */

public class AlbumListFragment extends Fragment {

    private RecyclerView mAlbumRecyclerView;
    private AlbumAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_album_list, container, false);

        mAlbumRecyclerView = (RecyclerView)v.findViewById(R.id.album_recycler_view);
        mAlbumRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return v;
    }

    @Override
    public void onResume(){
        super.onResume();
        provjeriPraznog();
        updateUI();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_album_list, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_item_nova_slika:
                Album album = new Album();
                AlbumLab.get(getActivity()).addAlbum(album);
                Intent intent = AlbumPagerActivity.newIntent(getActivity(), album.getId());
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void provjeriPraznog(){
        List<Album> albums = AlbumLab.get(getActivity()).getAlbums();
        for (Album al : albums){
            if (al.getNaziv() == null){
                UUID id = al.getId();
                AlbumLab.get(getActivity()).deleteAlbum(id);
            }
        }
    }

    private void updateUI(){
        AlbumLab albumLab = AlbumLab.get(getActivity());
        List<Album> albums = albumLab.getAlbums();

        if (mAdapter == null){
            mAdapter = new AlbumAdapter(albums);
            mAlbumRecyclerView.setAdapter(mAdapter);
        }
        else {
            mAdapter.setAlbums(albums);
            mAdapter.notifyDataSetChanged();
        }
    }

    private class AlbumHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private Album mAlbum;
        private File mPhotoFile;

        private TextView mTitleTextView;
        private ImageView mImageView;
        private TextView mLokacijaTextView;
        private TextView mTezinaTextView;

        public AlbumHolder(View itemView){
            super(itemView);
            itemView.setOnClickListener(this);

            mTitleTextView = (TextView) itemView.findViewById(R.id.list_item_album_naziv_text_view);
            mImageView = (ImageView) itemView.findViewById(R.id.list_item_album_slika);
            mLokacijaTextView = (TextView) itemView.findViewById(R.id.list_item_album_lokacija_text_view);
            mTezinaTextView = (TextView) itemView.findViewById(R.id.list_item_album_tezina_text_view);
        }

        public void bindAlbum(Album album){
            mAlbum = album;
            mTitleTextView.setText(mAlbum.getNaziv());
            mLokacijaTextView.setText(mAlbum.getLokacija());
            mTezinaTextView.setText(mAlbum.getTezina());
            mTezinaTextView.append(" kg");

            mPhotoFile = AlbumLab.get(getActivity()).getPhotoFile(mAlbum);
            if (mPhotoFile == null || !mPhotoFile.exists()){
                mImageView.setImageDrawable(null);
            }
            else {
                Bitmap bitmap = PictureUtils.getThumbnail(mPhotoFile.getPath(), getActivity());
                mImageView.setImageBitmap(bitmap);
            }

        }

        @Override
        public void onClick(View v) {
            Intent intent = AlbumPagerActivity.newIntent(getActivity(), mAlbum.getId());
            startActivity(intent);
        }

    }

    private class AlbumAdapter extends RecyclerView.Adapter<AlbumHolder>{

        private List<Album> mAlbums;

        public AlbumAdapter(List<Album> albums) {
            mAlbums = albums;
        }

        @Override
        public AlbumHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View view = inflater.inflate(R.layout.fragment_album_list_item, parent, false);
            return new AlbumHolder(view);
        }

        @Override
        public void onBindViewHolder(AlbumHolder holder, int position) {
            Album album = mAlbums.get(position);
            holder.bindAlbum(album);
        }

        @Override
        public int getItemCount() {
            return mAlbums.size();
        }

        public void setAlbums(List<Album> albums){
            mAlbums = albums;
        }
    }

}
