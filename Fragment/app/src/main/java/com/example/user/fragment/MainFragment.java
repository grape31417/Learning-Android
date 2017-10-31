package com.example.user.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    private TextView mTxtResult;
    private ImageButton mSicssors,mStone,mPaper;
    private ImageView mImgViewComplay;
    private TextView mEdtCountSet,mEdtCountPlayerWin,mEdtCountComWin,mEdtCountDraw;
    private int miCountSet=0;
    private int miCountPlayerWin=0;
    private int miCountComWin=0;
    private int miCountDraw=0;



    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }



    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mImgViewComplay =(ImageView)getView(). findViewById(R.id.imgViewComPlay);
        mTxtResult=(TextView)getView(). findViewById(R.id.txtResult);
        mSicssors=(ImageButton)getView(). findViewById(R.id.imgBtnScissors);
        mPaper=(ImageButton)getView(). findViewById(R.id.imgBtnPaper);
        mStone=(ImageButton)getView(). findViewById(R.id.imgBtnStone);
        mEdtCountSet=(EditText)getActivity().findViewById(R.id.edtCountSet);
        mEdtCountPlayerWin=(EditText)getActivity().findViewById(R.id.edtCountPlayerWin);
        mEdtCountComWin=(EditText)getActivity().findViewById(R.id.edtCountComWint);
        mEdtCountDraw=(EditText)getActivity().findViewById(R.id.edtCountDraw);

        mSicssors.setOnClickListener(btnSicssors);
        mStone.setOnClickListener(btnStone);
        mPaper.setOnClickListener(btnPaper);
    }

    private View.OnClickListener btnSicssors =new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int iComPlay =(int)(Math.random()*3+1);//1:剪刀 2:石頭 3:布
            miCountSet++;
            mEdtCountSet.setText(String.valueOf(miCountSet));
            if(iComPlay==1)
            {
                mImgViewComplay.setImageResource(R.drawable.scissors);
                mTxtResult.setText(getString(R.string.result)+getString(R.string.draw));
                miCountDraw++;
                mEdtCountDraw.setText(String.valueOf(miCountDraw));
            }
            else if(iComPlay==2)
            {
                mImgViewComplay.setImageResource(R.drawable.stone);
                mTxtResult.setText(getString(R.string.result)+getString(R.string.you_lose));
                miCountComWin++;
                mEdtCountComWin.setText(String.valueOf(miCountComWin));
            }
            else
            {
                mImgViewComplay.setImageResource(R.drawable.paper);
                mTxtResult.setText(getString(R.string.result)+getString(R.string.you_win));
                miCountPlayerWin++;
                mEdtCountPlayerWin.setText(String.valueOf(miCountPlayerWin));
            }
        }
    };
    private View.OnClickListener btnStone =new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int iComPlay =(int)(Math.random()*3+1);//1:剪刀 2:石頭 3:布
            miCountSet++;
            mEdtCountSet.setText(String.valueOf(miCountSet));
            if(iComPlay==1)
            {
                mImgViewComplay.setImageResource(R.drawable.scissors);
                mTxtResult.setText(getString(R.string.result)+getString(R.string.you_win));
                miCountPlayerWin++;
                mEdtCountPlayerWin.setText(String.valueOf(miCountPlayerWin));
            }
            else if(iComPlay==2)
            {
                mImgViewComplay.setImageResource(R.drawable.stone);
                mTxtResult.setText(getString(R.string.result)+getString(R.string.draw));
                miCountDraw++;
                mEdtCountDraw.setText(String.valueOf(miCountDraw));
            }
            else
            {
                mImgViewComplay.setImageResource(R.drawable.paper);
                mTxtResult.setText(getString(R.string.result)+getString(R.string.you_lose));
                miCountComWin++;
                mEdtCountComWin.setText(String.valueOf(miCountComWin));
            }
        }
    };

    private View.OnClickListener btnPaper =new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int iComPlay =(int)(Math.random()*3+1);//1:剪刀 2:石頭 3:布
            miCountSet++;
            mEdtCountSet.setText(String.valueOf(miCountSet));
            if(iComPlay==1)
            {
                mImgViewComplay.setImageResource(R.drawable.scissors);
                mTxtResult.setText(getString(R.string.result)+getString(R.string.you_lose));
                miCountComWin++;
                mEdtCountComWin.setText(String.valueOf(miCountComWin));
            }
            else if(iComPlay==2)
            {
                mImgViewComplay.setImageResource(R.drawable.stone);
                mTxtResult.setText(getString(R.string.result)+getString(R.string.you_win));
                miCountPlayerWin++;
                mEdtCountPlayerWin.setText(String.valueOf(miCountPlayerWin));
            }
            else
            {
                mImgViewComplay.setImageResource(R.drawable.paper);
                mTxtResult.setText(getString(R.string.result)+getString(R.string.draw));
                miCountDraw++;
                mEdtCountDraw.setText(String.valueOf(miCountDraw));
            }
        }
    };
}



