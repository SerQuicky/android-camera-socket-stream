from flask import Flask 
from flask_socketio import SocketIO, send

app = Flask(__name__)
app.config['SECRET_KEY'] = 'mysecret'
socketio = SocketIO(app, cors_allowed_origins='*')

@socketio.on('transfer')
def handleImage(msg):
	print('Message: ' + msg)

if __name__ == '__main__':
	socketio.run(app, host='0.0.0.0', port=5000)