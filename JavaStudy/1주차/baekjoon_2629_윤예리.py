import sys
input = sys.stdin.readline

n = int(input())
weights = sorted(list(map(int, input().split())))
m = int(input())
marbles = list(map(int, input().split()))

dp = [False] * 15001

def solution(x, idx):
    if dp[x]: return

    dp[x] = True
    if idx == n-1: return

    # 1. 이번 추는 계산 안 하고 다음 추 계산
    solution(weights[idx+1], idx+1)
    # 2. 추만 두는 경우
    solution(x+weights[idx+1], idx+1)
    # 3. 추와 구슬을 같이 두는 경우
    solution(abs(x-weights[idx+1]), idx+1)

for w in range(n):
    solution(weights[w], w)

for marble in marbles:
    if marble > 15000: print('N', end=' ')
    else: print('Y' if dp[marble] else 'N', end=' ')
