import cv2
import numpy as np
#cv2 is OpenCV

cap = cv2.VideoCapture(0)
while True:
    _, frame = cap.read()
    hsv = cv2.cvtColor(frame, cv2.COLOR_BGR2HSV)

    lower_yel = np.array([20,100,100])
    upper_yel = np.array([30,255,255])
    #Mask filters for yellow without adding color to the view
    mask = cv2.inRange(hsv, lower_yel, upper_yel)
    res = cv2.bitwise_and(frame,frame, mask= mask)
    #Res is adding defualt yellow to filtered objects
#    edges = cv2.Canny(res,100,200)
    #Edges maybe for the future when we wanna auto score
    median = cv2.medianBlur(res,15)
    #Medianblur on the mask is the most smooth transform

    #Contour Center Detection

 #   cnt, hierarchy = cv2.findContours(mask, cv2.RETR_TREE,cv2.CHAIN_APPROX_SIMPLE)
  #  sortedcontours = sorted(cnt, key = cv2.contourArea, reverse = True)
   # mediancop = res.copy()
    #cv2.drawContours(mediancop,cnt,-1,(0,0,255), 3)
    #for(i,cnt) in enumerate(sortedcontours):
    #    (x,y),radius = cv2.minEnclosingCircle(cnt)

    cnt, hierarchy = cv2.findContours(mask, cv2.RETR_TREE,cv2.CHAIN_APPROX_SIMPLE)
    sortedcontours = sorted(cnt, key = cv2.contourArea, reverse = True)
    mediancop = median.copy()
    cv2.drawContours(mediancop,cnt,-1,(0,0,255), 3)
    for(i,cnt) in enumerate(sortedcontours):
        (x,y),radius = cv2.minEnclosingCircle(cnt)
    mediancopcop = cv2.medianBlur(mediancop,15)
    cv2.imshow('median blur copy copy', mediancopcop)
    cv2.imshow('Median Blur',median)
#    cv2.imshow('Video', frame)
#    cv2.imshow('edges',edges)
#    cv2.imshow('mask', mask)
#    cv2.imshow('res', res)
    cv2.imshow('mediancopy', mediancop)

    k = cv2.waitKey(5) & 0xFF
    if k == 27:
        break

cv2.destroyAllWindows()
cap.release()