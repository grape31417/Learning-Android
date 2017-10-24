package com.example.bluedream.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText mEdtSex,mEdtAge;
    TextView mTxtR;
    Button mBtnok;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEdtAge=(EditText)findViewById(R.id.edtAge);
        mEdtSex=(EditText)findViewById(R.id.edtAge);
        mBtnok=(Button)findViewById(R.id.btnOK);
        mTxtR=(TextView)findViewById(R.id.txtR);

        mBtnok.setOnClickListener(btnOKOnClick);


    }

   private  View.OnClickListener btnOKOnClick=new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           String strSex=mEdtSex.getText().toString();
           int iAge=Integer.parseInt(mEdtAge.getText().toString());
           String  strSug =getString(R.string.suggestion);
           if (strSex.equals(getString(R.string.sex_male))) {
               if (iAge < 28) {
                   strSug += getString(R.string.sug_not_hurry);
                   Log.d("Marrisug", "man,don't hurry");
               } else if (iAge > 33) {
                   strSug += getString(R.string.sug_get_married);
                   Log.d("Marrisug", "man, hurry to get married!");
               } else {
                   strSug += getString(R.string.sug_find_couple);
                   Log.d("Marrisug", "man,start to find girl friend");
               }
           }
           else{
               if (iAge < 28)
               {
                   strSug += getString(R.string.sug_not_hurry);
                   Log.d("Marrisug", "woman,don't hurry");
               }
               else if (iAge > 33)
               {
                   strSug += getString(R.string.sug_get_married);
                   Log.d("Marrisug", "woman, hurry to get married!");
               }
               else
               {
                   strSug += getString(R.string.sug_find_couple);
                   Log.d("Marrisug", "woman,start to find boy friend");
               }
           }

           mTxtR.setText(strSug);

       }
   };


}
