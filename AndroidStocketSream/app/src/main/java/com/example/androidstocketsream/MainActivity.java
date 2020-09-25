package com.example.androidstocketsream;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "AndroidCameraApi";
    private CameraHandler cameraHandler;
    private TextureView textureView;
    private SocketStream socketStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textureView = (TextureView) findViewById(R.id.texture);
        assert textureView != null;
        this.cameraHandler = new CameraHandler(this, getApplicationContext(), textureView);

        //this.socketStream = new SocketStream();
        //this.socketStream.attemptSend("test121321");

        textureView.setSurfaceTextureListener(new CustomSurfaceListener(this.cameraHandler));
    }
}