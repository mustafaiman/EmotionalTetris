import socket
def read_line(sock):
    "read a line from a socket"
    chars = []
    while True:
        a = sock.recv(1)
        chars.append(a)     
        if a == "\n" or a == "":
            return "".join(chars)


s = socket.socket()
s.bind(('127.0.0.1',9998))
s.listen(0)
c, addr = s.accept()
print 'got connection', addr

while True:
    msg = read_line(c)
    c.send(msg)
    print msg
c.close()
s.close()
