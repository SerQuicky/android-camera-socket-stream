package com.example.androidstocketsream;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.view.TextureView;

public class CustomSurfaceListener implements TextureView.SurfaceTextureListener {

    protected CameraHandler cameraHandler;
    protected SocketStream socketStream;
    protected TextureView textureView;
    protected boolean wait = false;
    protected int interval = 1000;

    public CustomSurfaceListener(CameraHandler cameraHandler, TextureView textureView) {
        this.cameraHandler = cameraHandler;
        this.textureView = textureView;
        this.socketStream = new SocketStream();
    }

    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i1) {
        this.cameraHandler.openCamera();
    }

    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i1) { }

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        // check if the bytes should be transfered
        if(!StateSingleton.getInstance().waitInterval && StateSingleton.getInstance().runScanning) {
            StateSingleton.getInstance().waitInterval = true;

            Thread socketThread = new Thread(new SocketThread(this.textureView, this.socketStream));
            socketThread.start();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    StateSingleton.getInstance().waitInterval = false;
                }
            }, interval);
        }
    }
}
