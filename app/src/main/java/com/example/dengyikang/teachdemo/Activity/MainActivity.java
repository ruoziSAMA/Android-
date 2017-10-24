package com.example.dengyikang.teachdemo.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.dengyikang.teachdemo.Adapter.Adapter;
import com.example.dengyikang.teachdemo.R;

import java.util.ArrayList;
import java.util.List;

//recyclerView
public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<String> dateList = new ArrayList<>();
    private Adapter adapter;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取控件
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        //加载headerview
        view = LayoutInflater.from(this).inflate(R.layout.head_item, null);
        //初始化dateList的数据
        initData();
        //构造Adapter， 并在Activity通过接口实现监听事件
        adapter = new Adapter(dateList, new Adapter.OnClick() {
            @Override
            public void listener(int position, View v) {
                TextView textView = (TextView) v;
                textView.setText(textView.getText() + "!");
            }
        });
        //添加headerview
        adapter.addHeaderView(view);
        //设置Adapter
        recyclerView.setAdapter(adapter);
        //设置布局
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
    }



    private void initData() {
        for(int i = 0; i  < 15; i++){
            dateList.add(Integer.toString(i));
        }
    }
}
