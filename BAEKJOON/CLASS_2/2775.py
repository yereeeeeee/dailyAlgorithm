T = int(input())
for tc in range(T):
    k = int(input())
    n = int(input())

    arr = [[i for i in range(n+1)] for _ in range(k)]
    result = 0
    for i in range(k):
        result += sum(arr[i])
    print(result)