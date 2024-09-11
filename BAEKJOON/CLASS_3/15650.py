from itertools import combinations
n, m = map(int, input().split())
arr = [i for i in range(1, n+1)]
result = list(combinations(arr, m))
for r in result:
    print(*r)