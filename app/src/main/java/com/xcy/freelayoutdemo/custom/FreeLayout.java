package com.xcy.freelayoutdemo.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.xcy.freelayoutdemo.model.ChildViewInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xu on 17/1/15.
 * 自定义 ViewGroup ，重写 onLayout() 方法
 */

public class FreeLayout extends ViewGroup {

    private static final String TAG = "FreeLayout";

    public List<ChildViewInfo> mChildChildViewInfo = new ArrayList<>();
    public int[] rootViewSizeInfo = new int[2];

    public FreeLayout(Context context) {
        super(context);
    }

    public FreeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FreeLayout(Context context, List<ChildViewInfo> childChildViewInfo, int[] rootViewSizeInfo) {
        super(context);
        this.mChildChildViewInfo = childChildViewInfo;
        this.rootViewSizeInfo = rootViewSizeInfo;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measureChildren(widthMeasureSpec, heightMeasureSpec);
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        final int count = getChildCount();

        if (changed) {
            for (int i = 0; i < count; i++) {
                final View childView = getChildAt(i);
                int width = childView.getMeasuredWidth();
                int height = childView.getMeasuredHeight();

                int cl = (int) ((float) mChildChildViewInfo.get(i).getLeft() / rootViewSizeInfo[0] * getMeasuredWidth());
                int ct = (int) ((float) mChildChildViewInfo.get(i).getTop() / rootViewSizeInfo[1] * getMeasuredHeight());

                childView.layout(cl, ct, cl + width, ct + height);
            }
        }
    }
}