package com.xcy.freelayoutdemo.model;

import java.util.List;

/**
 * Created by xu on 17/1/16.
 * View 信息 bean 类
 */

public class ViewInfo {
    private int widthSum;
    private int heightSum;
    private List<ChildViewInfo> mChildViewInfoList;

    public ViewInfo(int widthSum, int heightSum, List<ChildViewInfo> childViewInfoList) {
        this.widthSum = widthSum;
        this.heightSum = heightSum;
        mChildViewInfoList = childViewInfoList;
    }

    public int getWidthSum() {
        return widthSum;
    }

    public void setWidthSum(int widthSum) {
        this.widthSum = widthSum;
    }

    public int getHeightSum() {
        return heightSum;
    }

    public void setHeightSum(int heightSum) {
        this.heightSum = heightSum;
    }

    public List<ChildViewInfo> getChildViewInfoList() {
        return mChildViewInfoList;
    }

    public void setChildViewInfoList(List<ChildViewInfo> childViewInfoList) {
        mChildViewInfoList = childViewInfoList;
    }
}
