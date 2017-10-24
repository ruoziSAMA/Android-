package com.example.dengyikang.teachdemo.Activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.dengyikang.teachdemo.Adapter.FragmentPagerAdapter;
import com.example.dengyikang.teachdemo.Fragment.BlankFragment;
import com.example.dengyikang.teachdemo.Fragment.BlankFragment_2;
import com.example.dengyikang.teachdemo.R;

//滑动翻页
public class SecondActivity extends AppCompatActivity {


    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FragmentManager manager;
    private FragmentPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tabLayout = (TabLayout) findViewById(R.id.tab);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        manager = getSupportFragmentManager();
        BlankFragment fragment_1 = new BlankFragment();
        BlankFragment_2 fragment_2 = new BlankFragment_2();
        //构造FragmentPagerAdapter
        adapter = new FragmentPagerAdapter(manager, viewPager, tabLayout);
        adapter.addFragment(fragment_1);
        adapter.addFragment(fragment_2);
    }

}
