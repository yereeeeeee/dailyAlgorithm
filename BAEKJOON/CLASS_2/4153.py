import math
while True:
    ls = sorted(list(map(int, input().split())))
    if ls == [0, 0, 0]:
        break

    if ls[2] == math.sqrt(ls[0]**2+ls[1]**2):
        print('right')
    else:
        print('wrong')