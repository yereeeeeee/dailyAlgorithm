from heapq import *

x = int(input())
arr = []
heappush(arr, 64)

while sum(arr) > x:
    target = heappop(arr) // 2
    if sum(arr) + target >= x:
        heappush(arr, target)
    else:
        heappush(arr, target)
        heappush(arr, target)

    if sum(arr) == x:
        break

print(len(arr))