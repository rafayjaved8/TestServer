import socket

HOST = '127.0.0.1'
PORT = 13267
ADDR = (HOST,PORT)
BUFSIZE = 4096
videofile = "D:/Repositories/gitRep/TestServer/data/test-video.avi"

bytes = open(videofile).read()

print len(bytes)

client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
client.connect(ADDR)

client.send(bytes)

client.close()
