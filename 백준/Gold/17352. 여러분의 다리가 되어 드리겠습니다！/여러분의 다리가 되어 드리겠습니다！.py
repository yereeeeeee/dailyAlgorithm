import sys
input = sys.stdin.readline

n = int(input())
par = [i for i in range(n+1)]

def find(x):
    if x != par[x]:
        par[x] = find(par[x])  # 경로 압축
    return par[x]

def union(a, b):
    a = find(a)
    b = find(b)
    
    if a != b:
        if a < b:
            par[b] = a
        else:
            par[a] = b

for _ in range(n-2):
    a, b = map(int, input().split())
    union(a, b)

# 각 노드의 실제 루트를 찾아서 저장
roots = set()
for i in range(1, n+1):
    roots.add(find(i))

print(*sorted(roots))