from collections import deque
import sys
input = sys.stdin.readline

n, k = map(int, input().split())

array = list(input().split())
visited = set("".join(array))

target = sorted(array)

answer = -1

q = deque([[array, 0]])

while q:
  arr, cnt = q.popleft()
  if arr == target:
    answer = cnt
    break
  for i in range(n-k+1):
    rarr = arr[i:i+k]
    rarr.reverse()
    arr2 = arr[:i] + rarr + arr[i+k:]
    str2 = "".join(arr2)
    if str2 not in visited:
      q.append([arr2, cnt+1])
      visited.add(str2) #set에 원소 추가

print(answer)