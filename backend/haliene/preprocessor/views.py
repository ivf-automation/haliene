from django.shortcuts import render
from django.http import HttpResponse
from django.views.decorators.csrf import csrf_exempt
# Create your views here.

def process_image(request):
    return HttpResponse("hey this is good", status=200)

@csrf_exempt 
def upload_image(request):
    if request.method == 'POST':
        files = request.FILES.getlist('files')
        for file in files:
            # perform preprocessing
            print(file)
    return HttpResponse("hey this is good", status=200)