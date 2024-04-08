from datetime import datetime
from django.utils.timezone import make_aware
from django.db.models import Sum

# Q1.1: Write a query that retrieve all questions: 
all_questions = Question.objects.all()

# Q1.2: Write a query that retrieve all the choices for the question with a primary key equals to 1:
choices_for_q1 = Choice.objects.filter(question_id = 1)

start_date = make_aware(datetime(2023, 1, 1))
end_date = make_aware(datetime(2023, 12, 31))
# Q1.3: Write a query that retrieve all the questions published in 2023: 
questions_in_2023 = Question.objects.filter(pub_date__range=(start_date, end_date))

# Q1.4: Write a query that sum up the total number of votes for all choices for the question with ID = 1: 
total_votes = Choice.objects.filter(question_id=1).aggregate(total=Sum('votes'))['total']


# Q1.5: Retrieve all questions sorted by publication date in descending order: 
questions_desc_order = Question.objects.all().order_by('-pub_date')

