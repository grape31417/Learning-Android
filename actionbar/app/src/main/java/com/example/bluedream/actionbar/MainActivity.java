package com.example.bluedream.actionbar;

import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RelativeLayout mRelativeLayout;
    private TextView mTxtView;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mActionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRelativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        registerForContextMenu(mRelativeLayout);
        mTxtView = (TextView) findViewById(R.id.txtView);
        registerForContextMenu(mTxtView);

        //actionBar
        ActionBar actBar = getSupportActionBar();
        actBar.setDisplayShowTitleEnabled(false);
        actBar.setLogo(R.drawable.app_logo);
        actBar.setDisplayUseLogoEnabled(true);
        actBar.setDisplayShowHomeEnabled(true);
        actBar.setBackgroundDrawable(new ColorDrawable(0xFF505050));

        actBar.setDisplayHomeAsUpEnabled(true);
        actBar.setHomeButtonEnabled(true);



        //drawlayout

        mDrawerLayout =(DrawerLayout)findViewById(R.id.DrawerLayout);
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.app_name,R.string.app_name);
        mActionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.addDrawerListener(mActionBarDrawerToggle);

        ListView mlistView=(ListView)findViewById(R.id.listview);
        ListView mlistView2=(ListView)findViewById(R.id.listview2);
        ArrayAdapter<CharSequence>adaapRegionList=ArrayAdapter.createFromResource(this,R.array.spnRegionList,android.R.layout.simple_list_item_1);
        mlistView.setAdapter(adaapRegionList);
        mlistView2.setAdapter(adaapRegionList);

        mlistView.setOnItemClickListener(listViewOnItemClick);
        mlistView2.setOnItemClickListener(listViewOnItemClick);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.menu_main,menu);

        Spinner spnRegion =(Spinner)menu.findItem(R.id.menuItemRegion).getActionView().findViewById(R.id.spnRegion);
        ArrayAdapter<CharSequence>adaapRegionList=ArrayAdapter.createFromResource(this,R.array.spnRegionList,android.R.layout.simple_spinner_item);
        spnRegion.setAdapter(adaapRegionList);
        spnRegion.setOnItemSelectedListener(spnRegionOnItemSelected);

        SearchView searchView = (SearchView)
                menu.findItem(R.id.menuItemSearch).getActionView();
        searchView.setOnQueryTextListener(searchViewOnQueryTextLis);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.menuItemPlayBackgroundMusic:
                Intent it =new Intent(MainActivity.this,MwdiaPlayService.class);
                startService(it);
                return true;
            case R.id.menuItemStopBackgroundMusic:
                it =new Intent(MainActivity.this,MwdiaPlayService.class);
                stopService(it);
                return true;
            case R.id.menuItemAbout:
                new AlertDialog.Builder(MainActivity.this).
                        setTitle("關於這個程式").setMessage("Example").setIcon(android.R.drawable.star_big_on).setPositiveButton("確定",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();
                return true;
            case R.id.menuItemExit:
                finish();
                return true;
            case R.id.menuItemRegion:
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("選擇地區")
                        .setMessage("這是選擇地區對話盒")
                        .setCancelable(false)
                        .setIcon(android.R.drawable.star_big_on)
                        .setPositiveButton("確定",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                    }
                                })
                        .show();

                return true;
            case R.id.menuItemSearch:
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("搜尋")
                        .setMessage("這是搜尋對話盒")
                        .setCancelable(false)
                        .setIcon(android.R.drawable.star_big_on)
                        .setPositiveButton("確定",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                    }
                                })
                        .show();

                return true;
        }
        if(mActionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return  super.onOptionsItemSelected(item);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v==mRelativeLayout) {
            if (menu.size() == 0)
            {
                getMenuInflater().inflate(R.menu.menu_main,menu);
            }
        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        onOptionsItemSelected(item);
        return super.onContextItemSelected(item);
    }

    private Spinner.OnItemSelectedListener spnRegionOnItemSelected= new Spinner.OnItemSelectedListener()
    {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(MainActivity.this,parent.getSelectedItem().toString(),Toast.LENGTH_LONG).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }
    };

    private SearchView.OnQueryTextListener searchViewOnQueryTextLis = new
            SearchView.OnQueryTextListener() {

                @Override
                public boolean onQueryTextChange(String newText) {
                    return false;
                }

                @Override
                public boolean onQueryTextSubmit(String query) {
                    Toast.makeText(MainActivity.this, query, Toast.LENGTH_LONG).show();

                    return true;
                }
            };

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mActionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mActionBarDrawerToggle.onConfigurationChanged(newConfig);
    }
    private AdapterView.OnItemClickListener listViewOnItemClick =new AdapterView.OnItemClickListener()
    {


        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(MainActivity.this,((TextView)view).getText(),Toast.LENGTH_SHORT).show();
            mDrawerLayout.closeDrawers();
        }
    };
}
