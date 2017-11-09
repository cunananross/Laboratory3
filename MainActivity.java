package com.cunanan.labactivity1109207;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    Button btnShare, btnInternalStore, btnInternalCache, btnNext, btnExternalCache, btnExternalStorage, btnExternalPublic;
    EditText etData, etFilename;
    TextView tvDisplay;
    FileInputStream fis;
    FileOutputStream fos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etData = (EditText) findViewById(R.id.et_Data);
        etFilename = (EditText) findViewById(R.id.et_Filename);
        btnShare = (Button) findViewById(R.id.SharedPreferences);
        btnInternalStore = (Button) findViewById(R.id.InternalStorage);
        btnInternalCache = (Button) findViewById(R.id.InternalCache);
        btnExternalCache = (Button) findViewById(R.id.ExternalCache);
        btnExternalStorage = (Button) findViewById(R.id.ExternalStorage);
        btnExternalPublic = (Button) findViewById(R.id.ExternalPublicStorage);
        btnNext = (Button)  findViewById(R.id.Next);
    }
    public void goNext (View view){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
    public void Share(View view){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("filename",etFilename.getText().toString());
        editor.putString("data",etData.getText().toString());
        editor.apply();
        Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show();

    }
}
