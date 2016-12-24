package com.example.john.blue;

import android.content.Context;
import android.content.ContextWrapper;
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
        loadBook();
    }

    private void loadBook() {
        ContextWrapper cw = new ContextWrapper(this.getApplicationContext());
        File directory = cw.getDir("bloomreader", Context.MODE_PRIVATE);

        //TODO: get this from the Book in the Bundle that was given to this activity
        File file = new File(directory, "one.htm");

        WebView browser =  (WebView) findViewById(R.id.browser);
        browser.getSettings().setJavaScriptEnabled(true);
        browser.loadUrl("file:///" + file.getAbsolutePath());
        //browser.loadDataWithBaseURL(null, html, "text/html", "utf-8", null);
    }
}
