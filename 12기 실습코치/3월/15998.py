import sys
input = sys.stdin.readline
LIMIT = 9 * (10 ** 18)

# 최대공약수(GCD) 함수
def gcd(a, b):
    if b == 0:
        return a
    return gcd(b, a % b)

N = int(input())  # 거래 개수
firstWithdraw = True  # 첫 출금 여부 확인
kakaoMoney = 0  # 현재 계좌 잔액
maxM = 0  # 가장 큰 출금 후 잔액
res = 1  # 최소 충전 단위 (정답)

for _ in range(N):
    a, b = map(int, input().split())  # a: 입출금 금액, b: 거래 후 잔액

    if res == -1:
        continue  # 이미 불가능한 경우, 더 이상 진행할 필요 없음

    # (1) 충전 후 출금이 필요한 경우
    if a < 0 and kakaoMoney < -a:
        mValue = -a + b - kakaoMoney  # 충전에 필요한 최소 금액

        if firstWithdraw:
            # 첫 번째 출금이면 M 후보를 초기화
            maxM = b
            res = mValue
            firstWithdraw = False
        else:
            # 기존 M(res)과 새로운 충전 필요량(mValue)의 최대공약수 찾기
            mValue = gcd(res, mValue)
            maxM = max(maxM, b)  # 가장 큰 출금 후 잔액 갱신

            # 1. M 후보가 maxM보다 작은 경우에도 유효한지를 다시 검토
            if mValue < maxM:
                res = -1  # M이 존재할 수 없음
            else:
                if mValue < maxM:
                    res = -1
                else:
                    if mValue == 1 and b != 0:
                        res = -1
                    else:
                        res = min(mValue, LIMIT)

        kakaoMoney = b  # 잔액 업데이트
        continue

    # (2) 정상적인 입출금인지 확인
    if kakaoMoney + a != b:
        res = -1
    else:
        kakaoMoney = b  # 잔액 업데이트

print(res)
