package com.example.bluedream.contentmenu;

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
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private static final int Menu_MUSIC= Menu.FIRST,
            Menu_Play_MUSIC=Menu.FIRST+1,
            Menu_Stop_Playmusc=Menu.FIRST+2,
            Menu_About=Menu.FIRST+3,
            Menu_Exit=Menu.FIRST+4;


    private RelativeLayout mRelativeLayout;
    private TextView mTxtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRelativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        registerForContextMenu(mRelativeLayout);
        mTxtView = (TextView) findViewById(R.id.txtView);
        registerForContextMenu(mTxtView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        SubMenu subMenu =  menu.addSubMenu(0,Menu_MUSIC,0,"背景音樂");
        subMenu.setIcon(android.R.drawable.ic_media_ff);
        subMenu.add(0,Menu_Play_MUSIC,0,"播放背景音樂");
        subMenu.add(0,Menu_Stop_Playmusc,1,"停止播放背景音樂");
        menu.add(0,Menu_About,1,"關於").setIcon(android.R.drawable.ic_dialog_info);
        menu.add(0,Menu_Exit,2,"結束").setIcon(android.R.drawable.ic_menu_close_clear_cancel);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case Menu_Play_MUSIC:
                Intent it =new Intent(MainActivity.this,MwdiaPlayService.class);
                startService(it);
                return true;
            case Menu_Stop_Playmusc:
                it =new Intent(MainActivity.this,MwdiaPlayService.class);
                stopService(it);
                return true;
            case Menu_About:
                new AlertDialog.Builder(MainActivity.this).
                        setTitle("關於這個程式").setMessage("Example").setIcon(android.R.drawable.star_big_on).setPositiveButton("確定",
                        new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
                return true;
            case Menu_Exit:
                finish();
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
                SubMenu subMenu = menu.addSubMenu(0, Menu_MUSIC, 0, "背景音樂");
                subMenu.setIcon(android.R.drawable.ic_media_ff);
                subMenu.add(0, Menu_Play_MUSIC, 0, "播放背景音樂");
                subMenu.add(0, Menu_Stop_Playmusc, 1, "停止播放背景音樂");
                (menu.add(0, Menu_About, 1, "關於")).setIcon(android.R.drawable.ic_dialog_info);
                menu.add(0, Menu_Exit, 2, "結束").setIcon(android.R.drawable.ic_menu_close_clear_cancel);
            }
        }
            else if (v==mTxtView)
                menu.add(0,Menu_About,1,"關於").setIcon(android.R.drawable.ic_dialog_info);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        onOptionsItemSelected(item);
        return super.onContextItemSelected(item);
    }
}
