package com.example.androidstocketsream;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private CameraHandler cameraHandler;
    private TextureView textureView;
    private Button startBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textureView = findViewById(R.id.texture);
        assert textureView != null;
        this.startBtn = findViewById(R.id.btn_start);

        // set the camera preview state
        this.cameraHandler = new CameraHandler(this, getApplicationContext(), textureView);
        textureView.setSurfaceTextureListener(new CustomSurfaceListener(cameraHandler, textureView));

        // stop/start the client to server bytes transfer
        this.startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StateSingleton.getInstance().runScanning = !StateSingleton.getInstance().runScanning;
                startBtn.setText(startBtn.getText().equals("Start") ? "Stop" : "Start");
            }
        });

    }

}