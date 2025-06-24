import sys
input = sys.stdin.readline

n = int(input())
par = [i for i in range(n+1)]

def find(x):
    if x != par[x]:
        par[x] = find(par[x])
    
    return par[x]

def union(a, b):
    a = find(a)
    b = find(b)

    if a < b:
        par[b] = a
    else:
        par[a] = b

for _ in range(n-2):
    a, b = map(int, input().split())
    union(a, b)

roots = set()
for i in range(1, n+1):
    roots.add(find(i))

print(*sorted(roots))