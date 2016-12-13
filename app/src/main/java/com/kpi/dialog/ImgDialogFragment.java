package com.kpi.dialog;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kpi.view.CircleImageView;
import com.storm.kpi.R;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 头像选取Dialog
 */
public class ImgDialogFragment extends DialogFragment implements View.OnClickListener {
    private CircleImageView logo;

    public ImgDialogFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.load_dialog);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_img_dialog, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        TextView paizhao = (TextView) view.findViewById(R.id.img_dialog_paizhao);
        TextView tuku = (TextView) view.findViewById(R.id.img_dialog_tuku);
        TextView cancel = (TextView) view.findViewById(R.id.img_dialog_cancel);
        logo = (CircleImageView) getActivity().findViewById(R.id.logo);
        paizhao.setOnClickListener(this);
        tuku.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            //拍照
            case R.id.img_dialog_paizhao:
                //MediaStore.ACTION_IMAGE_CAPTURE  调用系统的照相机
                intent = new Intent();
                intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0x1);
                break;
            case R.id.img_dialog_tuku:
                //打开手机的图库;
                intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 0x2);
                break;
            case R.id.img_dialog_cancel:
                getDialog().dismiss();
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //手机拍照的照片
        if (requestCode == 0x1) {
            if (data != null) {
                Bundle bundle = data.getExtras();
                Bitmap bitmap = bundle.getParcelable("data");
                logo.setImageBitmap(bitmap);
            } else {
                return;
            }
        }
        //图库选取的照片
        if (requestCode == 0x2) {
            if (data != null) {
                Uri uri = data.getData();
                getImg(uri);
            } else {
                return;
            }
        }
    }

    private void getImg(Uri uri) {
        try {
            InputStream inputStream = getActivity().getContentResolver().openInputStream(uri);
            //从输入流中解码位图
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            logo.setImageBitmap(bitmap);
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//find @ 的index  ，index  > 0 , find .的index  , index > @的index + 1
