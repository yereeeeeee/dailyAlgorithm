from collections import deque
import sys
input = sys.stdin.readline

n = int(input())
q = deque([])
for _ in range(n):
    k = list(map(str, input().split()))

    if k[0] == 'push':
        q.append(k[1])

    elif k[0] == 'pop':
        if q:
            print(q.popleft())
        else:
            print(-1)

    elif k[0] == 'size':
        print(len(q))

    elif k[0] == 'empty':
        if q:
            print(0)
        else:
            print(1)

    elif k[0] == 'front':
        if q:
            print(q[0])
        else:
            print(-1)

    elif k[0] == 'back':
        if q:
            print(q[-1])
        else:
            print(-1)
