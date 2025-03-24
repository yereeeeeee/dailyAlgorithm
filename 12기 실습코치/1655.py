import sys
input = sys.stdin.readline
import heapq

n = int(input())
left = []
right = []

for i in range(n):
    m = int(input())

    # 맨 처음 값 왼쪽에 저장
    # 왼쪽의 최대값보다 작거나 같으면
    if not left or m <= -left[0]:
        heapq.heappush(left, -m)
    else:
        heapq.heappush(right, m)
    
    # 왼쪽이 더 많으면 오른쪽으로 옮겨줌 (왼쪽이 하나 더 많거나 같게 유지 > 왼쪽에서 중앙값 뺄거임)
    if len(left) > len(right) + 1:
        heapq.heappush(right, -heapq.heappop(left))
    # 오른쪽이 더 많으면 옮겨줌
    elif len(left) < len(right):
        heapq.heappush(left, -heapq.heappop(right))
    
    # 왼쪽의 최대값 출력
    print(-left[0])

