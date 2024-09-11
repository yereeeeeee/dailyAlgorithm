from heapq import *
import sys
input = sys.stdin.readline

n = int(input())
q = []
for _ in range(n):
    x = int(input())
    if x > 0:
        heappush(q, x)
    else:
        if q:
            print(heappop(q))
        else:
            print(0)