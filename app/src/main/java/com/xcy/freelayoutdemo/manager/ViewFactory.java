package com.xcy.freelayoutdemo.manager;

import android.app.Activity;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.VideoView;

/**
 * Created by xu on 17/1/10.
 * ViewFactory
 */

public class ViewFactory {
    private Activity activity;

    public ViewFactory(Activity activity) {
        this.activity = activity;
    }

    public VideoView createVideoView(){
        VideoView videoView = new VideoView(activity);
        return videoView;
    }

    public ImageView createImageView() {
        ImageView imageView = new ImageView(activity);
        return imageView;
    }

    public WebView createWebView() {
        WebView webView = new WebView(activity);
        return webView;
    }
}