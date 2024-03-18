def move_robot(m):
    pos = (0, 0)
    direction = 1
    print(pos)
    for i in range(1, m+1):
        if direction == 1:
            dir_tuple = (0, i)
        elif direction == 2:
            dir_tuple = (i, 0)
        elif direction == 3:
            dir_tuple = (0, -i)
        else:
            dir_tuple = (-i, 0)
        pos = tuple(map(sum, zip(pos, dir_tuple)))
        yield pos
        direction += 1 if direction != 4 else 1


for v in move_robot(4):
    print(v)
