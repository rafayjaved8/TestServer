import socket               # Import socket module

soc = socket.socket(socket.AF_INET, socket.SOCK_STREAM)         # Create a socket object
host = "localhost" # Get local machine name
port = 2004                # Reserve a port for your service.
soc.bind((host, port))       # Bind to the port
soc.listen(1000)                 # Now wait for client connection.
while True:
    conn, addr = soc.accept()     # Establish connection with client.
    print ("Got connection from",addr)
    buf = ''
    while len(buf)<4:
        buf += client.recv(4-len(buf))
    size = struct.unpack('!i', buf)
    print "receiving %s bytes" % size

    with open('tst.png', 'wb') as img:
        while True:
            data = client.recv(1024)
            if not data:
                break
            img.write(data)
    print 'received, yay!'

    client.close()
