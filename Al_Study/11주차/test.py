import sys

input = sys.stdin.readline
from collections import deque

sys.setrecursionlimit(10 ** 9)


# 시간이 t일 때의 상태를 계산하는 함수
def move(t):
    # 모든 손님이 도착한 시간 이후이고 대기중인 손님이 없다면 종료
    if t > max(tk, key=lambda x: x[1])[1] and not waiting1 and not waiting2:
        return

    # 도착한 손님을 reception 대기열에 추가
    for idx, time in tk:
        if time == t:
            waiting1.append(idx)

    # 각 reception_desk을 순회하며 수행 가능한 작업을 처리
    for i in range(n):
        # 대기 중인 손님이 있을 경우
        if waiting1:
            # 현재 desk이 비어있다면 손님을 받아들임
            if not reception_desk[i]:
                reception_desk[i] = ai[i]  # 손님을 받아들이는 시간
                receptions[i].append(waiting1.popleft())  # 수행된 손님을 기록
            # 현재 desk이 작업을 마쳤다면 repair 대기열에 추가
            elif reception_desk[i] == 1:
                waiting2.append(reception_desk[i])
                reception_desk[i] = 0  # 작업 종료
            # 아직 작업 중이라면 남은 시간을 감소시킴
            else:
                reception_desk[i] -= 1
        # 대기 중인 손님이 없을 경우, 현재 desk이 작업을 마치면 repair 대기열에 추가
        else:
            if reception_desk[i] == 1:
                waiting2.append(reception_desk[i])
                reception_desk[i] = 0
            else:
                reception_desk[i] -= 1

    # 각 repair_desk을 순회하며 작업을 처리
    for j in range(m):
        # 대기 중인 손님이 있을 경우
        if waiting2:
            # 현재 desk이 비어있다면 손님을 받아들임
            if not repair_desk[j]:
                repair_desk[j] = bj[j]  # 수리하는데 걸리는 시간
                repairs[j].append(waiting2.popleft())  # 수행된 손님을 기록
            # 현재 desk이 작업을 마치면 작업 종료
            elif repair_desk[j] == 1:
                repair_desk[j] = 0
            # 아직 작업 중이라면 남은 시간을 감소시킴
            else:
                repair_desk[j] -= 1
        # 대기 중인 손님이 없을 경우, 현재 desk이 작업을 마치면 작업 종료
        else:
            if repair_desk[j] == 1:
                repair_desk[j] = 0
            elif repair_desk[j] > 1:
                repair_desk[j] -= 1

    # 다음 시간으로 이동하여 재귀 호출
    return move(t + 1)


T = int(input())
for tc in range(1, T + 1):
    print(f'#{tc}', end=' ')
    n, m, k, a, b = map(int, input().split())
    ai = list(map(int, input().split()))  # reception_desk의 소요 시간 리스트
    bj = list(map(int, input().split()))  # repair_desk의 소요 시간 리스트
    tk = deque(list(enumerate(map(int, input().split()), start=1)))  # 손님의 도착 시간과 번호

    # reception 대기열
    waiting1 = deque([])
    # repair 대기열
    waiting2 = deque([])

    # 남은 시간 저장
    reception_desk = [0] * n  # 각 reception_desk이 수행 중인 손님의 남은 시간
    repair_desk = [0] * m  # 각 repair_desk이 수행 중인 손님의 남은 시간

    # 다녀갔던 사람들 저장
    receptions = [[] for _ in range(n)]  # 각 reception_desk이 수행한 손님의 리스트
    repairs = [[] for _ in range(m)]  # 각 repair_desk이 수행한 손님의 리스트

    # 초기 시간부터 시작
    move(tk[0][1])

    # 결과 출력
    result = set(receptions[a - 1]) & set(repairs[b - 1])  # a번째 reception_desk과 b번째 repair_desk에서 수행된 손님의 교집합
    print(result)