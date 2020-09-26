package com.example.androidstocketsream;
import android.util.Log;

import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

public class SocketStream {

    private Socket mSocket;
    private String url = "http://192.168.2.103:5000";

    SocketStream() {
        try {
            mSocket = IO.socket(url);
            mSocket.connect();
        } catch (Exception e) {
            Log.e(StateSingleton.getInstance().TAG, "SocketStream runs on an error while connection to the socket!");
        }
    }

    public void attemptSend(byte[] message) {
        try {
            mSocket.emit("transfer", message);
        } catch (Exception e) {
            Log.e(StateSingleton.getInstance().TAG, "SocketStream runs on an error while sending the bytes to the socket server!");
        }
    }

    // @TODO: Remove it later (was for the base64 testing)
    public void attemptSend2(String message) {
        try {
            mSocket.emit("transfer", message);
        } catch (Exception e) {
            Log.e(StateSingleton.getInstance().TAG, "SocketStream runs on an error while sending the bytes to the socket server!");
        }
    }

}
