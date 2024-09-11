m = int(input())
arr = [i for i in range(4)]
for _ in range(m):
    x, y = map(int, input().split())
    arr[x], arr[y] = arr[y], arr[x]
print(arr.index(1))