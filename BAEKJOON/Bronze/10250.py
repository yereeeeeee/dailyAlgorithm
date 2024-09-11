T = int(input())
for tc in range(T):
    h, w, n = list(map(int, input().split()))

    result = []
    for i in range(1, w+1):
        for j in range(1, h+1):
            result.append(j*100+i)

    print(result[n-1])