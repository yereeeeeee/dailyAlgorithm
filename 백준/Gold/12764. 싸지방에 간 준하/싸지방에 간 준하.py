import sys
input = sys.stdin.readline
from heapq import *

n = int(input())
times = [tuple(map(int, input().split())) + (i,) for i in range(n)]  # (시작, 끝, 인덱스)
times.sort()  # 시작 시간 기준 정렬

# 사용 중인 컴퓨터: (종료시간, 컴퓨터번호)
in_use = []
# 비어있는 컴퓨터 번호
available = []

# 결과 저장
answer = [0] * n
computer_count = 0
usage_count = []

for start, end, idx in times:
    # 끝난 컴퓨터 회수
    while in_use and in_use[0][0] <= start:
        finish_time, comp_num = heappop(in_use)
        heappush(available, comp_num)
    
    if available:
        comp = heappop(available)
    else:
        comp = computer_count
        computer_count += 1
        usage_count.append(0)

    answer[idx] = comp
    usage_count[comp] += 1
    heappush(in_use, (end, comp))

print(computer_count)
print(' '.join(map(str, usage_count)))
