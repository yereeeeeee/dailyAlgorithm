import sys
input = sys.stdin.readline

h, w = map(int, input().split())
blocks = list(map(int, input().split()))

left, right = 0, w - 1  # 양쪽 끝에서 시작
left_max, right_max = blocks[left], blocks[right]  # 현재 왼쪽/오른쪽에서 최고 높이
cnt = 0

while left < right:
    if left_max < right_max:
        left += 1
        left_max = max(left_max, blocks[left])
        cnt += max(0, left_max - blocks[left])
    else:
        right -= 1
        right_max = max(right_max, blocks[right])
        cnt += max(0, right_max - blocks[right])

print(cnt)
