from django.shortcuts import render
from .models import Post
from django.shortcuts import get_object_or_404

def index(request):
    posts = Post.objects.all().order_by('-pub_date')  # Assuming you want the newest posts first
    return render(request, 'blog/index.html', {'posts': posts})


def view(request, post_id):
    post = get_object_or_404(Post, pk=post_id)
    return render(request, 'blog/view.html', {'post': post})

