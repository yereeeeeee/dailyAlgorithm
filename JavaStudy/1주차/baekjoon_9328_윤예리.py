import sys
input = sys.stdin.readline
from collections import deque
from copy import *

def bfs(r, c):
    q = deque([])
    visited = [[0] * 100 for _ in range(100)]
    q.append((r, c))
    visited[r][c] = 1
    keys_copy = deepcopy(keys)

    while q:
        pass

TC = int(input())
for _ in range(TC):
    h, w = map(int, input().split())
    arr = [list(input()) for _ in range(h)]
    keys = list(input())

    for i in range(h):
        for j in range(w):
            # 끄트머리 일 때
            if i == 0 or i == h-1 or j == 0 or j == w-1:
                if arr[i][j] != '*': bfs(i, j)
