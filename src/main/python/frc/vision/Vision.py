import cv2
import numpy as np
#cv2 is OpenCV

cap = cv2.VideoCapture(0)
while True:
    _, frame = cap.read()
    hsv = cv2.cvtColor(frame, cv2.COLOR_BGR2HSV)

    lower_yel = np.array([20,100,100])
    upper_yel = np.array([30,255,255])

    mask = cv2.inRange(hsv, lower_yel, upper_yel)
    res = cv2.bitwise_and(frame,frame, mask= mask)
    edges = cv2.Canny(res,100,200)
    median = cv2.medianBlur(res,15)

    cv2.imshow('Median Blur',median)
    cv2.imshow('Video', frame)
    cv2.imshow('edges',edges)

    k = cv2.waitKey(5) & 0xFF
    if k == 27:
        break

cv2.destroyAllWindows()
cap.release()