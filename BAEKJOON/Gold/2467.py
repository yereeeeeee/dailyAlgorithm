import sys
input = sys.stdin.readline

n = int(input())
arr = sorted(list(map(int, input().split())))

start = 0
end = n-1
curr = abs(arr[start] + arr[end])

answer_start = start
answer_end = end

while start < end:
    tmp = arr[start] + arr[end]

    if curr > abs(tmp):
        answer_start = start
        answer_end = end
        curr = abs(tmp)

        if curr == 0:
            break

    if tmp < 0:
        start += 1
    else:
        end -= 1

print(arr[answer_start], arr[answer_end])