import sys
from heapq import heappush, heappop

input = sys.stdin.readline

n = int(input())
lectures = []
for _ in range(n):
    num, start, end = map(int, input().split())
    lectures.append((start, end, num))

# 시작 시간 기준 정렬
lectures.sort()

# 우선순위 큐: (끝나는 시간, 강의실 번호)
heap = []
room_count = 0
room_map = dict()

for start, end, num in lectures:
    if heap and heap[0][0] <= start:
        finish, room = heappop(heap)
    else:
        room_count += 1
        room = room_count
    heappush(heap, (end, room))
    room_map[num] = room

# 출력
print(room_count)
for num in sorted(room_map):
    print(room_map[num])
