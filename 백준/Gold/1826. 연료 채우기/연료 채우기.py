import sys
from heapq import *

input = sys.stdin.readline

n = int(input())
arr = [tuple(map(int, input().split())) for _ in range(n)]

end, gas = map(int, input().split())

arr.sort()  # 거리 기준 정렬
q = []
idx = 0
answer = 0

i = 0
while gas < end:
    # 갈 수 있는 주유소 지나가면서 모두 우선순위 큐에 넣기
    while i < n and arr[i][0] <= gas:
        heappush(q, -arr[i][1])
        i += 1

    if not q:
        exit(print(-1))

    # 가장 연료 많이 주는 주유소에서 채우기
    gas += -heappop(q)
    answer += 1

print(answer)
