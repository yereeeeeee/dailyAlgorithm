import sys
input = sys.stdin.readline
from collections import deque

n = int(input())
indegree = [0] * (n+1)
graph = [[] for _ in range(n+1)]
cost = [0] * (n+1)
dp = [0] * (n+1)  # 각 작업까지의 최소 시간

for i in range(1, n+1):
    data = list(map(int, input().split()))
    cost[i] = data[0]
    indegree[i] = data[1]
    for prev in data[2:]:
        graph[prev].append(i)

q = deque()
for i in range(1, n+1):
    if indegree[i] == 0:
        q.append(i)
        dp[i] = cost[i]

while q:
    cur = q.popleft()
    for nxt in graph[cur]:
        indegree[nxt] -= 1
        dp[nxt] = max(dp[nxt], dp[cur] + cost[nxt])
        if indegree[nxt] == 0:
            q.append(nxt)

print(max(dp))
