package com.sheshu.wechat.menu;

/**
 * 董帮辉 2017-3-11
 * 公共按钮属性
 */
public class Button {

    private String name;

    private String type;

    private Button[] sub_button;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Button[] getSub_button() {
        return sub_button;
    }

    public void setSub_button(Button[] sub_button) {
        this.sub_button = sub_button;
    }
}
