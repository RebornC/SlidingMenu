package com.example.yc.slidingmenu;

/**
 * Created by yc on 2018/11/26.
 */

public class MenuItem {
    private String item_text_zh;
    private String item_text_en;

    public MenuItem(String item_text_zh, String item_text_en) {
        this.item_text_zh = item_text_zh;
        this.item_text_en = item_text_en;
    }

    public String getItem_text_zh() {
        return item_text_zh;
    }

    public void setItem_text_zh(String item_text_zh) {
        this.item_text_zh = item_text_zh;
    }

    public String getItem_text_en() {
        return item_text_en;
    }

    public void setItem_text_en(String item_text_en) {
        this.item_text_en = item_text_en;
    }
}
