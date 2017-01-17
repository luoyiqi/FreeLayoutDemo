package com.xcy.freelayoutdemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.xcy.freelayoutdemo.R;
import com.xcy.freelayoutdemo.custom.FreeLayout;
import com.xcy.freelayoutdemo.manager.LayoutManager;
import com.xcy.freelayoutdemo.model.ChildViewInfo;
import com.xcy.freelayoutdemo.model.ViewInfo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Integer> mIntegers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<ChildViewInfo> viewInfoList = new ArrayList<>();
        viewInfoList.add(new ChildViewInfo(0, 0, 8, 3, "Video"));
        viewInfoList.add(new ChildViewInfo(8, 0, 2, 1, "Image"));
        viewInfoList.add(new ChildViewInfo(8, 1, 2, 1, "Video"));
        viewInfoList.add(new ChildViewInfo(8, 2, 2, 1, "Image"));

        final ViewInfo staticViewInfo = new ViewInfo(10, 3, viewInfoList);

        LayoutManager.getInstance().load(this, staticViewInfo);

        mIntegers.add(getResources().getColor(R.color.colorAccent));
        mIntegers.add(getResources().getColor(R.color.colorPrimary));
        mIntegers.add(getResources().getColor(R.color.colorPrimaryDark));
        mIntegers.add(getResources().getColor(R.color.colorAccent));

        FreeLayout freeLayout = (FreeLayout) findViewById(R.id.activity_main_free_layout);
        for (int i = 0; i < freeLayout.getChildCount(); i++) {
            View view = freeLayout.getChildAt(i);
            view.setBackgroundColor(mIntegers.get(i));
        }
    }
}
