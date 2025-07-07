import sys
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    n = int(input())

    # 등차수열
    # sum = n(n+1)//2
    # sum이 n을 넘지 않는 선에서 제일 가까운 값

    result = 0
    start = 0
    end = n

    while start <= end:
        mid = (start+end)//2

        if int((mid*(mid+1))//2) <= n:
            start = mid + 1
            result = mid

        else:
            end = mid - 1

    print(result)
