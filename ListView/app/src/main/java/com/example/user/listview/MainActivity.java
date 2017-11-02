package com.example.user.listview;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ListActivity {
    private TextView mTextResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextResult =(TextView)findViewById(R.id.txtResult);
       // ArrayAdapter<CharSequence> arrayWeekdays = ArrayAdapter.createFromResource(this,R.array.weekday,android.R.layout.simple_list_item_1);
       // setListAdapter(arrayWeekdays);
        ListView ListView =getListView();
        ListView.setOnItemClickListener(listViewOnItemClick);

    }
    private AdapterView.OnItemClickListener  listViewOnItemClick= new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            mTextResult.setText(((TextView)view).getText());
        }
    };

}
