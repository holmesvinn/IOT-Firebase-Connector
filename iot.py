import urllib.request
response = urllib.request.urlopen("https://testing-48a3a.firebaseio.com/message.json")
prevmessage = response.read()
print(prevmessage)

while(1):
    response = urllib.request.urlopen("https://testing-48a3a.firebaseio.com/message.json")
    message = response.read()
    if (message != prevmessage):
        prevmessage = message
        print(message)


