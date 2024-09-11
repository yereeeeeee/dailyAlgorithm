import sys
input = sys.stdin.readline
from collections import deque

n = int(input())
result = 0
for _ in range(n):
    string = list(input().strip())
    string = deque(string)
    tmp = []
    while string:
        s = string.popleft()
        if s in tmp:
            if s != tmp[-1]:
                break
        else:
            tmp.append(s)
    else:
        result += 1
print(result)