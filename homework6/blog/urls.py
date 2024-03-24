
from django.contrib import admin
from django.urls import path
from . import views

urlpatterns = [
    path('<int:post_id>/', views.view, name='view'),
    path('', views.index, name='index'),
]

