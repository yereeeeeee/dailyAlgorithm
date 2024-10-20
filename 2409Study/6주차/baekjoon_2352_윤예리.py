import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))

start = 0
while start < n-1:
    if arr[start] >= arr[start+1]:
        start += 1
    else:
        break

end = n-1
while end > 0:
    if arr[end] <= arr[end-1]:
        end -= 1
    else:
        break

answer = 1
start_port = arr[start]
end_port = arr[end]
while start <= end:
    if start_port < arr[start] <= end_port:
        answer += 1
    start += 1

print(answer)