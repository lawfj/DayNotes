package com.example.law.daynotes;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class addContent extends Activity implements View.OnClickListener{

    private String val;
    private Button savebtn, cancelbtn;
    private EditText ettext;
    private Diary diary;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addcontent);
        val = getIntent().getStringExtra("flag");


        savebtn = (Button) findViewById(R.id.save);
        cancelbtn = (Button) findViewById(R.id.cancel);
        ettext = (EditText) findViewById(R.id.ettext);

        savebtn.setOnClickListener(this);
        cancelbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.save:
                saveContent();
                finish();//关闭当前activity
                break;
            case R.id.cancel:
                finish();//关闭当前activity
                break;
        }

    }

    public void saveContent(){
        diary = new Diary();
        diary.setTitle("日记本test");
        diary.setContent(ettext.getText().toString());
        diary.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if(e != null){
                    Toast.makeText(addContent.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(addContent.this, "success", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
