package com.example.law.daynotes;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button textbtn;
    private ListView lv;
    private Intent i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bmob.initialize(this, "52b669111eda5b0df19bd2c740a6b56c");
        initView();
    }

    //初始化View
    public void initView(){
        lv = (ListView) findViewById(R.id.list);
        textbtn = (Button) findViewById(R.id.text);

        //注册事件
        textbtn.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        i = new Intent(this, addContent.class);
        switch(v.getId()){
            case R.id.text:
                i.putExtra("flag", "1");
                startActivity(i);
                break;
        }
    }
    //查询全部日记信息
    public void getData(){
        BmobQuery<Diary> query = new BmobQuery<Diary>();
        query.order("-createdAt");// 按照时间降序
        query.findObjects(new FindListener<Diary>() {
            @Override
            public void done(List<Diary> list, BmobException e) {
                if (e != null) {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }else {

                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        getData();
    }
}
