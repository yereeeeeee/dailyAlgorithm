import math
import sys
input = sys.stdin.readline
from collections import deque

n = int(input())
arr = sorted([int(input()) for _ in range(n)])
p = math.floor(n*0.15+0.5)
arr = deque(arr)

for _ in range(p):
    arr.pop()
    arr.popleft()

if not arr:
    exit(print(0))
print(math.floor((sum(arr)/len(arr))+0.5))