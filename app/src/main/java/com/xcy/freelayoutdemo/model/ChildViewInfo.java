package com.xcy.freelayoutdemo.model;

/**
 * Created by xu on 17/1/16.
 * 以下参数均为所占父 View 的份数（父 View 的宽和高会依据传来的 json 值进行等分）
 */

public class ChildViewInfo {
    private int mLeft;//子 View 的左侧起点坐标值
    private int mTop;//子 View 的上方起点坐标值
    private int mWidth;//子 View 的宽度
    private int mHeight;//子 View 的高度
    private String mType;//子 View 的视图类型

    public ChildViewInfo(int left, int top, int width, int height, String type) {
        mLeft = left;
        mTop = top;
        mWidth = width;
        mHeight = height;
        mType = type;
    }

    public int getLeft() {
        return mLeft;
    }

    public void setLeft(int left) {
        mLeft = left;
    }

    public int getTop() {
        return mTop;
    }

    public void setTop(int top) {
        mTop = top;
    }

    public int getWidth() {
        return mWidth;
    }

    public void setWidth(int width) {
        mWidth = width;
    }

    public int getHeight() {
        return mHeight;
    }

    public void setHeight(int height) {
        mHeight = height;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }
}
