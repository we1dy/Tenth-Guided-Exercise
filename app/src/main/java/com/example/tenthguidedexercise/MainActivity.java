package com.example.tenthguidedexercise;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    WebView browser;
    AutoCompleteTextView suggestedURL;
    ArrayAdapter adapter;
    Button submit;
    String [] urls = {"google.com","yahoo.com","facebook.com","youtube.com"};
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        browser = findViewById(R.id.webView);
        suggestedURL = findViewById(R.id.actvURLGE10);
        submit = findViewById(R.id.btnOpenURLGE10);
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,urls);
        suggestedURL.setThreshold(2);
        suggestedURL.setAdapter(adapter);
        initializeWebView();
        loadWebURL();
    }
    public void initializeWebView(){
        browser.getSettings().setLoadsImagesAutomatically(true);
        // enabled java script
        browser.getSettings().setJavaScriptEnabled(true);
        // Android webview launches browser when calling loadurl
        browser.setWebViewClient(new WebViewClient());
        // enabled Scrollbar
        browser.setScrollBarStyle(browser.SCROLLBARS_INSIDE_OVERLAY);
    }
    public void loadWebURL(){
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = suggestedURL.getText().toString();
                if(!url.startsWith("www.") && !url.startsWith("http://") ){
                    url = "www." + url;
                }
                if(!url.startsWith("http://") ){
                    url = "http://" + url;
                }
                browser.loadUrl(url);
            }
        });
    }
}