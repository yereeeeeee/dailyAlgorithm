import sys
from itertools import combinations
from copy import deepcopy
from collections import deque

input = sys.stdin.readline

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

n, m = map(int, input().split())
arr = []
candi = []
empty_count = 0

for i in range(n):
    tmp = list(map(int, input().split()))
    arr.append(tmp)
    for j in range(n):
        if tmp[j] == 2:
            candi.append((i, j))
        elif tmp[j] == 0:
            empty_count += 1

candiIndexList = list(combinations(range(len(candi)), m))

def check(candiIndex):
    brr = deepcopy(arr)
    visited = [[-1] * n for _ in range(n)]
    q = deque()

    for idx in candiIndex:
        x, y = candi[idx]
        q.append((x, y))
        visited[x][y] = 0

    remaining_empty = empty_count
    max_time = 0

    while q:
        x, y = q.popleft()

        for d in range(4):
            nx, ny = x + dx[d], y + dy[d]

            if 0 <= nx < n and 0 <= ny < n:
                if visited[nx][ny] == -1 and brr[nx][ny] != 1:
                    visited[nx][ny] = visited[x][y] + 1
                    if brr[nx][ny] == 0:
                        remaining_empty -= 1
                        max_time = visited[nx][ny]
                    q.append((nx, ny))

    if remaining_empty == 0:
        return max_time
    else:
        return -1

answer = float('inf')
for candiIndex in candiIndexList:
    res = check(candiIndex)
    if res != -1:
        answer = min(answer, res)

print(answer if answer != float('inf') else -1)
