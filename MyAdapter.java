package com.example.law.daynotes;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.bmob.v3.BmobQuery;

public class MyAdapter extends BaseAdapter {

    private Context context;//传接上下文的context
    private Diary diary;//数据库中查询出来的对象
    private LinearLayout layout;

    public MyAdapter(Context context, Diary diary) {
        this.context = context;
        this.diary = diary;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //加载视图权限
        LayoutInflater inflater = LayoutInflater.from(context);
        //第一个参数是适配每一个textview的layout对象
        layout = (LinearLayout) inflater.inflate(R.layout.cell, null);
        //获取cell的每一个内容
        TextView contenttv = layout.findViewById(R.id.list_content);
        TextView timetv = layout.findViewById(R.id.list_time);

        String content =


        return layout;
    }
}
