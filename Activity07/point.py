import math


class Point:
    def __init__(self, x, y):
        self.x = x
        self.y = y

    def print(self):
        print(f'({self.x}, {self.y})')


def distance(p1, p2):
    return math.sqrt(math.pow(p2.x - p1.x, 2) + math.pow(p2.y-p1.y, 2))

