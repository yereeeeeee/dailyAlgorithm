N, M = map(int, input().split(' '))
ball = []
for a in range(1, N+1):
    ball.append(a)

for m in range(M):
    i, j = map(int, input().split(' '))
    b = 0
    b = ball[j-1]
    ball[j-1] = ball[i-1]
    ball[i-1] = b

for r in ball:
    print(r, end=' ')