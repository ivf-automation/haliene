from django.shortcuts import render
from django.http import HttpResponse
from django.http import JsonResponse
from django.views.decorators.csrf import csrf_exempt
import cv2
import numpy
# Create your views here.

def process_image(request):
    return HttpResponse("hey this is good", status=200)

def inverte(imagem, name):
    imagem = abs(255 - imagem)
    cv2.imwrite(name, imagem)
    print("done")

def inverte2(imagem, name):
    for x in numpy.nditer(imagem, op_flags=['readwrite']):
        x = abs(255 - x)
    cv2.imwrite(name, imagem)
    print("done")

@csrf_exempt 
def upload_image(request):
    if request.method == 'POST':
        files = request.FILES.getlist('files')
        for file in files:
            img_numpy_arr = numpy.fromstring(file.read(), numpy.uint8)
            img = cv2.imdecode(img_numpy_arr, cv2.IMREAD_UNCHANGED)
            gs_imagem = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
            inverte(gs_imagem, "/Users/ramprakash/development/ivf-automation/data/invertida.png")
            inverte2(gs_imagem, "/Users/ramprakash/development/ivf-automation/data/invertida2.png")
            # perform preprocessing
            print(file)
    return HttpResponse("hey this is good", status=200)

@csrf_exempt 
def upload_test(request):
    # if request.method == 'POST':
    #     pass
        # files = request.FILES.getlist('files')
        # for file in files:
        #     img_numpy_arr = numpy.fromstring(file.read(), numpy.uint8)
        #     img = cv2.imdecode(img_numpy_arr, cv2.IMREAD_UNCHANGED)
        #     gs_imagem = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
        #     inverte(gs_imagem, "/Users/ramprakash/development/ivf-automation/data/invertida.png")
        #     inverte2(gs_imagem, "/Users/ramprakash/development/ivf-automation/data/invertida2.png")
        #     # perform preprocessing
        #     print(file)
    return JsonResponse({"id": 401, "message":"response works"}, status=200)