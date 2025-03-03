import sys
input = sys.stdin.readline
from heapq import *

n = int(input())
t, m = map(int, input().split())
l = int(input())

graph = [[] for _ in range(n+1)]
visited = [False] * (n+1)
distance = [10001] * (n+1)

for _ in range(n):
    u, v, time, cost = map(int, input().split())
    graph[u].append((v, time, cost))
    graph[v].append((u, time, cost))
