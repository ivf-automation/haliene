import cv2
import numpy as np
 
def nothing(x):
    pass

 
# Create a window
cv2.namedWindow('image')
 
# create trackbars for color change
cv2.createTrackbar('lowH','image',0,179,nothing)
cv2.createTrackbar('highH','image',179,179,nothing)
 
cv2.createTrackbar('lowS','image',0,255,nothing)
cv2.createTrackbar('highS','image',255,255,nothing)
 
cv2.createTrackbar('lowV','image',0,255,nothing)
cv2.createTrackbar('highV','image',255,255,nothing)
prev_frame = cv2.imread('images/input/sample1.jpg')
i = 0
while(True):
    
    frame = prev_frame
    # get current positions of the trackbars
    ilowH = 65 # cv2.getTrackbarPos('lowH', 'image')
    ihighH = 156 # cv2.getTrackbarPos('highH', 'image')
    ilowS = 80 # cv2.getTrackbarPos('lowS', 'image')
    ihighS = 255 # cv2.getTrackbarPos('highS', 'image')
    ilowV = 0 # cv2.getTrackbarPos('lowV', 'image')
    ihighV = 189 # cv2.getTrackbarPos('highV', 'image')
    
    # if i % 1000000000:
    #     print("ilowH", ilowH )
    #     print("ihighH", ihighH )
    #     print("ilowS", ilowS )
    #     print("ihighS", ihighS )
    #     print("ilowV", ilowV )
    #     print("ihighV", ihighV )
    # print('ilows', ilowS)
    # convert color to hsv because it is easy to track colors in this color model
    hsv = cv2.cvtColor(frame, cv2.COLOR_BGR2HSV)
    lower_hsv = np.array([ilowH, ilowS, ilowV])
    higher_hsv = np.array([ihighH, ihighS, ihighV])
    # Apply the cv2.inrange method to create a mask
    mask = cv2.inRange(hsv, lower_hsv, higher_hsv)
    # Apply the mask on the image to extract the original color
    frame = cv2.bitwise_and(frame, frame, mask=mask)
    cv2.imshow('image', frame)
    # Press q to exit
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break
    i+=1

cv2.destroyAllWindows()