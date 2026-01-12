import sys
input = sys.stdin.readline
from collections import deque

R, C, T = map(int, input().split())
arr = [list(input().rstrip()) for _ in range(R)]

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

# S들에 인덱스 부여
s_idx = {}
idx = 0
sx = sy = 0
for i in range(R):
    for j in range(C):
        if arr[i][j] == 'G':
            sx, sy = i, j
        elif arr[i][j] == 'S':
            s_idx[(i, j)] = idx
            idx += 1

def popcount(x):
    return x.bit_count()  # 파이썬 3.8이면 bin(x).count("1")

ans = 0
q = deque([(sx, sy, 0, 0)])  # x, y, time, mask
visited = set([(sx, sy, 0, 0)])  # (x,y,time,mask)

while q:
    x, y, t, mask = q.popleft()
    ans = max(ans, popcount(mask))

    if t == T:
        continue

    for d in range(4):
        nx, ny = x + dx[d], y + dy[d]
        if 0 <= nx < R and 0 <= ny < C and arr[nx][ny] != '#':
            nmask = mask
            if (nx, ny) in s_idx:
                nmask |= (1 << s_idx[(nx, ny)])
            state = (nx, ny, t + 1, nmask)
            if state not in visited:
                visited.add(state)
                q.append(state)

print(ans)
