package com.example.user.relativelayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mTxtComplay,mTxtResult;
    private Button mSicssors,mStone,mPaper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTxtComplay=(TextView)findViewById(R.id.txtComPlay);
        mTxtResult=(TextView)findViewById(R.id.txtResult);
        mSicssors=(Button)findViewById(R.id.Scissors);
        mPaper=(Button)findViewById(R.id.paper);
        mStone=(Button)findViewById(R.id.stone);

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
                mTxtComplay.setText(R.string.scissors);
                mTxtResult.setText(getString(R.string.result)+getString(R.string.draw));
            }
           else if(iComPlay==2)
            {
                mTxtComplay.setText(R.string.stone);
                mTxtResult.setText(getString(R.string.result)+getString(R.string.you_lose));
            }
            else
            {
                mTxtComplay.setText(R.string.paper);
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
                mTxtComplay.setText(R.string.scissors);
                mTxtResult.setText(getString(R.string.result)+getString(R.string.you_win));
            }
            else if(iComPlay==2)
            {
                mTxtComplay.setText(R.string.stone);
                mTxtResult.setText(getString(R.string.result)+getString(R.string.draw));
            }
            else
            {
                mTxtComplay.setText(R.string.paper);
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
                mTxtComplay.setText(R.string.scissors);
                mTxtResult.setText(getString(R.string.result)+getString(R.string.you_lose));
            }
            else if(iComPlay==2)
            {
                mTxtComplay.setText(R.string.stone);
                mTxtResult.setText(getString(R.string.result)+getString(R.string.you_win));
            }
            else
            {
                mTxtComplay.setText(R.string.paper);
                mTxtResult.setText(getString(R.string.result)+getString(R.string.draw));
            }
        }
    };
}
