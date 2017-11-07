package com.example.user.aleartdialog;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button mBtnAlertDlg,mBtnAlertDlgBuilder;
    private TextView mTxtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnAlertDlg= (Button)findViewById(R.id.btnAlertDlg);
        mBtnAlertDlgBuilder=(Button)findViewById(R.id.btnAlertDlgBuilder);
        mTxtResult=(TextView)findViewById(R.id.txtResult);

        mBtnAlertDlgBuilder.setOnClickListener(btnAleartDlgBuilderOnClick);
        mBtnAlertDlg.setOnClickListener(btnAleartDlgOnClick);
    }

    public class MyAlerDialog extends AlertDialog{

        protected MyAlerDialog(@NonNull Context context) {
            super(context);
        }
    }

    private View.OnClickListener  btnAleartDlgOnClick=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mTxtResult.setText("");
            MyAlerDialog myAltDlg = new MyAlerDialog(MainActivity.this);
            myAltDlg.setTitle("AlertDialog");
            myAltDlg.setMessage("AlertDialog的使用方式是要建立一個繼承它的class");
            myAltDlg.setIcon(android.R.drawable.ic_dialog_info);
            myAltDlg.setCancelable(false);
            myAltDlg.setButton(DialogInterface.BUTTON_POSITIVE,"是",algYes);
            myAltDlg.setButton(DialogInterface.BUTTON_NEGATIVE,"否",algNO);
            myAltDlg.setButton(DialogInterface.BUTTON_NEUTRAL,"取消",algCancle);
            myAltDlg.show();
        }
    };

    private DialogInterface.OnClickListener algYes = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            mTxtResult.setText("你啟動了AlertDialog而且按下了 是");
        }
    };

    private DialogInterface.OnClickListener algNO = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            mTxtResult.setText("你啟動了AlertDialog而且按下了 否");
        }
    };

    private DialogInterface.OnClickListener algCancle = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            mTxtResult.setText("你啟動了AlertDialog而且按下了 取消");
        }
    };

    private View.OnClickListener btnAleartDlgBuilderOnClick= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mTxtResult.setText("");
            AlertDialog.Builder altDlgBldr= new AlertDialog.Builder(MainActivity.this);
            altDlgBldr.setTitle("AlertDialog");
            altDlgBldr.setMessage("由AlertDialog.Builder產生");
            altDlgBldr.setIcon(android.R.drawable.ic_dialog_info);
            altDlgBldr.setCancelable(false);

            altDlgBldr.setPositiveButton("是", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    mTxtResult.setText("你啟動了AlertDialog.Builder而且按下了 是");
                }
            });

            altDlgBldr.setNegativeButton("否", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    mTxtResult.setText("你啟動了AlertDialog.Builder而且按下了 否");
                }
            });

            altDlgBldr.setNeutralButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    mTxtResult.setText("你啟動了AlertDialog.Builder而且按下了 否");
                }
            });
            altDlgBldr.show();

        }
    };
}
