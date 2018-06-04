package com.wdk.bottomtitlework;

import android.graphics.Color;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toolbar;

import java.security.acl.Group;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
   private BottomNavigationView bottom_nav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android.support.v7.widget.Toolbar toolbar=(android.support.v7.widget.Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       bottom_nav=(BottomNavigationView)findViewById(R.id.bottom);
        final NavigationView nav_view=(NavigationView)findViewById(R.id.nav_view);
        CircleImageView cir1=(CircleImageView)findViewById(R.id.cir1);
        final DrawerLayout drawer=(DrawerLayout)findViewById(R.id.drawer);
       BottomHelper.disableShiftMode(bottom_nav);
        cir1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(GravityCompat.START);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return  true;
    }
}
