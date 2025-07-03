import sys
from collections import deque

input = sys.stdin.readline

def solve():
    n, t = map(int, input().split())

    # 바위들을 x좌표를 기준으로 딕셔너리에 저장합니다.
    # {x_coord: [y1, y2, ...]} 형태
    # 각 x_coord에 해당하는 y값들은 정렬해두면 나중에 탐색할 때 조금 더 효율적일 수 있습니다.
    rocks_by_x = {}
    for _ in range(n):
        x, y = map(int, input().split())
        if x not in rocks_by_x:
            rocks_by_x[x] = []
        rocks_by_x[x].append(y)
    
    # 각 x좌표에 대해 y좌표 리스트를 정렬합니다. (선택 사항이지만 도움이 될 수 있음)
    for x_val in rocks_by_x:
        rocks_by_x[x_val].sort()

    q = deque([(0, 0, 0)])  # (현재 x, 현재 y, 점프 횟수)
    visited = {(0, 0)}      # 방문한 바위를 저장하는 set

    while q:
        x, y, cnt = q.popleft()

        # 목표 지점에 도달했는지 확인
        if y >= t:
            print(cnt) # BFS이므로 가장 먼저 도달한 것이 최단 경로
            return # 즉시 프로그램 종료

        # 현재 바위 (x, y)에서 갈 수 있는 다음 바위들을 탐색
        # x좌표는 x-2 부터 x+2 까지 5칸 범위 내를 확인
        for dx in range(-2, 3):
            next_x_coord = x + dx
            
            # 해당 x좌표에 바위가 있다면
            if next_x_coord in rocks_by_x:
                # 해당 x좌표의 모든 y좌표들을 확인
                for next_y_candidate in rocks_by_x[next_x_coord]:
                    # y좌표도 현재 y에서 2칸 이내에 있는지 확인
                    if abs(next_y_candidate - y) <= 2:
                        next_rock = (next_x_coord, next_y_candidate)
                        
                        # 아직 방문하지 않은 바위라면 큐에 추가하고 방문 처리
                        if next_rock not in visited:
                            visited.add(next_rock)
                            q.append((next_x_coord, next_y_candidate, cnt + 1))
                    # 중요 최적화: y_candidate 리스트가 정렬되어 있으므로,
                    # 만약 next_y_candidate가 y+2 보다 크다면,
                    # 이후의 y값들은 무조건 y+2보다 커서 더 이상 볼 필요가 없습니다.
                    elif next_y_candidate > y + 2:
                         break 
    
    # 큐가 비었는데도 목표에 도달하지 못했다면 -1 출력
    print(-1) 

solve()