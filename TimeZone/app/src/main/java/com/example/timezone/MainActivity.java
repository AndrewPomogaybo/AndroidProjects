package com.example.timezone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;

import java.util.function.Consumer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.POST_NOTIFICATIONS}, PackageManager.PERMISSION_GRANTED);
            return;
        }


    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permission, int[] grand) {
        super.onRequestPermissionsResult(requestCode, permission, grand);
        if (grand.length > 0) {
            IntentFilter filter = new IntentFilter(Intent.ACTION_TIMEZONE_CHANGED);
            registerReceiver(new timeZone(), filter);
        }
    }
    }