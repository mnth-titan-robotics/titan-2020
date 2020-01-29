import cv2
import numpy as np
#cv2 is OpenCV

cap = cv2.VideoCapture(0)
while True:
    _, frame = cap.read()
    hsv = cv2.cvtColor(frame, cv2.COLOR_BGR2HSV)

    lower_yel = np.array([20,100,100])
    upper_yel = np.array([30,255,255])

    kernel = np.ones((5,5),np.uint8)

    mask = cv2.inRange(hsv, lower_yel, upper_yel)
    res = cv2.bitwise_and(frame,frame, mask= mask)
    opening = cv2.morphologyEx(mask, cv2.MORPH_OPEN,kernel)
    edges = cv2.Canny(res,100,200)

    circles = cv2.HoughCircles(opening,cv2.HOUGH_GRADIENT, 2, 32.0, 30, 550)
    circles = np.uint16(np.around(circles))


    cv2.imshow('Video', frame)
    cv2.imshow('res',res)
    cv2.imshow('Opening',opening)
    cv2.imshow('edges',edges)
    cv2.imshow('Circles',circles)
    k = cv2.waitKey(5) & 0xFF
    if k == 27:
        break

cv2.destroyAllWindows()
cap.release()