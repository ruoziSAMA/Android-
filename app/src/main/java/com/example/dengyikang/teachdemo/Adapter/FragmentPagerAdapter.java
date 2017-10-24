package com.example.dengyikang.teachdemo.Adapter;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.widget.TableLayout;

import java.util.ArrayList;
import java.util.List;


//滑动翻页的适配器
public class FragmentPagerAdapter extends android.support.v4.app.FragmentPagerAdapter {

    //标签的标题
    private String[] titles = {"标题1", "标题2"};
    //存fragment
    private List<Fragment> frag_list = new ArrayList<>();
    //滑动页面控件
    private ViewPager mViewPager;
    //页面上方的标签
    private TabLayout mTabLayout;


    //构造方法
    public FragmentPagerAdapter(FragmentManager fm, ViewPager viewPager, TabLayout tabLayout) {
        super(fm);
        mViewPager = viewPager;
        mTabLayout = tabLayout;
        //初始化
        setupTab();
    }

    //初始化
    private void setupTab() {
        //配置之前先保证tab是空的
        mTabLayout.removeAllTabs();
        //tab与viewpager联动
        mTabLayout.setupWithViewPager(mViewPager);
        //触摸点在页面上，滑动时
        //设置滑动监听，即滑动viewpager时，tab一起跟着滑动
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        //设置adapter，this为本身，即FragmentPagerAdapter
        mViewPager.setAdapter(this);
        //触摸点在tab上，tab被选中时，viewpager也要跟着翻面
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            //tab被选中时
            public void onTabSelected(TabLayout.Tab tab) {
                //设置当前页面
                //position即页面的编号
                mViewPager.setCurrentItem(tab.getPosition());
            }

            //tab未被选中时
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            //tab处于复选时
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    //要求返回position对应的fragment
    @Override
    public Fragment getItem(int position) {
        return frag_list.get(position);
    }

    //Activity可以调用这来添加fragment
    public void addFragment(Fragment fragment){
        frag_list.add(fragment);
        setupTab();
    }
    //返回fragment的数量
    @Override
    public int getCount() {
        return frag_list.size();
    }

    //要求返回tab的标题
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
