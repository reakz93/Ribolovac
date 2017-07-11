package android.fkvestak.com.ribolovac.Album;

import android.app.Dialog;
import android.content.Context;
import android.fkvestak.com.ribolovac.R;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.FitWindowsLinearLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

/**
 * Created by Kvec on 10.11.2016..
 */

public class ImageDialog extends DialogFragment {

    private ImageView imageView;
    private static String imagePath;
    private static Context con;

    public static void getImage(String path, Context context){
        imagePath = path;
        con = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.dialog_image, container, false);

        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);

        imageView = (ImageView) view.findViewById(R.id.imageView);
        Bitmap bitmap = PictureUtils.getScaledBitmap(imagePath,getActivity());
        imageView.setImageBitmap(bitmap);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

        return view;
    }

}
