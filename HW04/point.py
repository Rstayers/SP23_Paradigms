import math


class Point:
    def __init__(self, x, y):
        self.x = x
        self.y = y

    def distance_to_origin(self):
        return math.sqrt(math.pow(0 - self.x, 2) + math.pow(0 - self.y, 2))
    
    def print(self):
        print(f'({self.x}, {self.y})')

    def __gt__(self, other):
        return self.distance_to_origin() > other.distance_to_origin()

    def __ge__(self, other):
        return self.distance_to_origin() >= other.distance_to_origin()

    def __eq__(self, other):
        return self.distance_to_origin() == other.distance_to_origin()

    def __le__(self, other):
        return self.distance_to_origin() <= other.distance_to_origin()

    def __lt__(self, other):
        return self.distance_to_origin() < other.distance_to_origin()


p1 = Point(2,3)
p2 = Point(-3,1)
p3 = Point(-2,-3)
print(p1 > p2)
print(p1 == p2)
print(p1 < p2)
print(p1 == p3)




