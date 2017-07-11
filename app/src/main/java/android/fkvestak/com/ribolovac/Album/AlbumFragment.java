package android.fkvestak.com.ribolovac.Album;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.fkvestak.com.ribolovac.BuildConfig;
import android.fkvestak.com.ribolovac.R;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Kvec on 9.11.2016..
 */

public class AlbumFragment extends Fragment {

    private static final String ARG_ALBUM_ID = "album_id";
    private static final String DIALOG_DATE = "DialogDate";

    private static final int REQUEST_DATE = 0;
    private static final int REQUEST_PHOTO = 2;
    private static final int REQUEST_RIBA = 3;

    private Album mAlbum;
    private EditText mNazivField;
    private Button mDateButton;
    private ImageButton mImageButton;
    private ImageView mImageView;
    private File mPhotoFile;
    private EditText mLokacijaField;
    private EditText mMamacField;
    private EditText mTezinaField;
    private EditText mVelicinaField;
    private ImageButton mImageButtonRibe;
    public boolean nazivDefault = false;

    public static AlbumFragment newInstance(UUID albumId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_ALBUM_ID, albumId);

        AlbumFragment fragment = new AlbumFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        UUID albumId = (UUID) getArguments().getSerializable(ARG_ALBUM_ID);
        mAlbum = AlbumLab.get(getActivity()).getAlbum(albumId);
        mPhotoFile = AlbumLab.get(getActivity()).getPhotoFile(mAlbum);
    }

    @Override
    public void onPause() {
        super.onPause();
        AlbumLab.get(getActivity()).updateAlbum(mAlbum);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_album, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_item_brisi_sliku:
                final UUID albumId = mAlbum.getId();
                AlbumLab.get(getActivity()).deleteAlbum(albumId);
                getActivity().finish();
                Toast.makeText(getActivity(), "Zapis obrisan!", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_album, container, false);

        mNazivField = (EditText)v.findViewById(R.id.album_title);
        mNazivField.setText(mAlbum.getNaziv());
        mNazivField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mAlbum.setNaziv(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mLokacijaField = (EditText)v.findViewById(R.id.album_lokacija);
        mLokacijaField.setText(mAlbum.getLokacija());
        mLokacijaField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mAlbum.setLokacija(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mMamacField = (EditText)v.findViewById(R.id.album_mamac);
        mMamacField.setText(mAlbum.getMamac());
        mMamacField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mAlbum.setMamac(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mTezinaField = (EditText)v.findViewById(R.id.album_tezina);
        mTezinaField.setText(mAlbum.getTezina());
        mTezinaField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length()>0){
                    String x = s.toString();
                    float broj = Float.parseFloat(x);
                    String sredjen = String.format("%.2f", broj);
                    mAlbum.setTezina(sredjen);
                }
            }
        });

        mVelicinaField = (EditText)v.findViewById(R.id.album_velicina);
        mVelicinaField.setText(mAlbum.getVelicina());
        mVelicinaField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mAlbum.setVelicina(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mDateButton = (Button)v.findViewById(R.id.album_date);
        updateDate();
        mDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                DatePickerFragment dialog = DatePickerFragment.newInstance(mAlbum.getDate());
                dialog.setTargetFragment(AlbumFragment.this, REQUEST_DATE);
                dialog.show(fragmentManager, DIALOG_DATE);
            }
        });

        mImageButton = (ImageButton)v.findViewById(R.id.album_kamera);
        final Intent captureImage = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        PackageManager packageManager = getActivity().getPackageManager();

        boolean canTakePhoto = mPhotoFile != null && captureImage.resolveActivity(packageManager) != null;
        mImageButton.setEnabled(canTakePhoto);

        if (canTakePhoto) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                Uri photoURI = FileProvider.getUriForFile(getActivity(), BuildConfig.APPLICATION_ID + ".provider", mPhotoFile);
                captureImage.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
            }
            else {
                Uri photoURI = Uri.fromFile(mPhotoFile);
                captureImage.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
            }
        }

        mImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(captureImage, REQUEST_PHOTO);
            }
        });

        mImageView = (ImageView)v.findViewById(R.id.album_slika);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                ImageDialog.getImage(mPhotoFile.getPath(), getActivity());
                new ImageDialog().show(fragmentManager, null);
            }
        });

        updatePhotoView();

        mImageButtonRibe = (ImageButton)v.findViewById(R.id.imageButton_ribe_dodaj);
        mImageButtonRibe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AlbumFragment.this.getActivity(), RibeLista.class);
                startActivityForResult(intent, REQUEST_RIBA);
            }
        });

        return v;
    }

    @Override
    public void onActivityResult (int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK){
            return;
        }

        if (requestCode == REQUEST_DATE) {
            Date date = (Date) data.getSerializableExtra(DatePickerFragment.EXTRA_DATE);
            mAlbum.setDate(date);
            updateDate();
        }
        else if (requestCode == REQUEST_PHOTO){
            updatePhotoView();
        }
        else if (requestCode == REQUEST_RIBA){
            int id = (int) data.getSerializableExtra(RibeLista.EXTRA_RIBA_ODABRANA);
            mNazivField.setText(ribePopis[id]);
            updateNazivField(ribePopis[id]);
        }
    }

    private void updateNazivField(String riba) {
        switch (riba){
            case "Bolen":
                Toast.makeText(this.getActivity(), "Lovostaj: 01.04 - 31.05. - 25cm", Toast.LENGTH_LONG).show(); break;
            case "Deverika":
                Toast.makeText(this.getActivity(), "Lovostaj: 15.04. - 31.05.", Toast.LENGTH_LONG).show(); break;
            case "Glavatica":
                Toast.makeText(this.getActivity(), "Lovostaj: 16.02. - 30.09.", Toast.LENGTH_LONG).show(); break;
            case "Kečiga":
                Toast.makeText(this.getActivity(), "Lovostaj: 01.03. - 31.05. - 40cm", Toast.LENGTH_LONG).show(); break;
            case "Klen":
                Toast.makeText(this.getActivity(), "Lovostaj: 15.04. - 31.05.", Toast.LENGTH_LONG).show(); break;
            case "Linjak":
                Toast.makeText(this.getActivity(), "Lovostaj: Trajni lovostaj - 20cm", Toast.LENGTH_LONG).show(); break;
            case "Lipljen":
                Toast.makeText(this.getActivity(), "Lovostaj: 16.10. - 15.05. - 32cm (rijeka Kupa i Kupica) | 01.01. - 15.05. - 30cm (ostale vode)", Toast.LENGTH_LONG).show(); break;
            case "Mladica":
                Toast.makeText(this.getActivity(), "Lovostaj: 16.02. - 30.09.", Toast.LENGTH_LONG).show(); break;
            case "Mrena":
                Toast.makeText(this.getActivity(), "Lovostaj: Ne postoji - 28cm", Toast.LENGTH_LONG).show(); break;
            case "Jezerska pastrva":
                Toast.makeText(this.getActivity(), "Lovostaj: 01.10. - 28.02. - 40cm", Toast.LENGTH_LONG).show(); break;
            case "Potočna pastrva":
                Toast.makeText(this.getActivity(), "Lovostaj: 01.10. - 31.03. - 30cm (Kupa, Kupica, Čabranka, Park prirode Žumberak | 01.10. - 28/29. 02. - 30cm (ostale vode) | 50cm (Gacka)", Toast.LENGTH_LONG).show(); break;
            case "Smuđ":
                Toast.makeText(this.getActivity(), "Lovostaj: 01.03. - 31.05. - 40cm", Toast.LENGTH_LONG).show(); break;
            case "Som":
                Toast.makeText(this.getActivity(), "Lovostaj: 16.04.- 15.06. - 60cm (ne odnosi se na rijeku Dunav", Toast.LENGTH_LONG).show(); break;
            case "Divlji šaran":
                Toast.makeText(this.getActivity(), "Lovostaj: 01.04. - 31.05. - 40cm", Toast.LENGTH_LONG).show(); break;
            case "Štuka":
                Toast.makeText(this.getActivity(), "Lovostaj: 01.02. - 31.03. - 40cm", Toast.LENGTH_LONG).show(); break;
            case "Ljuskavi šaran":
                Toast.makeText(this.getActivity(), "Lovostaj: Ne postoji - 40cm", Toast.LENGTH_LONG).show(); break;
            case "Ribnjačarski šaran":
                Toast.makeText(this.getActivity(), "Lovostaj: Ne postoji - 40cm", Toast.LENGTH_LONG).show(); break;
            case "Veleljuskavi šaran":
                Toast.makeText(this.getActivity(), "Lovostaj: Ne postoji - 40cm", Toast.LENGTH_LONG).show(); break;
            case "Dvorednoljuskavi šaran":
                Toast.makeText(this.getActivity(), "Lovostaj: Ne postoji - 40cm", Toast.LENGTH_LONG).show(); break;
        }
    }

    private void updateDate() {
        Date datum = mAlbum.getDate();
        String formatiran = new SimpleDateFormat("EEE, d MMM yyyy").format(datum);
        mDateButton.setText(formatiran);
    }

    private void updatePhotoView() {
        if (mPhotoFile == null || !mPhotoFile.exists()){
            mImageView.setImageDrawable(null);
        }
        else {
            Bitmap bitmap = PictureUtils.getScaledBitmap(mPhotoFile.getPath(), getActivity());
            mImageView.setImageBitmap(bitmap);
        }
    }

    String[] ribePopis = {"Amur", "Babuška", "Balavac", "Bjelica", "Bolen", "Crvenperka", "Cvergl", "Deverika", "Gavčica",
                          "Glavatica", "Grgeč", "Pastrvski grgeč", "Jegulja", "Jez", "Karas", "Zlatni karas", "Kečiga", "Kesega",
            "Klen", "Klenić", "Krkuša", "Koljuška", "Krupatica", "Linjak", "Lipljen", "Manjić", "Dunavska paklara", "Riječna paklara",
            "Mladica", "Mrena", "Potočna mrena", "Kalifornijska pastrva", "Jezerska pastrva", "Potočna pastrva", "Peš", "Pior", "Plotica",
            "Podust", "Riječna babica", "Sabljarka", "Smuđ", "Som", "Sunčanica", "Divlji šaran", "Ljuskavi šaran", "Ribnjačarski šaran",
            "Veleljuskavi šaran", "Dvorednoljuskavi šaran", "Štuka", "Tolstolobik sivi", "Tolstolobik bijeli", "Jezerska zlatovčica",
            "Potočna zlatovčica", "Žutooka"
    };

}
