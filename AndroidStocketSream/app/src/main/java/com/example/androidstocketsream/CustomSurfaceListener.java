package com.example.androidstocketsream;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CameraMetadata;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Handler;
import android.util.Log;
import android.util.Size;
import android.view.Surface;
import android.view.TextureView;
import android.widget.Toast;

import java.util.Arrays;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;

public class CustomSurfaceListener implements TextureView.SurfaceTextureListener {
    private static final String TAG = "AndroidCameraApi";
    protected CameraHandler cameraHandler;
    protected SocketStream socketStream;


    public CustomSurfaceListener(CameraHandler cameraHandler) {
        this.cameraHandler = cameraHandler;
        this.socketStream = new SocketStream();
        this.socketStream.attemptSend("test121321");
        Log.e(TAG, "yooo");
    }

    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i1) {
       this.cameraHandler.openCamera();

    }

    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i1) {

    }

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        Log.d(TAG, "New frame");
    }
}
