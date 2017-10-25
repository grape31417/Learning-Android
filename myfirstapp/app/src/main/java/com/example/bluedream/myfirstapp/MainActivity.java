package com.example.bluedream.myfirstapp;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText mEdtSex,mEdtAge;
    TextView mTxtR;
    Button mBtnok;
    private RadioGroup mRadGrpSex,mRadGrpAge;
    private RadioButton mRadBtnAgeRange1,mRadBtnAgeRange2,mRadBtnAgeRange3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mBtnok=(Button)findViewById(R.id.btnOK);
        mTxtR=(TextView)findViewById(R.id.txtR);
        mRadGrpAge=(RadioGroup)findViewById(R.id.radGrpAge) ;
        mRadGrpSex=(RadioGroup)findViewById(R.id.radGrpSex) ;
        mRadBtnAgeRange1=(RadioButton) findViewById(R.id.radBtnAgeRange1);
        mRadBtnAgeRange2=(RadioButton) findViewById(R.id.radBtnAgeRange2);
        mRadBtnAgeRange3=(RadioButton) findViewById(R.id.radBtnAgeRange3);
        mRadGrpSex.setOnCheckedChangeListener(radGrpSexOnCheckChange);


        mBtnok.setOnClickListener(btnOKOnClick);


    }

   private  View.OnClickListener btnOKOnClick=new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           String  strSug =getString(R.string.suggestion);
           switch (mRadGrpAge.getCheckedRadioButtonId())
           {
               case R.id.radBtnAgeRange1:
                   strSug+=getString(R.string.sug_not_hurry);
                   break;
               case R.id.radBtnAgeRange2:
                   strSug+=getString(R.string.sug_find_couple);
                   break;
               case R.id.radBtnAgeRange3:
                   strSug+=getString(R.string.sug_get_married);
                   break;

           }
        mTxtR.setText(strSug);

       }
   };

private RadioGroup.OnCheckedChangeListener radGrpSexOnCheckChange =new RadioGroup.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        if (checkedId==R.id.radBtnMale)
        {
            mRadBtnAgeRange1.setText(getString(R.string.male_age_range1));
            mRadBtnAgeRange2.setText(getString(R.string.male_age_range2));
            mRadBtnAgeRange3.setText(getString(R.string.male_age_range3));
        }
        else
        {
            mRadBtnAgeRange1.setText(getString(R.string.female_age_range1));
            mRadBtnAgeRange2.setText(getString(R.string.female_age_range2));
            mRadBtnAgeRange3.setText(getString(R.string.female_age_range3));

        }

    }
};

}
