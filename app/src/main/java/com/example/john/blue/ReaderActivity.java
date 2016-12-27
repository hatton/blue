package com.example.john.blue;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReaderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reader);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        loadBook(intent.getStringExtra("PATH"));
    }

    private void loadBook(String path) {
        File file = new File(path);
        WebView browser =  (WebView) findViewById(R.id.browser);
        browser.getSettings().setJavaScriptEnabled(true);
        if(file.isDirectory()) {
            browser.loadUrl("file:///" + file.getAbsolutePath() + "/" + file.getName() + ".htm");
        } else { // just a dummy file thing
            browser.loadUrl("file:///" + file.getAbsolutePath());
        }
    }
}
