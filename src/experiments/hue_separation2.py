
import cv2
import numpy as np
 
def nothing(x):
    pass

 


def separate_living_sperms():
    frame = cv2.imread('sample1.jpg')
    # get current positions of the trackbars
    ilowH = 65
    ihighH = 156
    ilowS = 80
    ihighS = 255
    ilowV = 0
    ihighV = 189
    
    hsv = cv2.cvtColor(frame, cv2.COLOR_BGR2HSV)
    lower_hsv = np.array([ilowH, ilowS, ilowV])
    higher_hsv = np.array([ihighH, ihighS, ihighV])
    # Apply the cv2.inrange method to create a mask
    mask = cv2.inRange(hsv, lower_hsv, higher_hsv)
    # Apply the mask on the image to extract the original color
    frame = cv2.bitwise_and(frame, frame, mask=mask)
    cv2.imshow('image', frame)
    cv2.imwrite('only_living.jpg', frame)
    # Press q to exit
    if cv2.waitKey(1) & 0xFF == ord('q'):
        cv2.destroyAllWindows()
        exit()
        

if __name__ == '__main__':
    separate_living_sperms()    
