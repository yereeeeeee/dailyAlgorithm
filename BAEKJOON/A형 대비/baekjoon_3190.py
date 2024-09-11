import sys
input = sys.stdin.readline

# 상, 우, 하, 좌
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

def dummy(sec, d, x, y):

    if dir[sec-1]:
        if dir[sec-1] == 'L':
            d = (d-1)%4
        else:
            d = (d+1)%4

    nx = x + dx[d]
    ny = y + dy[d]

    if 0 <= nx < n and 0 <= ny < n:
        if arr[nx][ny] == 0:
            arr[nx][ny] = 1
            baaam.append((nx, ny))

            # baaam에서 popleft해서 그 자리 0으로 만들예정
            arr[x][y] = 0
            return dummy(sec+1, d, nx, ny)

        elif arr[nx][ny] == 2:
            arr[nx][ny] = 1
            return dummy(sec+1, d, nx, ny)

        else:
            return sec

    else:
        return sec

n = int(input())
arr = [[0] * n for _ in range(n)]

# 뱀 = 1
# 사과 = 2
k = int(input())
for _ in range(k):
    r, c = map(int, input().split())
    arr[r-1][c-1] = 2

l = int(input())
dir = [0] * 10000
for _ in range(l):
    x, c = map(str, input().split())
    x = int(x)
    dir[x] = c

baaam = []
print(dummy(1, 1, 0, 0))