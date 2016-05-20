package vip.vip;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import fragment.FiveFragment;
import fragment.FourFragment;
import fragment.OneFragment;
import fragment.ThreeFragment;
import fragment.TowFragment;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private String[] title;
    private ViewPager viewPager;
    private List<Fragment> fragmentList;
    private DrawerLayout drawerLayout =null;
    private ListView listView;
    private List<String> listName;
    private List<Integer> imagList;
    private ImageView iView_zuoshang;
    private RelativeLayout relativeLayout;

    class MyPagerAdapter extends FragmentPagerAdapter{

        private List<Fragment> myFragmentList;
        private String[] title;
        public MyPagerAdapter(FragmentManager fm,List<Fragment> myFragmentList,String[] title) {
            super(fm);
            this .title = title;
            this.myFragmentList = myFragmentList;

        }

        @Override
        public Fragment getItem(int position) {
            return myFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return myFragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), fragmentList, title));
        tabLayout.setupWithViewPager(viewPager);
        listView.setAdapter(new ListViewAdapter(this, listName));
        iView_zuoshang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });
        drawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                //响应抽屉开关
            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,UserActivity.class);
                startActivity(intent);
            }
        });





    }

    private void init() {
        relativeLayout = (RelativeLayout) findViewById(R.id.relayout);
        iView_zuoshang = (ImageView) findViewById(R.id.imageView_zuoshang);
        tabLayout = (TabLayout) findViewById(R.id.view2);
        viewPager = (ViewPager) findViewById(R.id.view3);
        listView = (ListView) findViewById(R.id.listView);
        drawerLayout =
                (DrawerLayout) findViewById(R.id.id_drawerlayout);
        title = new String[]{"今日上新", "唯品国际", "母婴", "居家", "最后疯抢", "即将上线"};
        for (int i = 0; i < title.length; i++) {
            tabLayout.addTab(tabLayout.newTab().setText(title[i]));
        }
        tabLayout.setTabTextColors(Color.WHITE, Color.WHITE);
        fragmentList = new ArrayList<>();
        fragmentList.add(new OneFragment());
        fragmentList.add(new TowFragment());
        fragmentList.add(new ThreeFragment());
        fragmentList.add(new FourFragment());
        fragmentList.add(new FiveFragment());
        fragmentList.add(new SixFragment());

        listName = new ArrayList<>();
        listName.add("首页");
        listName.add("服饰");
        listName.add("男士");
        listName.add("母婴");
        listName.add("美妆");
        listName.add("居家");
        listName.add("手表配饰");
        listName.add("唯风尚");
        listName.add("唯品国际");
        listName.add("爱丽奢");
        listName.add("唯品金融");
        listName.add("汽车");
        listName.add("旅游");
    }
}
