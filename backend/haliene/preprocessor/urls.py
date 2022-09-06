from django.urls import path
from . import views


urlpatterns = [
    path('',views.process_image,name="process_image"),
    path('upload/',views.upload_image,name="upload_image")
]