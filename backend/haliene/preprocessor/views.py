from django.shortcuts import render
from django.http import HttpResponse

# Create your views here.

def process_image(request):
    return HttpResponse("hey this is good", status=200)