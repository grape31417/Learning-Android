package com.example.user.datepickertimepick;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    private TextView mTxtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mBtnTimePickDlg=(Button)findViewById(R.id.btnTimePickerDlg);
        Button mBtnDataPickDlg=(Button)findViewById(R.id.btnDatePickerDlg);
        mTxtResult=(TextView)findViewById(R.id.txtResult);

        mBtnDataPickDlg.setOnClickListener(btnDatePickerDlgOnClick);
        mBtnTimePickDlg.setOnClickListener(btnTimePickerDlgOnClick);


    }

    private View.OnClickListener btnDatePickerDlgOnClick =new View.OnClickListener() {
        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void onClick(View v) {
            mTxtResult.setText("");
            Calendar now= Calendar.getInstance();
            DatePickerDialog datePickerDialog =new DatePickerDialog(MainActivity.this,datePickerDlgOnDateSet,now.get(Calendar.YEAR),now.get(Calendar.MONTH),now.get(Calendar.DAY_OF_MONTH)) ;
            datePickerDialog.setTitle("選擇日期");
            datePickerDialog.setMessage("請選擇適合你的日期");
            datePickerDialog.setIcon(android.R.drawable.ic_dialog_info);
            datePickerDialog.setCancelable(false);

            datePickerDialog.show();
        }
    };

    private DatePickerDialog.OnDateSetListener datePickerDlgOnDateSet =new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            mTxtResult.setText("你選擇的日期是" + Integer.toString(year) + "年" + Integer.toString(month + 1) + "月" + Integer.toString(dayOfMonth) + "日");

        }
    };

        private View.OnClickListener btnTimePickerDlgOnClick = new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                mTxtResult.setText("");
                Calendar now= Calendar.getInstance();
                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this,timePickDlgOnTimeSet,
                        now.get(Calendar.HOUR_OF_DAY),
                        now.get(Calendar.MINUTE)
                ,true) ;
                timePickerDialog.show();
            }
        };



    private  TimePickerDialog.OnTimeSetListener timePickDlgOnTimeSet = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            mTxtResult.setText("你選擇的時間是"+Integer.toString(hourOfDay)+"時"+Integer.toString(minute)+"分");

        }
    };
}

