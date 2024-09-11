N, M = map(int, input().split(' '))
ball = [0] * N

for m in range(M):
    i, j, k = map(int, input().split(' '))
    for a in range(i-1, j):
        ball[a] = k

for b in ball:
    print(b, end=' ')