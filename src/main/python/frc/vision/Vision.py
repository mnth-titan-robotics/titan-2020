import cv2
import numpy as np
import logging
import networktables

#cv2 is OpenCV
cap = cv2.VideoCapture(0)
while True:
    _, frame = cap.read()
    hsv = cv2.cvtColor(frame, cv2.COLOR_BGR2HSV)
    hsl = cv2.cvtColor(frame, cv2.COLOR_BGR2HLS)
    cv2.imshow('HSL', hsl)
    #BGR Values V V V
    lower_yel = np.array([20,0,100])
    upper_yel = np.array([30,150,255])
    #Mask filters for yellow without adding color to the view
    mask = cv2.inRange(hsl, lower_yel, upper_yel)   
    res = cv2.bitwise_and(frame,frame, mask= mask)
    #Res is adding defualt yellow to filtered objects
    #   edges = cv2.Canny(res,100,200)
    #Edges maybe for the future when we wanna auto score
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
    #pynetworktables. (INSERT NETWORK TABLES CODE HERE)
    networktables.initialize(server='10.xx.xx.2')
    networktables.addConnectionListener(connectionListener, immediateNotify=True)
    
    cv2.imshow('median blur Final', mediancopcop)
    cv2.imshow('Median Blur',median)
    cv2.imshow('Video', frame)

    cv2.imshow('median copy', mediancop)

    k = cv2.waitKey(5) & 0xFF
    if k == 27:
        break
cv2.destroyAllWindows()
cap.release()
