package com.example.user.intent;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity {
 private Button mBtnBrowseWWW, mBtnEditImg,mBtnViewImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnBrowseWWW=(Button)findViewById(R.id.btnBrowseWWW);
        mBtnEditImg =(Button)findViewById(R.id.btnPlayMP3);
        mBtnViewImg=(Button)findViewById(R.id.btnViewImg);

        mBtnViewImg.setOnClickListener(ViewImageOnClick);
        mBtnEditImg.setOnClickListener(EditImgOnClick);
        mBtnBrowseWWW.setOnClickListener(BrowseWWWOnClick);
    }

    private View.OnClickListener ViewImageOnClick =new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent it= new Intent(Intent.ACTION_VIEW);
           // String sImgFile = Environment.getExternalStorageDirectory().getPath()+ File.separator+"image.png";
            File file =new File("/sdcard/image.png");
            it.setDataAndType(Uri.fromFile(file),"image/*");
            startActivity(it);
        }
    };
    private View.OnClickListener EditImgOnClick =new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent it =new Intent(Intent.ACTION_EDIT);
            File file = new File("/sdcard/image.png");
            it.setDataAndType(Uri.fromFile(file),"image/*");
            startActivity(it);
        }
    };
    /*private View.OnClickListener PlayMp3OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent it= new Intent(Intent.ACTION_VIEW);
            String sMp3File = Environment.getExternalStorageDirectory().getPath()+ File.separator+"song.mp3";
            File file =new File(sMp3File);
            boolean b=file.exists();
            it.setDataAndType(Uri.fromFile(file),"audio/*");
            startActivity(it);

        }
    };*/

    private View.OnClickListener BrowseWWWOnClick =new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Uri uri =Uri.parse("https://www.google.com.tw/");
            Intent it =new Intent(Intent.ACTION_VIEW,uri);
            startActivity(it);
        }
    };
}
