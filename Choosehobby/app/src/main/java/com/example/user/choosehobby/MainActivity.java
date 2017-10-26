package com.example.user.choosehobby;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private CheckBox music,sing,dance,travel,reading,writing,climbing,swim,exercise,fitness,photo,eating,painting;
    private Button mbtnok;
    private TextView mTxtHobby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        music=(CheckBox)findViewById(R.id.checkBoxMusic);
        sing=(CheckBox)findViewById(R.id.checkBoxSing);
        dance=(CheckBox)findViewById(R.id.checkBoxDance);
        travel=(CheckBox)findViewById(R.id.checkBoxTravel);
        reading=(CheckBox)findViewById(R.id.checkBoxReadding);
        writing=(CheckBox)findViewById(R.id.checkBoxWriting);
        climbing=(CheckBox)findViewById(R.id.checkBoxClimb);
        swim=(CheckBox)findViewById(R.id.checkBoxSwim);
        exercise=(CheckBox)findViewById(R.id.checkBoxExcise);
        fitness=(CheckBox)findViewById(R.id.checkBoxFitness);
        photo=(CheckBox)findViewById(R.id.checkBoxPhoto);
        eating=(CheckBox)findViewById(R.id.checkBoxEat);
        painting=(CheckBox)findViewById(R.id.checkBoxPanting);
        mbtnok=(Button)findViewById(R.id.btnOK);
        mTxtHobby=(TextView)findViewById(R.id.textHobby);

        mbtnok.setOnClickListener(btnOKOnClick);
    }

    private View.OnClickListener btnOKOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String s= getString(R.string.your_hobby);
            if(music.isChecked())s+=music.getText().toString();
            if(sing.isChecked())s+=sing.getText().toString();
            if(dance.isChecked())s+=dance.getText().toString();
            if(travel.isChecked())s+=travel.getText().toString();
            if(reading.isChecked())s+=reading.getText().toString();
            if(writing.isChecked())s+=writing.getText().toString();
            if(climbing.isChecked())s+=climbing.getText().toString();
            if(swim.isChecked())s+=swim.getText().toString();
            if(exercise.isChecked())s+=exercise.getText().toString();
            if(fitness.isChecked())s+=fitness.getText().toString();
            if(photo.isChecked())s+=photo.getText().toString();
            if(eating.isChecked())s+=eating.getText().toString();
            if(painting.isChecked())s+=painting.getText().toString();

            mTxtHobby.setText(s);



        }
    };
}
