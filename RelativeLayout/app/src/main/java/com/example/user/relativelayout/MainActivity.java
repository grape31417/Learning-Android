package com.example.user.relativelayout;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mTxtResult;
    private ImageButton mSicssors,mStone,mPaper;
    private ImageView mTxtComplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTxtComplay=(ImageView) findViewById(R.id.imgViewComPlay);
        mTxtResult=(TextView)findViewById(R.id.txtResult);
        mSicssors=(ImageButton)findViewById(R.id.imgBtnScissors);
        mPaper=(ImageButton)findViewById(R.id.imgBtnPaper);
        mStone=(ImageButton)findViewById(R.id.imgBtnStone);

        mSicssors.setOnClickListener(btnSicssors);
        mStone.setOnClickListener(btnStone);
        mPaper.setOnClickListener(btnPaper);
    }

    private View.OnClickListener btnSicssors =new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int iComPlay =(int)(Math.random()*3+1);//1:剪刀 2:石頭 3:布
            if(iComPlay==1)
            {
                mTxtComplay.setImageResource(R.drawable.scissors);
                mTxtResult.setText(getString(R.string.result)+getString(R.string.draw));
            }
           else if(iComPlay==2)
            {
                mTxtComplay.setImageResource(R.drawable.stone);
                mTxtResult.setText(getString(R.string.result)+getString(R.string.you_lose));
            }
            else
            {
                mTxtComplay.setImageResource(R.drawable.paper);
                mTxtResult.setText(getString(R.string.result)+getString(R.string.you_win));
            }
        }
    };
    private View.OnClickListener btnStone =new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int iComPlay =(int)(Math.random()*3+1);//1:剪刀 2:石頭 3:布
            if(iComPlay==1)
            {
                mTxtComplay.setImageResource(R.drawable.scissors);
                mTxtResult.setText(getString(R.string.result)+getString(R.string.you_win));
            }
            else if(iComPlay==2)
            {
                mTxtComplay.setImageResource(R.drawable.stone);
                mTxtResult.setText(getString(R.string.result)+getString(R.string.draw));
            }
            else
            {
                mTxtComplay.setImageResource(R.drawable.paper);
                mTxtResult.setText(getString(R.string.result)+getString(R.string.you_lose));
            }
        }
    };

    private View.OnClickListener btnPaper =new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int iComPlay =(int)(Math.random()*3+1);//1:剪刀 2:石頭 3:布
            if(iComPlay==1)
            {
                mTxtComplay.setImageResource(R.drawable.scissors);
                mTxtResult.setText(getString(R.string.result)+getString(R.string.you_lose));
            }
            else if(iComPlay==2)
            {
                mTxtComplay.setImageResource(R.drawable.stone);
                mTxtResult.setText(getString(R.string.result)+getString(R.string.you_win));
            }
            else
            {
                mTxtComplay.setImageResource(R.drawable.paper);
                mTxtResult.setText(getString(R.string.result)+getString(R.string.draw));
            }
        }
    };
}
