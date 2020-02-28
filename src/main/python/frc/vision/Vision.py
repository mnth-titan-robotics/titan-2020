import cv2
import numpy as np
from networktables import NetworkTable
from networktables import NetworkTableEntry
from networktables import NetworkTablesInstance
import threading
#from time import sleep
cond = threading.Condition()
notified = [False]

def connectionListener(connected,info):
    print(info, '; Connected=%s' % connected)
    with cond:
        notified[0] = True
        cond.notify()
NetworkTablesInstance.initialize(, server="10.27.89.2")
NetworkTablesInstance.addConnectionListener(connectionListener, immediateNotify=True)
with cond:
    print("Waiting")
    if not notified[0]:
        cond.wait()
#sleep(0.1)
table = NetworkTablesInstance.getTable("VisionTable")
#NetworkTablesInstance.startServer()

xEntry = table.getEntry("cx")

#cv2 is OpenCV
#When calling cv2 on the PI be sure to use python3 instead of pythen when launching
cap = cv2.VideoCapture(0)
while True:
    _, frame = cap.read()
    hsv = cv2.cvtColor(frame, cv2.COLOR_BGR2HSV)
    hsl = cv2.cvtColor(frame, cv2.COLOR_BGR2HLS)
    #BGR Values V V V
    lower_yel = np.array([20,0,100])
    upper_yel = np.array([30,150,255])
    #Mask filters for yellow without adding color to the view
    mask = cv2.inRange(hsl, lower_yel, upper_yel)   
    res = cv2.bitwise_and(frame,frame, mask= mask)
    #Res is adding defualt yellow to filtered objects
    median = cv2.medianBlur(res,15)
    #Medianblur on the mask is the most smooth transform

    #Contour Center Detection

    cnt, hierarchy = cv2.findContours(mask, cv2.RETR_TREE,cv2.CHAIN_APPROX_SIMPLE)
    cnt = sorted(cnt, key = cv2.contourArea, reverse = True)
    mediancop = median.copy()
    cv2.drawContours(mediancop,cnt,-1,(0,0,255), 2)

    mediancopcop = cv2.medianBlur(mediancop,15)
    copyCnt= cnt
    if len(copyCnt) == 0:
        print("No Contours")
    else:
        c_0 = copyCnt[0]
        M = cv2.moments(c_0)
        if M["m00"] != 0:
            cx = int(M['m10'] / M['m00'])
            cy = int(M['m01'] / M['m00'])
            Ballx = cx
            Bally = cy
            print(Ballx,Bally)
            cv2.circle(mediancopcop, (cx, cy), 5, (255,0,0), thickness=5, lineType=8, shift=0)
        else:
            cx, cy = 0,0
        xEntry.setDouble('cx', cx)
    cv2.imshow('Final', mediancopcop)
    k = cv2.waitKey(5) & 0xFF
    if k == 27:
        break
cv2.destroyAllWindows()
cap.release()
