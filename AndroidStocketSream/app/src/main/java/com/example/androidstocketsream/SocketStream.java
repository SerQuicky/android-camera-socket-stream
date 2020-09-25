package com.example.androidstocketsream;
import android.util.Log;

import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import java.net.URISyntaxException;

public class SocketStream {

    private static final String TAG = "AndroidCameraApi";
    private Socket mSocket;

    SocketStream() {
        try {
            mSocket = IO.socket("http://192.168.2.103:5000");
            mSocket.connect();
        } catch (Exception e) {
            Log.e(TAG, "FEHLLLLER");
        }
    }

    public void attemptSend(String text) {
        try {
            mSocket.emit("transfer", text);
        } catch (Exception e) {
            Log.e(TAG, "FEHLLLLER");
        }
    }

}
