package com.example.law.daynotes;

import cn.bmob.v3.BmobObject;

public class Diary extends BmobObject{

    private String title;//日记标题
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
