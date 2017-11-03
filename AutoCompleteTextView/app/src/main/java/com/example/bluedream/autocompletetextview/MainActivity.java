package com.example.bluedream.autocompletetextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mBtnAdd,mBtnClear;
    private AutoCompleteTextView mAutoComTextview;
    private ArrayAdapter<String> mAdapAutoCompText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnAdd =(Button)findViewById(R.id.btnAddAutoCompleteText);
        mBtnClear =(Button)findViewById(R.id.btnClearText);
        mAutoComTextview=(AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        mAdapAutoCompText= new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line);

        mAutoComTextview.setAdapter(mAdapAutoCompText);
        mBtnClear.setOnClickListener(btnClear);
        mBtnAdd.setOnClickListener(btnAddAutoCompleteText);
    }


    private View.OnClickListener btnAddAutoCompleteText= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String S =mAutoComTextview.getText().toString();
            mAdapAutoCompText.add(S);
            mAutoComTextview.setText("");
        }
    };

    private View.OnClickListener btnClear = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mAdapAutoCompText.clear();

        }
    };
}
