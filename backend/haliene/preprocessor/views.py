from django.shortcuts import render
from django.http import HttpResponse
from django.http import JsonResponse
from django.views.decorators.csrf import csrf_exempt
import cv2
import numpy
from django.conf import settings

from .utils import generate_random_id
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
    print(request.__dict__)
    print(request.FILES.getlist('image'))
    print()
    # print(request.FILES.getlist('image'))
    # file = request.FILES.getlist('image')
    file = request.FILES.getlist('image')[0]

    img_numpy_arr = numpy.fromstring(file.read(), numpy.uint8)
    img = cv2.imdecode(img_numpy_arr, cv2.IMREAD_UNCHANGED)
    gs_imagem = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
    file_name = generate_random_id(15)
    file2_name = generate_random_id(15)
    inverte(gs_imagem, "{STATIC_ROOT}/{FILE_NAME}.png".format(STATIC_ROOT=settings.STATIC_ROOT, FILE_NAME=file_name))
    # inverte2(gs_imagem, "{STATIC_ROOT}/{FILE_NAME}.png".format(STATIC_ROOT=settings.STATIC_ROOT, FILE_NAME=file2_name))
    # perform preprocessing
    print(file)
    # print(file)
    # print('file read')
    # content = file.read()
    # with open('/Users/ramprakash/development/ivf-automation/data/testing_images/test.png', 'wb') as img:
    #     img.write(content)
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
    return JsonResponse({"id": 401, "message":"processing works", "image_path":file_name}, status=200)