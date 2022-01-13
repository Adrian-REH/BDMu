package com.helper.appmu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ViewTop extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_top);
        WebView webView = (WebView) findViewById(R.id.Webtop);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.loadUrl("http://top.tuservermu.com.ve");

        webView.setWebViewClient(new WebViewClient(){
            public boolean shouldOverrideUriLoading(WebView view, String uri){
                return false;
            }
        });














    }
}
