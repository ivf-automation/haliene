from django.urls import path
from . import views
from django.conf import settings
from django.conf.urls.static import static


urlpatterns = [
    path('',views.process_image,name="process_image"),
    path('upload_test/',views.upload_test,name="upload_test"),
    path('upload/',views.upload_image,name="upload_image")
] + static(settings.STATIC_URL, document_root=settings.STATIC_ROOT)