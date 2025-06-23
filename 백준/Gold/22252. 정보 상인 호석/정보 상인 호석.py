import sys
import heapq

input = sys.stdin.readline

n = int(input())
info = dict()

result = 0

for _ in range(n):
    c = list(input().split())
    
    k = int(c.pop(0))
    name = c.pop(0)
    
    if k == 1:
        num = c.pop(0)

        if name not in info:
            info[name] = []
        
        data = list(map(int, c))
        for d in data:
            heapq.heappush(info[name], -d)

    else:
        b = int(c.pop())

        if name not in info:
            continue
        
        for i in range(min(b, len(info[name]))):
            result += -heapq.heappop(info[name])

print(result)
