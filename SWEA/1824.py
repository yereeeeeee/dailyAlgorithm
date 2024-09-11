import random
T = int(input())

for tc in range(1, T+1):
    R, C = map(int, input().split())
    arr = [list(map(str, input())) for _ in range(R)]
    i = 0
    j = 0
    here = arr[i][j]
    memory = 0

    while here != '@':
        if here.isnumeric():
            memory = here
        elif here == '<':
            j -= 1
        elif here == '>':
            j += 1
        elif here == '^':
            i -= 1
        elif here == 'v':
            i -= 1
        elif here == '_':
            if memory == 0:
                j += 1
            else:
                j -= 1
        elif here == '|':
            if memory == 0:
                i += 1
            else:
                i -= 1
        elif here == '?':
            rd_move = [i+=1, i-=1, j+=1, j-=1]
            random.choice(rd_move)
        elif here == '.':
            pass
        elif here == '+':
            if memory == 15:
                memory = 0
            else:
                memory += 1
        elif here == '-':
            if memory == 0:
                memory = 15
            else:
                memory -= 1
    print('YES')