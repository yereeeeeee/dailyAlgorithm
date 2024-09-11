import sys
input = sys.stdin.readline
from collections import deque

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

def goEat(i, j):
    q = deque([(i, j)])
    visited = [[0] * m for _ in range(n)]
    visited[i][j] = 1

    while q:
        x, y = q.popleft()

        if arr[x][y] == 'F':
            tmp1.append((x, y, visited[x][y]))

        for d in range(4):
            nx, ny = x + dx[d], y + dy[d]

            if 0 <= nx < n and 0 <= ny < m and visited[nx][ny] == 0 and arr[nx][ny] != 'D':
                visited[nx][ny] = visited[x][y] + 1
                q.append((nx, ny))

    if not tmp1: return -1
    return

def goHome(i, j):
    global answer

    q = deque([(i, j)])
    visited = [[0] * m for _ in range(n)]
    visited[i][j] = 1

    while q:
        x, y = q.popleft()

        if arr[x][y] == 'F':
            tmp2.append((x, y, visited[x][y]))

        for d in range(4):
            nx, ny = x + dx[d], y + dy[d]

            if 0 <= nx < n and 0 <= ny < m and visited[nx][ny] == 0 and arr[nx][ny] != 'D':
                visited[nx][ny] = visited[x][y] + 1
                q.append((nx, ny))

    if not tmp2: return -1
    return


n, m = map(int, input().split())
arr = [list(input()) for _ in range(n)]
tmp1 = []
tmp2 = []

cnt = 0
for i in range(n):
    for j in range(m):
        if arr[i][j] == 'S':
            if goEat(i, j) == -1: exit(print(-1))

        if arr[i][j] == 'H':
            if goHome(i, j) == -1: exit(print(-1))

        if arr[i][j] == 'F':
            cnt += 1

answer = float('inf')
for i in range(cnt):
    for j in range(cnt):
        if tmp1[i][0] == tmp2[i][0] and tmp1[i][1] == tmp2[i][1]:
            answer = min(answer, tmp1[i][2] + tmp2[i][2])

print(answer)