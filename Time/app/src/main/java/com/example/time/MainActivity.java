package com.example.time;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.POST_NOTIFICATIONS}, PackageManager.PERMISSION_GRANTED);
            return;
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permission, int[] grand) {
        super.onRequestPermissionsResult(requestCode, permission, grand);
        if (grand.length > 0) {
            IntentFilter filter = new IntentFilter(Intent.ACTION_TIME_CHANGED);
            registerReceiver(new time_changed(), filter);
        }
    }
}