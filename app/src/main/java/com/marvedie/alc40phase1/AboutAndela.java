package com.marvedie.alc40phase1;

import android.content.Intent;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AboutAndela extends AppCompatActivity {

    WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_andela);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Navigation Back Button
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(AboutAndela.this, MainActivity.class));
            }
        });
        //Load Andela webview with JavaScript enabled

       myWebView = findViewById(R.id.webview);
       WebSettings webSettings = myWebView.getSettings();
       webSettings.setJavaScriptEnabled(true);
       webSettings.setUseWideViewPort(true);
       webSettings.setLoadWithOverviewMode(true);

        myWebView.loadUrl("https://andela.com/alc/");

        myWebView.setWebViewClient( new WebViewClient(){

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
            }
        });
    }

}
