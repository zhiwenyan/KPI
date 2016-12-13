package com.kpi.activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.hyphenate.chat.EMConversation;
import com.hyphenate.easeui.EaseConstant;
import com.hyphenate.easeui.ui.EaseConversationListFragment;
import com.kpi.adapter.viewPagerAdapter;
import com.kpi.base.BaseActivity;
import com.kpi.fragment.HomeFragment;
import com.kpi.fragment.MyKPIFragment;
import com.kpi.fragment.WorkingFragment;
import com.kpi.utils.ToastUtils;
import com.storm.kpi.R;

/**
 * 主页面  ————》业务逻辑
 */
public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {
    private ViewPager viewPager;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;
    private RadioButton radioButton5;
    private EaseConversationListFragment conversationListFragment = new EaseConversationListFragment();


//        //抽屉式布局
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.setDrawerListener(toggle);
//        toggle.syncState();
//        toggle.setHomeAsUpIndicator(new ColorDrawable(Color.WHITE));
//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);


    @Override
    public void initData() {
        initFragment();
        conversationListFragment.setConversationListItemClickListener(new EaseConversationListFragment.EaseConversationListItemClickListener() {
            @Override
            public void onListItemClicked(EMConversation conversation) {
                startActivity(new Intent(MainActivity.this, ChatActivity.class).putExtra(EaseConstant.EXTRA_USER_ID, conversation.getUserName()));
            }
        });
    }

    @Override
    public int getLayoutID() {
        return R.layout.app_bar_main;
    }

    @Override
    public void initToolBar() {

    }

    @Override
    //初始化布局
    public void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.home);
        radioButton1 = (RadioButton) findViewById(R.id.rb_home);
        radioButton2 = (RadioButton) findViewById(R.id.rb_redian);
        radioButton3 = (RadioButton) findViewById(R.id.rb_shiting);
        //    radioButton4 = (RadioButton) findViewById(R.id.rb_shezhi);
        radioButton5 = (RadioButton) findViewById(R.id.rb_MyKPI);
        radioGroup.setOnCheckedChangeListener(this);

    }


    @Override
    public void initListener() {

    }


    //初始化Fragment
    private void initFragment() {
        viewPagerAdapter adapter = new viewPagerAdapter(getSupportFragmentManager());
        adapter.AddFragment(new HomeFragment());  //主页面
        adapter.AddFragment(conversationListFragment);   //消息
        adapter.AddFragment(new WorkingFragment());   //门店
        adapter.AddFragment(new MyKPIFragment());    //我的智码
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new onPageChange());
        viewPager.setOffscreenPageLimit(adapter.getCount());
    }

//    @SuppressWarnings("StatementWithEmptyBody")
//    @Override
//    public boolean onNavigationItemSelected(MenuItem item) {
//        int id = item.getItemId();
//
//        if (id == R.id.nav_camera) {
//        } else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
//        return true;
//    }


    //RadioGroup监听事件
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_home:
                viewPager.setCurrentItem(0);
                radioButton1.setChecked(true);
                break;
            case R.id.rb_redian:
                viewPager.setCurrentItem(1);
                radioButton2.setChecked(true);
                break;
            case R.id.rb_shiting:
                viewPager.setCurrentItem(2);
                radioButton3.setChecked(true);
                break;
            //       case R.id.rb_shezhi:
            //       viewPager.setCurrentItem(3);
            //      radioButton4.setChecked(true);
            //          break;
            case R.id.rb_MyKPI:
                viewPager.setCurrentItem(4);
                radioButton5.setChecked(true);
                break;

        }
    }

    //ViewPager当前页面改变---》通知RadioButton字体的颜色
    class onPageChange implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            switch (position) {
                case 0:
                    radioButton1.setChecked(true);
                    break;
                case 1:
                    radioButton2.setChecked(true);
                    break;
                case 2:
                    radioButton3.setChecked(true);
                    break;
                case 3:
                    // radioButton4.setChecked(true);
                    //    break;
                case 4:
                    radioButton5.setChecked(true);
                    break;

            }
            viewPager.setCurrentItem(position);

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

    private long timeMillis;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - timeMillis) > 2000) {
                ToastUtils.showMessage(this, "再按一次退出动量智码");
                timeMillis = System.currentTimeMillis();
            } else {
                finish();
            }
            return true;
        }
        return false;
    }
}
