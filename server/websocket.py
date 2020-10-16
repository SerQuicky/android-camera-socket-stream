from flask import Flask 
from flask_socketio import SocketIO
from engineio.payload import Payload
import base64

app = Flask(__name__)
app.config['SECRET_KEY'] = 'mysecret'
Payload.max_decode_packets = 500
socketio = SocketIO(app, cors_allowed_origins='*')

@socketio.on('transfer')
def handleImage(msg):
	print(type(msg))


if __name__ == '__main__':
	socketio.run(app, host='0.0.0.0', port=5000)