package com.bluedream.user.character;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.bluedream.user.character.person.Character;
import com.bluedream.user.character.person.King;
import com.bluedream.user.character.person.Knight;
import com.bluedream.user.character.person.Queen;
import com.bluedream.user.character.person.Troll;
import com.bluedream.user.character.wepon.AxeBehavior;
import com.bluedream.user.character.wepon.BowBehavior;
import com.bluedream.user.character.wepon.KnifeBehavior;
import com.bluedream.user.character.wepon.SwordBehavior;
import com.bluedream.user.character.wepon.WeponBehavior;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.widget.ArrayAdapter.createFromResource;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.Chacter)
    Spinner Chacter;
    @BindView(R.id.usewepon)
    Spinner usewepon;
    @BindView(R.id.textview)
    TextView textview;
    Character King, Queen, Knight, Troll,SelcteJob;
    WeponBehavior Axe, Bow, Knife, Sword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        spinnerset();
    }

    private void spinnerset() {
        ArrayAdapter<CharSequence> ChacterAdapter = createFromResource(
                this, R.array.chacter_list, android.R.layout.simple_spinner_item);
        ChacterAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        Chacter.setAdapter(ChacterAdapter);

        ArrayAdapter<CharSequence> WeponAdapter = createFromResource(
                this, R.array.wepon_list, android.R.layout.simple_spinner_item);
        WeponAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        usewepon.setAdapter(WeponAdapter);
        Chacter.setOnItemSelectedListener(CharActer);
        usewepon.setOnItemSelectedListener(wepon);


    }


    AdapterView.OnItemSelectedListener CharActer = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            switch (adapterView.getItemAtPosition(i).toString()) {
                case "國王":
                    textview.setText("");
                    King = new King(textview);
                    SelcteJob=King;
                    King.display();
                    break;
                case "皇后":
                    textview.setText("");
                    Queen = new Queen(textview);
                    SelcteJob=Queen;
                    Queen.display();
                    break;
                case "騎士":
                    textview.setText("");
                    Knight = new Knight(textview);
                    SelcteJob=Knight;
                    Knight.display();
                    break;
                case "巨人":
                    textview.setText("");
                    Troll = new Troll(textview);
                    SelcteJob=Troll;
                    Troll.display();
                    break;

            }

        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };


    AdapterView.OnItemSelectedListener wepon = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            switch (adapterView.getItemAtPosition(i).toString()) {
                case "斧":
                    textview.setText("");
                    SelcteJob.display();
                    SelcteJob.setWeponBehavior(new AxeBehavior());
                    SelcteJob.usewepon();
                    SelcteJob.fight();
                    break;
                case "弓":
                    textview.setText("");
                    SelcteJob.display();
                    SelcteJob.setWeponBehavior(new BowBehavior());
                    SelcteJob.usewepon();
                    SelcteJob.fight();
                    break;
                case "長劍":
                    textview.setText("");
                    SelcteJob.display();
                    SelcteJob.setWeponBehavior(new SwordBehavior());
                    SelcteJob.usewepon();
                    SelcteJob.fight();
                    break;
                case "刀":
                    textview.setText("");
                    SelcteJob.display();
                    SelcteJob.setWeponBehavior(new KnifeBehavior());
                    SelcteJob.usewepon();
                    SelcteJob.fight();
                    break;

            }

        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };


}
