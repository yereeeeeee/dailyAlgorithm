N, M = map(int, input().split(' '))
arr = []
for n in range(N):
    arr.append(n+1)
for m in range(M):
    i, j = map(int, input().split(' '))
    b = list(arr[i-1:j])
    b.reverse()
    arr[i-1:j] = b
for a in arr:
    print(a, end=' ')