def

n, m, k = map(int, input().split())
aij = []
for _ in range(n):
    a = list(map(int, input().split()))
    aij.append(a)

rotate_arr = [[] for _ in range(n)]
# 회전
for _ in range(k):
    r, c, s = map(int, input().split())
