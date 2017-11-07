package com.example.user.dialogedit;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private Button mBtnLoginDlg;
    private TextView mTxtResult;
    private Dialog mDialogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnLoginDlg=(Button)findViewById(R.id.btnLoginDlg);
        mTxtResult=(TextView)findViewById(R.id.txtResult);

        mBtnLoginDlg.setOnClickListener(btnLoginDlgOnClick);
    }

    private View.OnClickListener btnLoginDlgOnClick =new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mTxtResult.setText("");
            mDialogin =new Dialog(MainActivity.this);
            mDialogin.setCancelable(false);
            mDialogin.setContentView(R.layout.mydlg);
            Button loginbtnOK =(Button)mDialogin.findViewById(R.id.btnOK);
            Button loginbtnCancle =(Button)mDialogin.findViewById(R.id.btnCancel);
            loginbtnCancle.setOnClickListener(loginDlgBtnCancelOnClick);
            loginbtnOK.setOnClickListener(loginDlgBtnOKOnClick);
            mDialogin.show();
        }
    };
    private View.OnClickListener loginDlgBtnOKOnClick = new View.OnClickListener() {
        public void onClick(View v) {
            EditText edtUserName = (EditText) mDialogin.findViewById(R.id.edtUserName);
            EditText edtPassword = (EditText) mDialogin.findViewById(R.id.edtPassword);

            mTxtResult.setText("你輸入的使用者名稱：" + edtUserName.getText().toString() +
                    "密碼：" + edtPassword.getText().toString());
            mDialogin.cancel();
        }
    };

    private View.OnClickListener loginDlgBtnCancelOnClick = new View.OnClickListener() {
        public void onClick(View v) {
            mTxtResult.setText("你按下\"取消\"按鈕");
            mDialogin.cancel();
        }
    };



}
