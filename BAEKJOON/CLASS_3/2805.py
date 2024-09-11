import sys
input = sys.stdin.readline

n, m = map(int, input().split())
height = list(map(int, input().split()))

start, end = 1, max(height)

while start <= end:
    sum = 0
    mid = (start + end) // 2

    for h in height:
        if h > mid:
            sum += (h - mid)

    if sum < m:
        end = mid - 1
    else:
        start = mid + 1

print(end)