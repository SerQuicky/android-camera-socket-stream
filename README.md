# android-camera-socket-stream
An example application of a video socket connection between an android device and a REST-Service with socket.io.

<p align="center"> 
<img src="https://github.com/SerQuicky/android-camera-socket-stream/blob/master/resources/screenshot_new.png">
</p>

## How does it work?

This project uses:

* android application with the ``android.hardware.camera2`` library to get each frame that the camera captures
* ``flask`` for the frame transfer endpoint
* ``socket.io`` for the socket communication between the android app and the flask service


## How to start?

1. Install ``flask pip packages`` through ``pip install flask`` and ``pip install flask_socketio``
2. Start the flask service with ``python websocket.py``. The server runs on port ``5000``.
3. Update the socket url in the android class ``SocketStream.java`` to communicate with your flask Service for example ``private String url = "http://192.168.1.1:5000";``
4. Start the android application on an emulator or a real device, keep in mind that the device needs to be in the same network as your flask server! Press the "Start"-Button and your terminal should look like this.

![terminal](https://github.com/SerQuicky/android-camera-socket-stream/blob/master/resources/terminal.png)


