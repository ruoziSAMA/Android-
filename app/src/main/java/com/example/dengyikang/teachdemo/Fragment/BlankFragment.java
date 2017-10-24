package com.example.dengyikang.teachdemo.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dengyikang.teachdemo.R;


public class BlankFragment extends Fragment {

    public BlankFragment() {
        // Required empty public constructor
        //构造方法
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //数据初始化
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //加载布局，获取控件（findviewbyid等等）
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

}
