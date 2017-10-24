package com.example.dengyikang.teachdemo.Adapter;

import android.content.Intent;
import android.media.Image;
import android.support.annotation.BoolRes;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dengyikang.teachdemo.Activity.SecondActivity;
import com.example.dengyikang.teachdemo.R;

import java.util.List;


public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    //设置header_view的编号
    private static final int BASE_ITEM_TYPE_HEADER = 100;

    //SparseArrayCompat与List不同之处是前者有key值（可以理解未你给他的编号,编号唯一）
    //你可以通过索引（ c 里数组下标 ）或者key值来获得对应的值
    private SparseArrayCompat<View> mHeaderView = new SparseArrayCompat<>();


    //接口，不懂得可以把监听事件直接写在onCreateViewHolder里
    //一般用于：Adapter与监听事件隔离开，监听事件可以放在任何你想要的地方写（这个例子是在Activity里写的）
    public OnClick onClick;

    //数据源
    private List<String> dateList;

    //构造方法
    public Adapter(List<String> list, OnClick onClick){
        dateList = list;
        //接口
        this.onClick = onClick;
    }

    //添加头部view
    public void addHeaderView(View view){
        mHeaderView.put(mHeaderView.size() + BASE_ITEM_TYPE_HEADER, view);
    }

    //判断是否为头部view
    public Boolean isHeaderViewPos(int positon){
        return positon < mHeaderView.size();
    }

    //加载布局
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        //判断加载的item是否为头部view
        if(mHeaderView.get(viewType) != null)
        {
            //不明白的Ctrl + 左键 看源码的注释
            //传入key值返回对应的值（view），这里viewType和key值是相对应的
            View view  = mHeaderView.get(viewType);
            HeaderViewHolder viewHolder = new HeaderViewHolder(view);
            viewHolder.btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(parent.getContext(), SecondActivity.class);
                    parent.getContext().startActivity(intent);
                }
            });
            return viewHolder;
        }
        else {
            //加载视图
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
            //构造viewholder
            final ViewHolder viewHolder = new ViewHolder(view);
            viewHolder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //点击事件
                    //若不懂接口可以直接写事件
                    onClick.listener(viewHolder.getAdapterPosition(), viewHolder.textView);
                }
            });
            return viewHolder;
        }
    }

    //绑定数据
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(isHeaderViewPos(position)){
            //绑定headerview的数据
            /*HeaderViewHolder viewHolder = (HeaderViewHolder) holder;*/
            //绑定数据
        }
        else {
            ViewHolder viewHolder = (ViewHolder) holder;
            viewHolder.textView.setText(dateList.get(position - mHeaderView.size()));
        }
    }

    //要求返回ViewType
    //ViewType可以你自己定，这里设置ViewType = key值
    @Override
    public int getItemViewType(int position) {
        if(isHeaderViewPos(position)){
            return mHeaderView.keyAt(position);
        }
        else return 0;
    }



    //返回子view以及数据的长度
    @Override
    public int getItemCount() {
        return mHeaderView.size() + dateList.size();
    }

    //textview的viewholder，这里与你写的布局文件是一一对应的
    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.recyc_text);
        }
    }

    //headerview的布局文件
    public class HeaderViewHolder extends  RecyclerView.ViewHolder{

        private Button btn;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            btn = itemView.findViewById(R.id.btn);
        }
    }

    //接口
    public interface OnClick{
        void listener(int position, View v);
    }
}
