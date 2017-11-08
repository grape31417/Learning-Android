package com.example.user.IntentCarryData;
import android.content.Intent;
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
    private Button mBtnShowResult;
    private int miCountSet = 0,
            miCountPlayerWin = 0,
            miCountComWin = 0,
            miCountDraw = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTxtComplay=(ImageView) findViewById(R.id.imgViewComPlay);
        mTxtResult=(TextView)findViewById(R.id.txtResult);
        mSicssors=(ImageButton)findViewById(R.id.imgBtnScissors);
        mPaper=(ImageButton)findViewById(R.id.imgBtnPaper);
        mStone=(ImageButton)findViewById(R.id.imgBtnStone);
        mBtnShowResult=(Button)findViewById(R.id.btnShowResult) ;

        mSicssors.setOnClickListener(btnSicssors);
        mStone.setOnClickListener(btnStone);
        mPaper.setOnClickListener(btnPaper);
        mBtnShowResult.setOnClickListener(btnShowResult);
    }

    private View.OnClickListener btnSicssors =new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int iComPlay =(int)(Math.random()*3+1);//1:剪刀 2:石頭 3:布
            miCountSet++;
            if(iComPlay==1)
            {
                miCountDraw++;
                mTxtComplay.setImageResource(R.drawable.scissors);
                mTxtResult.setText(getString(R.string.result)+getString(R.string.draw));
            }
           else if(iComPlay==2)
            {
                miCountComWin++;
                mTxtComplay.setImageResource(R.drawable.stone);
                mTxtResult.setText(getString(R.string.result)+getString(R.string.you_lose));
            }
            else
            {
                miCountPlayerWin++;
                mTxtComplay.setImageResource(R.drawable.paper);
                mTxtResult.setText(getString(R.string.result)+getString(R.string.you_win));
            }
        }
    };
    private View.OnClickListener btnStone =new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int iComPlay =(int)(Math.random()*3+1);//1:剪刀 2:石頭 3:布
            miCountSet++;
            if(iComPlay==1)
            {
                mTxtComplay.setImageResource(R.drawable.scissors);
                mTxtResult.setText(getString(R.string.result)+getString(R.string.you_win));
                miCountPlayerWin++;
            }
            else if(iComPlay==2)
            {
                mTxtComplay.setImageResource(R.drawable.stone);
                mTxtResult.setText(getString(R.string.result)+getString(R.string.draw));
                miCountDraw++;
            }
            else
            {
                miCountComWin++;
                mTxtComplay.setImageResource(R.drawable.paper);
                mTxtResult.setText(getString(R.string.result)+getString(R.string.you_lose));
            }
        }
    };

    private View.OnClickListener btnPaper =new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int iComPlay =(int)(Math.random()*3+1);//1:剪刀 2:石頭 3:布
            miCountSet++;
            if(iComPlay==1)
            {
                miCountComWin++;
                mTxtComplay.setImageResource(R.drawable.scissors);
                mTxtResult.setText(getString(R.string.result)+getString(R.string.you_lose));
            }
            else if(iComPlay==2)
            {
                miCountPlayerWin++;
                mTxtComplay.setImageResource(R.drawable.stone);
                mTxtResult.setText(getString(R.string.result)+getString(R.string.you_win));
            }
            else
            {
                miCountDraw++;
                mTxtComplay.setImageResource(R.drawable.paper);
                mTxtResult.setText(getString(R.string.result)+getString(R.string.draw));
            }
        }
    };

    private View.OnClickListener btnShowResult = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent it = new Intent();
            it.setClass(MainActivity.this,gameResult.class);

            Bundle bundle =new Bundle();
            bundle.putInt("KEY_COUNT_SET", miCountSet);
            bundle.putInt("KEY_COUNT_PLAYER_WIN", miCountPlayerWin);
            bundle.putInt("KEY_COUNT_COM_WIN", miCountComWin);
            bundle.putInt("KEY_COUNT_DRAW", miCountDraw);
            it.putExtras(bundle);

            startActivity(it);

        }
    };
}
