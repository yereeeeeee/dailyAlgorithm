import sys
input = sys.stdin.readline
from collections import deque

dx = [-1, 0, 1, -1]
dy = [0, -1, 0, 1]

def bfs(i, j):
    q = deque([(i, j)])
    while q:
        x, y = q.popleft()
        for d in range(4):
            nx, ny = x + dx[d], y + dy[d]
            if 0 <= nx < n and 0 <= ny < m and arr[nx][ny] == 'o':
                nnx, nny = nx + dx[d], ny + dy[d]
                if 0 <= nnx < n and 0 <= nny < m and arr[nnx][nny] == '.':
                    arr[nx][ny] = '.'
                    q.append((nx, ny))
    return 

TC = int(input())
n = 101
for tc in range(TC):
    # input
    arr = []
    if tc == 0:
        while True:
            tmp = list(input().strip())
            if tmp == []: break
            arr.append(tmp)

    else:
        i = 0
        while i < n:
            tmp = list(input().strip())
            i += 1
            if tmp == []: continue
            arr.append(tmp)
    n = len(arr)
    m = len(arr[0])

    # sol
    for i in range(n):
        for j in range(m):
            if arr[i][j] == 'o':
                bfs(i, j)
