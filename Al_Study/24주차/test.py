import sys
input = sys.stdin.readline

# 테스트 케이스는 총 3개
for _ in range(3):
    N = int(input())  # 동전 종류의 수 입력
    coins = {}  # 동전 종류별 개수를 저장할 딕셔너리
    target = 0  # 모든 동전의 합

    # 각 동전 종류와 그 개수를 입력 받음
    for _ in range(N):
        a, b = map(int, input().split())
        coins[a] = b
        target += a * b  # 전체 동전의 합을 구함

    # 전체 동전의 합이 홀수인 경우 절반으로 나눌 수 없으므로 0 출력
    if target & 1:
        print(0)
        continue

    target //= 2  # 목표 금액은 전체 동전의 합의 절반

    # dp 배열 초기화: dp[n]은 n원을 만들 수 있는지 여부를 나타냄
    dp = [1] + [0] * target

    # 각 동전 종류에 대해 처리
    for coin in coins:
        # dp 배열을 뒤에서부터 업데이트하여 중복 사용을 방지
        for money in range(target, coin - 1, -1):
            if dp[money - coin]:
                # 해당 금액에서 동전을 추가로 더한 금액을 만들 수 있는지 확인
                for j in range(coins[coin]):
                    if money + coin * j <= target:
                        dp[money + coin * j] = 1

    # 목표 금액을 만들 수 있으면 1, 없으면 0 출력
    print(dp[target])
