package com.xcy.freelayoutdemo.manager;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.xcy.freelayoutdemo.R;
import com.xcy.freelayoutdemo.custom.FreeLayout;
import com.xcy.freelayoutdemo.model.ChildViewInfo;
import com.xcy.freelayoutdemo.model.ViewInfo;
import com.xcy.freelayoutdemo.util.ScreenUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by xu on 17/1/16.
 * 布局管理器
 */

public class LayoutManager {
    private static final String TAG = "LayoutManager";
    private static LayoutManager sLayoutManager;
    private ViewFactory mViewFactory;

    public static LayoutManager getInstance() {
        if (sLayoutManager == null) {
            sLayoutManager = new LayoutManager();
        }
        return sLayoutManager;
    }

    /**
     * 加载布局
     * @param activity 目标 activity
     * @param viewInfo viewInfo
     */
    public void load(Activity activity, ViewInfo viewInfo) {
        mViewFactory =new ViewFactory(activity);

        //父 View 宽、高上每一份的值
        int width = ScreenUtil.getScreenWidth(activity) / viewInfo.getWidthSum();
        int height = ScreenUtil.getScreenHeight(activity) / viewInfo.getHeightSum();

        FreeLayout freeLayout = (FreeLayout) activity.findViewById(R.id.activity_main_free_layout);
        freeLayout.rootViewSizeInfo = new int[]{viewInfo.getWidthSum(), viewInfo.getHeightSum()};
        List<ChildViewInfo> childViewInfoList = viewInfo.getChildViewInfoList();
        freeLayout.mChildChildViewInfo = childViewInfoList;

        for (int i = 0; i < childViewInfoList.size(); i++) {
            ChildViewInfo childViewInfo = childViewInfoList.get(i);
            AdLayoutCell adLayoutCell = new AdLayoutCell(activity);
            if (!adLayoutCell.isFree()) {
                adLayoutCell.removeAllViews();
            }
            adLayoutCell.bindView(childViewInfo.getType());
            adLayoutCell.setLayoutParams(new LinearLayout.LayoutParams(childViewInfo.getWidth() * width, childViewInfo.getHeight() * height));
            adLayoutCell.setBackgroundColor(activity.getResources().getColor(R.color.colorAccent));
            freeLayout.addView(adLayoutCell);
        }
    }

    /**
     * 根据解析 json 所得的 viewType 值，通过反射生成相应的子 View
     */
    private class AdLayoutCell extends LinearLayout{
        private View view;

        public AdLayoutCell(Context context){
            super(context);
        }

        public void bindView (String type) {
            try {
                view = (View) mViewFactory.getClass().getMethod("create" + type + "View").invoke(mViewFactory);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            this.addView(view);
        }

        public boolean isFree() {
            return this.getChildCount() == 0;
        }
    }
}
