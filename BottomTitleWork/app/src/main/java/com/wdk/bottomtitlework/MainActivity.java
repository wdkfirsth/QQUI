package com.wdk.bottomtitlework;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.wdk.adapter.ViewPagerAdapter;
import com.wdk.fragment.ActionFragment;
import com.wdk.fragment.FriendsFragment;
import com.wdk.fragment.InfoFragment;
import com.wdk.fragment.LookFragment;
import com.wdk.tools.BottomHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.bottom_view)
    BottomNavigationView bottomView;
    @BindView(R.id.cir1)
    CircleImageView cir1;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.drawer)
    DrawerLayout drawer;
    private MenuItem menuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //去除反弹
        BottomHelper.disableShiftMode(bottomView);
//        //为bottomnavigationview添加监听
        bottomView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.info_item:
                        viewPager.setCurrentItem(0);
                        break;
                    case  R.id.friends_item:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.look_item:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.action_item:
                        viewPager.setCurrentItem(3);
                        break;
                    default:
                        break;
                }
                return false;
            }
        });

        //绑定viewPagerAdapter
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.add(new InfoFragment());
        adapter.add(new FriendsFragment());
        adapter.add(new LookFragment());
        adapter.add(new ActionFragment());
        viewPager.setAdapter(adapter);
        //为view pager添加监听
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                menuItem = bottomView.getMenu().getItem(position);
                menuItem.setChecked(true);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }


    @OnClick(R.id.cir1)
    public void onViewClicked() {
        drawer.openDrawer(GravityCompat.START);
    }
}
