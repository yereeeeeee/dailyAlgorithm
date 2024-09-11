import sys
input = sys.stdin.readline

n = int(input())
for _ in range(n):
    tmp = list(map(int, input().split()))
    t, lst = tmp[0], tmp[1:]

    army = [0] * 201
    for i in range(t):
        army[lst[i]] += 1
        if army[lst[i]] > t/2:
            print(lst[i])
            break
    else:
        print('SYJKGW')