import socket
s = socket.socket()
host = socket.gethostname()
port = 9999
s.bind(('127.0.0.1',9998))
s.listen(0)
c, addr = s.accept()
print 'got connection', addr

while True:
    msg = raw_input('Message: ')
    if msg == 'exit':
        break
    if msg.startswith('d'):
        c.send('emotion DISGUST\n')
    elif msg.startswith('p'):
        c.send('emotion PEACEFUL\n')
    elif msg.startswith('f'):
        c.send('emotion FRUSTRATED\n')
    elif msg.startswith('j'):
        c.send('emotion JOY\n')
c.close()
s.close()
