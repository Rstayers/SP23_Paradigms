
class move_robot:
    def __init__(self, m):
        self.i = 1
        self.m = m
        self.direction = 1
        self.pos = (0, 0)
        print(self.pos)

    def __iter__(self):
        return self

    def __next__(self):
        while self.i <= self.m:
            if self.direction == 1:
                dir_tuple = (0, self.i)
            elif self.direction == 2:
                dir_tuple = (self.i, 0)
            elif self.direction == 3:
                dir_tuple = (0, -self.i)
            else:
                dir_tuple = (-self.i, 0)

            # add the movement to current position
            self.pos = tuple(map(sum, zip(self.pos, dir_tuple)))
            # change direction
            self.direction += 1 if self.direction != 4 else 1

            self.i += 1
            return self.pos

        else:
            raise StopIteration()


for v in move_robot(4):
    print(v)
